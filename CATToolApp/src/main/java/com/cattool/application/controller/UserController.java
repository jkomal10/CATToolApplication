package com.cattool.application.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.cattool.application.exception.CATException;
import com.cattool.application.service.UserService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
	UserService	userService; 
	
	@GetMapping("/getAll/{clientId}")
	public List<Users> findAllUsers(@PathVariable int clientId)
	{
		LOGGER.error("Get all user");
		return userService.findAllUsers(clientId);

		
	}
	
	@GetMapping("/getUserId/{clientId}/{userName}")
	public String getuserIdByName(@PathVariable int clientId,@PathVariable String userName)
	{
		return userService.findUserId(clientId,userName);
	}
	
	
	@GetMapping("/getTotalUsersCount/{clientId}")
	public int getUserCount(@PathVariable int clientId)
	{
		return userService.getUserCount(clientId);
	}
	
	
	@GetMapping("/getById/{userName}/{password}")
	public Users findById(@PathVariable String userName,HttpServletRequest request,HttpServletResponse response, @PathVariable String password)
	{
		return userService.findById(userName,password);
	}
	
	@PostMapping("/addUser/create/{createdBy}")
	public Users saveUser(@RequestBody Users user,@PathVariable String createdBy)
	{
		return userService.saveUser(user,createdBy);
	}
	 
	@DeleteMapping("/deleteUserById/{userId}")
	public void deleteById(@PathVariable int userId)
	{
		userService.deleteById(userId);
	}
	
	@PutMapping("/updateUser/update/{modifiedBy}")
	public void updateUserId(@RequestBody Users user,@PathVariable String modifiedBy) {
		userService.updateUsers(user,modifiedBy);
	}
	
	@GetMapping("changePassword/{userName}/{password}/{company}")
	public Users setPassword(@PathVariable String userName,@PathVariable String password,@PathVariable String company) {
		return userService.changePassword(userName, password,company);
	}
	
	@PutMapping("/deactivateUser/{userId}")
	public void deactivateUser(@PathVariable("userId") int userId)
	{
		userService.deactivateUser(userId);
	}
	
	@GetMapping("/get/client/{clientId}")
	public String getClient(@PathVariable int clientId) {
		return userService.getClientNameByClientId(clientId);
	}
}
