package com.example.demo.Service;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Users;

@Service
public interface UserService {
	
	Users save(Users user);
	Users findByUserName(String username);
	
	

}
