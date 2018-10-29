package com.cattool.application.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
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
	public Users findById(@PathVariable String userName,HttpServletRequest request,HttpServletResponse response, @PathVariable String password)
	{
		HttpSession session=request.getSession();
		session.setAttribute("userName", userName);
		session.getAttribute("userName");
		System.out.println(session.getAttribute("userName"));
		return userService.findById(userName,password);
	}
	
	@PostMapping("/addUser/create/{createdBy}")
	public Users saveUser(@RequestBody Users user,@PathVariable String createdBy)
	{
		System.out.println("post method*****************");
		return userService.saveUser(user,createdBy);
	}
	 
	@DeleteMapping("/deleteUserById/{userId}")
	public void deleteById(@PathVariable int userId)
	{
		System.out.println("delete method*****************");
		userService.deleteById(userId);
	}
	
	@PutMapping("/updateUser/update/{modifiedBy}")
	public void updateUserId(@RequestBody Users user,@PathVariable String modifiedBy) {
		System.out.println("***************Update question******************"+modifiedBy);
		userService.updateUsers(user,modifiedBy);
	}
	
	@GetMapping("changePassword/{userName}/{password}/{company}")
	public Users setPassword(@PathVariable String userName,@PathVariable String password,@PathVariable String company) {
		System.out.println("Change password");
		return userService.changePassword(userName, password,company);
	}
	
}
