package com.cattool.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cattool.application.entity.Users;
import com.cattool.application.repository.UserRepository;

@Service
public class CattoolService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<Users> getAllUsers() {
		return userRepository.findAll();
	}
		
	public Users findByUserName(String userName) {
		return userRepository.findByUserName(userName);
		
	}
	
}
