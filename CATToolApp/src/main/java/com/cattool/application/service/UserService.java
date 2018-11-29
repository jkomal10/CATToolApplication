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

import java.security.MessageDigest;
import com.cattool.application.encryption.EncryptPassword;
import com.cattool.application.entity.ClientMaster;
import com.cattool.application.entity.Users;
import com.cattool.application.exception.CATException;
import com.cattool.application.exception.ExceptionMessages;
import com.cattool.application.repository.ClientMasterRepository;
import com.cattool.application.repository.UserRepository;

@Transactional
@Service
public class UserService {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ClientMasterRepository clientMasterRepository;
    
	boolean isDeactivate=false;
	public int getUserCount(int clientId) {

		List<Users> usersList = userRepository.findAll();
		int count = 0;
		
		usersList=userRepository.findByClientIdAndIsDeactivate(clientId, isDeactivate);
		count = usersList.size();
		return count;
	}

	public List<Users> findAllUsers(int clientId) {

		List<Users> userList = new ArrayList<Users>();
		
		try {
			userList=userRepository.findByClientIdAndIsDeactivate(clientId, isDeactivate);
			System.out.println(userList);
			LOGGER.info("Successfully get all users");
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
			if(userDb!=null)
			{
				String decryptedPassword = EncryptPassword.decrypt(userDb.getPassword());    
				if(password.equals(decryptedPassword))
				{
			int lastLogInDateInInt = (int) (new Date().getTime() / 1000);
			if (userDb != null) {
				if (password.equals(userDb.getPassword())) {
					userDb.setLastLogin(lastLogInDateInInt);
					LOGGER.info("Successfully get password");
					return userDb;
				} else {
					LOGGER.error(ExceptionMessages.WrongPassword);
					throw new CATException(ExceptionMessages.WrongPassword);
				}
			} else {
				LOGGER.error(ExceptionMessages.InvalidName);
				throw new CATException(ExceptionMessages.InvalidName);
			}

		} }}catch (Exception e) {
			LOGGER.error(ExceptionMessages.InvalidName);
			System.out.println(ExceptionMessages.InvalidName + e);
		}

		return userDb;

	}

	public Users saveUser(Users user, String createdBy) {
		try {
			user.setCreatedBy(createdBy);
			LOGGER.info("Successfully save user details");
			String encryptedPassword = EncryptPassword.encrypt(user.getPassword());
			user.setPassword(encryptedPassword);
			return userRepository.save(user);
		} catch (Exception e) {
			LOGGER.error(ExceptionMessages.AddUserError);
		}
		return user;

	}

	public void deleteById(int userId) {
		try {
			userRepository.deleteByUserId(userId);
			LOGGER.info("Succfully deleted the user");
		} catch (Exception e) {
			LOGGER.error(ExceptionMessages.DeletsUser);
			System.out.println(ExceptionMessages.DeletsUser + e);
		}

	}

	public void updateUsers(Users user, String modifiedBy) {
		try {
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
			users.setModifiedBy(modifiedBy);
			users.setModifiedDateTime(user.getModifiedDateTime());
			userRepository.save(users);
			LOGGER.info("Succfully update the user");

		} catch (Exception e) {
			LOGGER.error(ExceptionMessages.UpdateUser + e);
			System.out.println(ExceptionMessages.UpdateUser + e);
		}

	}

	public Users changePassword(String userName, String password, String newPassword) {
		Users user = new Users();
		System.out.println(userName+password+newPassword);
		try {
			user = userRepository.findByUserName(userName);
			if (password.equals(user.getPassword())) {
				user.setUserId(user.getUserId());
				user.setPassword(password);
				userRepository.save(user);
				LOGGER.info("Succfully changed the password");
				System.out.println("Password changed");
				return user;
			} else {
				System.out.println("not updated");
				LOGGER.error(ExceptionMessages.UpdateUserPassword);
				System.out.println(ExceptionMessages.UpdateUserPassword);
			}
		} catch (Exception e) {
			LOGGER.error(ExceptionMessages.UpdatePassword + e);
			System.out.println(ExceptionMessages.UpdatePassword + e);
		}
		return null;

	}

	public void deactivateUser(int userId) {
		Users users = new Users();
		try {
			users = userRepository.findByUserId(userId);
			users.setDeactivate(true);
			users.setUserId(users.getUserId());
			LOGGER.info("User is deactivated succfully");
		} catch (Exception e) {
			LOGGER.error(ExceptionMessages.DeactivateUser + e);
			System.out.println(ExceptionMessages.DeactivateUser + e);
		}

	}

	public String findUserId(int clientId, String userName) {
		List<Users> userList = new ArrayList<Users>();
		Users userbyId = new Users();
		userList=userRepository.findByClientIdAndIsDeactivate(clientId, isDeactivate);
		
		for(Users alluser : userList)
		{
			if(alluser.getUserName().equals(userName))
			{
				int id = alluser.getUserId();
				String json = "{\"id\" : "+id+"}";
				return json;
			}
		}
		
		userbyId.setUserName(userName);
		userbyId.setClientId(clientId);
		userbyId.setPassword("Cg@123");
		System.out.println(userRepository.save(userbyId).getUserId());
		int id = userRepository.save(userbyId).getUserId();
		String json = "{\"id\" : "+id+"}";
		return json;
	}
	
	public String getClientNameByClientId(int clientId) {
		ClientMaster client=new ClientMaster();
		client=clientMasterRepository.findByClientId(clientId);
		return client.getClientName();
	}

	
}
