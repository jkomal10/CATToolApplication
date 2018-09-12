package com.cattool.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cattool.application.entity.Users;
import com.cattool.application.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserRepository	userRepository; 
	
	 @GetMapping("/getuser")
		public String getuser() {
			return "Welcome to user controller!!!!!";
			
	  }
	 
	 @PostMapping("/addUser")
		public Users saveUser(@RequestBody Users user){
		 
			return userRepository.save(user);
		}
	 
	 @GetMapping("/getAllUsers")
		public List<Users> getAllUsers() {
			return userRepository.findAll();
			
	  }
	 
	 @PostMapping("/getbyUserName/{firstName}")
		public Users getUserByName(@PathVariable String firstName) {
		 	Users user=new Users();
		 	user=userRepository.findByUserName(firstName);
		 	if(user!=null)
		 	{
		 		return userRepository.findByUserName(firstName);
		 	}
		 	else
		 	{
		 		System.out.println("Username or password is wrong!!");
		 		return null;
		 	}
	  }
	 
}
