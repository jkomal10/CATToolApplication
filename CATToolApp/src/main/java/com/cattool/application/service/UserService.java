package com.cattool.application.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cattool.application.entity.Users;
import com.cattool.application.exception.CATException;
import com.cattool.application.exception.ExceptionMessages;
import com.cattool.application.repository.UserRepository;

@Transactional
@Service
public class UserService {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
	UserRepository userRepository;

	public int getUserCount() {

		List<Users> usersList = userRepository.findAll();
		int count = 0;
		count = usersList.size();
		System.out.println(count);
		return count;
	}

	public List<Users> findAllUsers(String clientName) {

		List<Users> userList = new ArrayList<>();
		try {
			for (Users users : userRepository.findAll()) {

				if (!users.isDeactivate() && clientName.equals(users.getClientName())) {
					userList.add(users);
				}

			}
			LOGGER.info("Successfully get all users");
			System.out.println(userList);
			return userList;
		} catch (Exception e) {
			LOGGER.error(ExceptionMessages.GetUserDetails + e);
			System.out.println(ExceptionMessages.GetUserDetails + e);
		}
		return null;

	}

	public Users findById(String userName, String password) {
		Users userDb = new Users();
		try {
			userDb = userRepository.findByUserName(userName);
			System.out.println(userDb.getUserName());
			int lastLogInDateInInt = (int) (new Date().getTime() / 1000);
			if (userDb != null) {
				if (password.equals(userDb.getPassword())) {
					userDb.setLastLogin(lastLogInDateInInt);
					LOGGER.info("Successfully get password");
					System.out.println("Successfully logged in");
					return userDb;
				} else {
					// System.out.println("password does not exist!!!!!!!");
					// return null;
					LOGGER.error(ExceptionMessages.WrongPassword);
					throw new CATException(ExceptionMessages.WrongPassword);
				}
			} else {
				LOGGER.error(ExceptionMessages.InvalidName);
				throw new CATException(ExceptionMessages.InvalidName);
			}

		} catch (Exception e) {
			LOGGER.error(ExceptionMessages.InvalidName);
			System.out.println(ExceptionMessages.InvalidName + e);
			// return null;
		}

		return userDb;

	}

	public Users saveUser(Users user, String createdBy) {
		System.out.println(user + createdBy);
		try {
			user.setCreatedBy(createdBy);
			LOGGER.info("Successfully save user details");
			return userRepository.save(user);
		} catch (Exception e) {
			LOGGER.error(ExceptionMessages.AddUserError);
			// throw new CATException(ExceptionMessages.AddUserError);
			System.out.println(ExceptionMessages.AddUserError + e);
		}
		return null;

	}

	public void deleteById(int userId) {
		try {
			userRepository.deleteByUserId(userId);
			LOGGER.info("Succfully deleted the user");
		} catch (Exception e) {
			LOGGER.error(ExceptionMessages.DeletsUser);
			// throw new CATException(ExceptionMessages.DeletsUser);
			System.out.println(ExceptionMessages.DeletsUser + e);
		}

	}

	public void updateUsers(Users user, String modifiedBy) {
		try {
			System.out.println("service");
			Users users = new Users();
			System.out.println(user.getUserId() + " it is user id *********");
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
			LOGGER.info("Succfully update the user");

		} catch (Exception e) {
			LOGGER.error(ExceptionMessages.UpdateUser + e);
			System.out.println(ExceptionMessages.UpdateUser + e);
			// throw new CATException(ExceptionMessages.UpdateUser);
		}

	}

	public Users changePassword(String userName, String password, String newPassword) {
		Users user = new Users();
		try {
			user = userRepository.findByUserName(userName);
			System.out.println(password + "==" + newPassword + "==" + user.getPassword());
			if (password.equals(user.getPassword())) {
				user.setUserId(user.getUserId());
				user.setPassword(password);
				userRepository.save(user);
				LOGGER.info("Succfully changed the password");
				System.out.println("Password changed");
				return user;
			} else {

				LOGGER.error(ExceptionMessages.UpdateUserPassword);
				System.out.println(ExceptionMessages.UpdateUserPassword);
				// throw new CATException(ExceptionMessages.UpdateUserPassword);
			}
		} catch (Exception e) {
			// throw new CATException(ExceptionMessages.UpdatePassword);
			LOGGER.error(ExceptionMessages.UpdatePassword + e);
			System.out.println(ExceptionMessages.UpdatePassword + e);
		}
		return null;

	}

	public void deactivateUser(int userId) {
		Users users = new Users();
		try {
			users = userRepository.findByUserId(userId);
			System.out.println("**** " + users);
			System.out.println(users.getUserId());
			users.setDeactivate(true);
			users.setUserId(users.getUserId());
			LOGGER.info("User is deactivated succfully");
		} catch (Exception e) {
			LOGGER.error(ExceptionMessages.DeactivateUser + e);
			System.out.println(ExceptionMessages.DeactivateUser + e);
			// throw new CATException(ExceptionMessages.DeactivateUser);
		}

	}

	public String findUserId(String clientName, String userName) {
		List<Users> userList = new ArrayList<Users>();
		Users userbyId = new Users();
		for(Users user : userRepository.findAll())
		{
			if(user.getClientName().equals(clientName))
			{
				userList.add(user);
			}
		}
//		System.out.println(userList.size());
//		System.out.println(userList);
		
		for(Users alluser : userList)
		{
			if(alluser.getUserName().equals(userName))
			{
				System.out.println(alluser.getUserId());
				int id = alluser.getUserId();
				String json = "{\"id\" : "+id+"}";
				return json;
			}
		}
		
		userbyId.setUserName(userName);
		userbyId.setClientName(clientName);
		userbyId.setPassword("Cg@123");
		System.out.println(userRepository.save(userbyId).getUserId());
		//return userRepository.save(userbyId).getUserId();
		return null;
	}

	
}
