package com.cattool.application.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

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

import com.cattool.application.dao.UsersDao;
import com.cattool.application.entity.ClientMaster;
import com.cattool.application.service.UserService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
	UserService	userService; 
	
	@GetMapping("/getAll/{clientId}")
	public List<UsersDao> findAllUsers(@PathVariable int clientId)
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
	

	@GetMapping("/getTotalUsersCount")
	public int getUserCount()
	{
		return userService.getUserCount(0);
	}
	
	
	@GetMapping("/getById/{userName}/{password}")
	public UsersDao findById(@PathVariable String userName,@PathVariable String password)
	{
		return userService.findById(userName,password);
	}
	
	@PostMapping("/addUser/create/{createdBy}")
	public void saveUser(@RequestBody UsersDao user,@PathVariable String createdBy)
	{
		userService.saveUser(user,createdBy);
	}
	
	 
	@DeleteMapping("/deleteUserById/{clientId}/{userId}")
	public void deleteById(@PathVariable int clientId,@PathVariable int userId)
	{
		userService.deleteById(clientId,userId);
	}
	
	@PutMapping("/updateUser/update/{modifiedBy}")
	public void updateUserId(@RequestBody UsersDao user,@PathVariable String modifiedBy) {
		userService.updateUsers(user,modifiedBy);
	}
	
	@GetMapping("changePassword/{userName}/{password}/{company}")
	public void setPassword(@PathVariable String userName,@PathVariable String password,@PathVariable String company) {
		System.out.println("change password");
		userService.changePassword(userName, password,company);
	}
	
	@PutMapping("/deactivateUser/{userId}")
	public void deactivateUser(@PathVariable("userId") int userId)
	{
		userService.deactivateUser(userId);
	}
	
	@GetMapping("/get/client/{clientId}")
	public ClientMaster getClient(@PathVariable int clientId) {
		return userService.getClientNameByClientId(clientId);
	}
	
}
