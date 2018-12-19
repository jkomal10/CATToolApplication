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

import com.cattool.application.dao.UsersDao;
import com.cattool.application.dao.service.UsersDAOService;
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
	
	@Autowired
	UsersDAOService usersDAOService;
    
	boolean isDeactivate=false;
	int isDeleted = 0;
	public int getUserCount(int clientId) {
		return usersDAOService.getUserCount(clientId);
	}

	public List<UsersDao> findAllUsers(int clientId) {
		return usersDAOService.getAllUsersList(clientId);
	}

	public UsersDao findById(String userName, String password) {
		UsersDao userDao=new UsersDao();
		try {
			userDao = usersDAOService.getUserByUsername(userName,password);
			if(userDao!=null)
			{
				int lastLogInDateInInt = (int) (new Date().getTime() / 1000);
				usersDAOService.setLastLogin(userDao.getUserId(), lastLogInDateInInt);
				return userDao;
		 }
		}catch (Exception e) {
			System.out.println(ExceptionMessages.InvalidName + e);
		}
		return userDao;
	}

	public void saveUser(Users user, String createdBy) {
		try {
			usersDAOService.saveUser(user,createdBy);
		} catch (Exception e) {
			LOGGER.error(ExceptionMessages.AddUserError);
		}

	}

	public void deleteById(int clientId,int userId) {
		try {
			usersDAOService.setIsDelete(clientId,userId);
			LOGGER.info("Succfully deleted the user");
		} catch (Exception e) {
			LOGGER.error(ExceptionMessages.DeletsUser);
			System.out.println(ExceptionMessages.DeletsUser + e);
		}

	}
	
	public void updateUsers(Users user, String modifiedBy) {
		try {
			usersDAOService.setUpdatedUser(user, modifiedBy);
			LOGGER.info("Succfully update the user");

		} catch (Exception e) {
			LOGGER.error(ExceptionMessages.UpdateUser + e);
			System.out.println(ExceptionMessages.UpdateUser + e);
		}

	}
	

	public void changePassword(String userName, String password, String newPassword) {
		usersDAOService.setUserNameAndPassword(userName, password, newPassword);
	}

	public void deactivateUser(int userId) {
		try {
			usersDAOService.getUserById(userId);
			LOGGER.info("User is deactivated succfully");
		} catch (Exception e) {
			LOGGER.error(ExceptionMessages.DeactivateUser + e);
			System.out.println(ExceptionMessages.DeactivateUser + e);
		}

	}
	
	public String findUserId(int clientId, String userName) {
		return usersDAOService.findUserId(clientId, userName);
	}
	
	public ClientMaster getClientNameByClientId(int clientId) {
		return usersDAOService.getClientNameByClientId(clientId);
	}
	
	
	
	

//	public String findUserId(int clientId, String userName) {
//		List<Users> userList = new ArrayList<Users>();
//		Users userbyId = new Users();
//		userList=userRepository.findByClientIdAndIsDeactivateAndIsDeleted(clientId, isDeactivate, isDeleted);
//		
//		for(Users alluser : userList)
//		{
//			if(alluser.getUserName().equals(userName))
//			{
//				int id = alluser.getUserId();
//				String json = "{\"id\" : "+id+"}";
//				return json;
//			}
//		}
//		
//		userbyId.setUserName(userName);
//		userbyId.setClientId(clientId);
//		userbyId.setPassword("Cg@123");
//		int id = userRepository.save(userbyId).getUserId();
//		String json = "{\"id\" : "+id+"}";
//		return json;
//	}
	//"{\"id\" : "+id+"}" 
	
	
	
//	public String getClientNameByClientId(int clientId) {
//		ClientMaster client=new ClientMaster();
//		client=clientMasterRepository.findByClientId(clientId);
//		System.out.println(client.getClientName());
//		return client.getClientName();
//	}

	
}
