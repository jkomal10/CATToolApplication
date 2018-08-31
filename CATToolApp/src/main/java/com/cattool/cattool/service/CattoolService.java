package com.cattool.cattool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cattool.cattool.entity.Users;
import com.cattool.cattool.repository.UserRepository;

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
