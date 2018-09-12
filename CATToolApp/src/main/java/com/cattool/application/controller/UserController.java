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
import com.cattool.application.service.CattoolService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	CattoolService	userService; 
	
	 @GetMapping("/getuser")
		public String getuser() {
			return "Welcome to user controller!!!!!";
			
	  }
	 
	 @PostMapping("/addUser")
		public Users saveUser(@RequestBody Users user){
		 
			return userService.addUser(user);
		}
	 
	 @GetMapping("/getAllUsers")
		public List<Users> getAllUsers() {
			return userService.getUsers();
			
	  }
	 
	 @PostMapping("/getbyUserName/{firstName}")
		public Users getUserByName(@PathVariable String firstName) {
		 	Users user=new Users();
		 	user=userService.findById(firstName);
		 	if(user!=null)
		 	{
		 		return userService.findById(firstName);
		 	}
		 	else
		 	{
		 		System.out.println("Username or password is wrong!!");
		 		return null;
		 	}
	  }
	 
}
