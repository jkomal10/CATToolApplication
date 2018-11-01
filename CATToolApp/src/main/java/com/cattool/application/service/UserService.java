package com.cattool.application.service;

import java.util.Date;
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
		Users userDb = new Users();
		try
		{
			 userDb=userRepository.findByUserName(userName);
			System.out.println(userDb.getUserName());
			int lastLogInDateInInt=(int) (new Date().getTime()/1000);
			if(userDb!=null)
			{
				if(password.equals(userDb.getPassword()))
				{
					userDb.setLastLogin(lastLogInDateInInt);
					System.out.println("Successfully logged in");
					return userDb;
				}
				else
				{
					System.out.println("password does not exist!!!!!!!");
					return null;
				}
			}
//			else
//			{
//				System.out.println("User does not exist!!!!");
//				return null;
//			}
		}catch (Exception e) {
			System.out.println("User does not exist!!!!");
			return null;
		}
		return userDb;
		
		
	}

	public Users saveUser(Users user,String createdBy) {
		System.out.println(user+createdBy);
		user.setCreatedBy(createdBy);
		return userRepository.save(user);
	}

	public void deleteById(int userId) {
		userRepository.deleteByUserId(userId);
	}

	public void updateUsers(Users user,String modifiedBy) {
		System.out.println("service");
		Users users = new Users();
		System.out.println(user.getUserId()+" it is user id *********");
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
		users.setModifiedBy(modifiedBy);
		users.setModifiedDateTime(user.getModifiedDateTime());
		userRepository.save(users);
	}


	public Users changePassword(String userName,String password,String newPassword) {
			Users user=new Users();
			user=userRepository.findByUserName(userName);
			System.out.println(password+"=="+newPassword+"=="+user.getPassword());
			if(password.equals(user.getPassword())) {
				user.setUserId(user.getUserId());
				user.setPassword(password);
				userRepository.save(user);
				System.out.println("Password changed");
				return user;
			}
			else
			{
				System.out.println("Please enter correct password!!!");
				return user;
			}
	}

	public int getUserCount() {
		
		List<Users> users = userRepository.findAll();
		int count = 0;
		
		for(Users user : users)
		{
			count = count + 1;
		}
		
		System.out.println(count);
		return count;
	}

	public void deactivateUser(int userId) {
		Users users = new Users();
		users = userRepository.findByUserId(userId);
		System.out.println("**** "+ users);
		System.out.println(users.getUserId());
		users.setDeactivate(true);
		users.setUserId(users.getUserId());
	}
	
}
