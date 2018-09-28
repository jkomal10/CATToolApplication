package com.cattool.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cattool.application.entity.Users;
import com.cattool.application.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<Users> findAllUsers() {
		
		return userRepository.findAll();
	}

	public Users findById(String userName,String password) {
		Users userDb=userRepository.findByUserName(userName);
		if(userDb!=null)
		{
			System.out.println(password);
			System.out.println(userDb.getPassword());
			if(password.equals(userDb.getPassword()))
			{
				return userDb;
			}
			else
			{
				System.out.println("password does not exist!!!!!!!");
				return null;
			}
		}
		else
		{
			System.out.println("User does not exist!!!!");
			return null;
		}
		
	}

	public Users saveUser(Users user) {
		System.out.println(user);
		return userRepository.save(user);
	}

	public void deleteById(int userId) {
		userRepository.deleteByUserId(userId);
	}
	
	
	
	
	/*public List<Users> getUsers() {
	return userRepository.findAll();
}
	
public Users findById(String userName) {
	return userRepository.findByUserName(userName);
	
}

public Users addUser(Users user)
{
	return userRepository.save(user);
}*/
	
}
