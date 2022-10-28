package com.example.demo.UserDetails;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entity.Roles;
import com.example.demo.Entity.Users;
import com.example.demo.Repository.UserRepository;
@Service
public class UserDetailsServiceImp implements UserDetailsService{

	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	@Transactional(readOnly =true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userRepository.getUserByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("user not found.");
		}
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for(Roles role: user.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
	}

}
