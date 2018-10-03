package com.cattool.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cattool.application.entity.AssessmentQuestions;
import com.cattool.application.entity.Users;
import com.cattool.application.repository.UserRepository;
import com.cattool.application.service.UserService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService	userService; 
	
	@GetMapping("/getAll")
	public List<Users> findAllUsers()
	{
		return userService.findAllUsers();
	}
	
	@GetMapping("/getById/{userName}/{password}")
	public Users findById(@PathVariable String userName,@PathVariable String password)
	{
		return userService.findById(userName,password);
	}
	
	@PostMapping("/addUser/create")
	public Users saveUser(@RequestBody Users user)
	{
		System.out.println("post method*****************");
		return userService.saveUser(user);
	}
	 
	@DeleteMapping("/deleteUserById/{userId}")
	public void deleteById(@PathVariable int userId)
	{
		System.out.println("delete method*****************");
		userService.deleteById(userId);
	}
	
	@PutMapping("/updateUser/update")
	public void updateUserId(@RequestBody Users user) {
		System.out.println("***************Update question******************");
		userService.updateUsers(user);
	}
	
	
	/* @PostMapping("/addUser")
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
	  }*/
	 
}
