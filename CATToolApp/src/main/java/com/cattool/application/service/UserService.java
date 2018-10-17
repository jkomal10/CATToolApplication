package com.cattool.application.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cattool.application.entity.Users;
import com.cattool.application.repository.UserRepository;

@Transactional
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

	public Users saveUser(Users user,String createdBy) {
		System.out.println(user+createdBy);
		user.setCreatedBy(createdBy);
		return userRepository.save(user);
	}

	public void deleteById(int userId) {
		userRepository.deleteByUserId(userId);
	}

	public void updateUsers(Users user) {
		
		Users users = new Users();
		users = userRepository.findByUserId(user.getUserId());
		System.out.println(users.getUserId());
		users.setUserId(user.getUserId());
		users.setUserName(user.getUserName());
		users.setFirstName(user.getFirstName());
		users.setLastName(user.getLastName());
		users.setPassword(user.getPassword());
		users.setIpAddress(user.getIpAddress());
		users.setLastLogin(user.getLastLogin());
		users.setCompany(user.getCompany());
		users.setIsDeleted(user.getIsDeleted());
		users.setCreatedBy(user.getCreatedBy());
		users.setCreatedDateTime(users.getCreatedDateTime());
		users.setModifiedBy(user.getModifiedBy());
		users.setModifiedDateTime(user.getModifiedDateTime());
		userRepository.save(users);
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
