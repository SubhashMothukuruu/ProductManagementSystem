package com.example.demo.Service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entity.Users;
import com.example.demo.Repository.RolesRepository;
import com.example.demo.Repository.UserRepository;



@Service
public class UserServiceImp implements UserService{
	
	
	@Autowired
	UserRepository userRepository;
	
	
	@Autowired
	RolesRepository rolesRepository;
	
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Transactional
	public Users save(Users user) {
		
	user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	user.setRoles(new HashSet<>(rolesRepository.findAll()) );
		return userRepository.save(user);
	}

	@Override
	public Users findByUserName(String username) {
		return userRepository.getUserByUsername(username);
	}

}
