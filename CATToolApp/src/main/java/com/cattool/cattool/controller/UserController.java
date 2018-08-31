package com.cattool.cattool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cattool.cattool.entity.Users;
import com.cattool.cattool.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserRepository	userRepository; 
	
	 @GetMapping("/getuser")
		public String getuser() {
			return "Welcome to user controller!!!!!";
			
	  }
	 
	 @GetMapping("/getAllUsers")
		public List<Users> getAllUsers() {
			return userRepository.findAll();
			
	  }
	 
	 @PostMapping("/getbyUserName")
		public Users getUserByName(@RequestBody Users username) {
		 	Users user=new Users();
		 	user=userRepository.findByUserName(username.getUserName());
		 	if(user!=null)
		 	{
		 		return userRepository.findByUserName(username.getUserName());
		 	}
		 	else
		 	{
		 		System.out.println("Username or password is wrong!!");
		 		return null;
		 	}
	  }
	 
}
