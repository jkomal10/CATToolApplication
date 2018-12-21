package com.cattool.application.dao.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cattool.application.dao.UsersDao;
import com.cattool.application.entity.ClientMaster;
import com.cattool.application.entity.Users;
import com.cattool.application.exception.ExceptionMessages;
import com.cattool.application.repository.ClientMasterRepository;
import com.cattool.application.repository.UserRepository;

@Component
public class UsersDAOService {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ClientMasterRepository clientMasterRepository;
	
	boolean isDeactivate=false;
	int isDeleted = 0;
	
	public List<UsersDao> getAllUsersList(int clientId){
		List<UsersDao> usersDaoList=new ArrayList<UsersDao>();
		List<Users> usersList=userRepository.findByClientIdAndIsDeleted(clientId, isDeleted);
		return toGetAllUsers(usersList,usersDaoList);
	}
	
	public List<UsersDao> toGetAllUsers(List<Users> usersList,List<UsersDao> usersDaoList){
		for(Users user:usersList)
		{
			usersDaoList.add(toDaoForUsers(user));
		}
		return usersDaoList;
	}
	
	public int getUserCount(int clientId) {
		return getAllUsersList(clientId).size();
	}
	
	public UsersDao getUserByUsername(String userName, String password) {
		return toDaoForUsers(getUserByUserNameAndPassword(userName,password));
	}
	
	public Users getUserByUserNameAndPassword(String userName, String password)
	{
		return userRepository.findByUserNameAndPassword(userName,password);
	}
	
	public UsersDao toDaoForUsers(Users users)
	{
		UsersDao usersDao=new UsersDao();
		usersDao.setUserId(users.getUserId());
		usersDao.setClientId(users.getClientId());
		usersDao.setCompany(users.getCompany());
		usersDao.setCreatedBy(users.getCreatedBy());
		usersDao.setCreatedDateTime(users.getModifiedDateTime());
		usersDao.setFirstName(users.getFirstName());
		usersDao.setDeactivate(users.isDeactivate());
		usersDao.setIpAddress(users.getIpAddress());
		usersDao.setIsAdmin(users.getIsAdmin());
		usersDao.setIsDeleted(users.getIsDeleted());
		usersDao.setLastLogin(users.getLastLogin());
		usersDao.setLastName(users.getLastName());
		usersDao.setModifiedBy(users.getModifiedBy());
		usersDao.setModifiedDateTime(users.getModifiedDateTime());
		usersDao.setPassword(users.getPassword());
		usersDao.setUserName(users.getUserName());
		return usersDao;
	}
	
	public Users toUsers(UsersDao usersDao)
	{
		Users users=new Users();
		users.setUserId(usersDao.getUserId());
		users.setClientId(usersDao.getClientId());
		users.setCompany(usersDao.getCompany());
		users.setCreatedBy(usersDao.getCreatedBy());
		users.setCreatedDateTime(usersDao.getModifiedDateTime());
		users.setFirstName(usersDao.getFirstName());
		users.setDeactivate(usersDao.isDeactivate());
		users.setIpAddress(usersDao.getIpAddress());
		users.setIsAdmin(usersDao.getIsAdmin());
		users.setIsDeleted(usersDao.getIsDeleted());
		users.setLastLogin(usersDao.getLastLogin());
		users.setLastName(usersDao.getLastName());
		users.setModifiedBy(usersDao.getModifiedBy());
		users.setModifiedDateTime(usersDao.getModifiedDateTime());
		users.setPassword(usersDao.getPassword());
		users.setUserName(usersDao.getUserName());
		return users;
	}
	
	public void setLastLogin(int userId,int lastLogin) {
		Users user=new Users();
		user=userRepository.findByUserId(userId);
		user.setLastLogin(lastLogin);
		userRepository.save(user);
	}
	
	public void saveUser(UsersDao users,String createdBy) {
		users.setCreatedBy(createdBy);
		users.setPassword("Cg@123");
		saveUser(users);
	}
	
	public void saveUser(UsersDao users) {
		userRepository.save(toUsers(users));
	}
	
	public void setIsDelete(int isDelete) {
		Users user=new Users();
		user.setIsDeleted(isDelete);
	}
	
	public void setIsDelete(int clientId,int userId) {
		Users user=userRepository.findByClientIdAndUserId(clientId, userId);
		user.setIsDeleted(1);
		saveUser(toDaoForUsers((user)));
	}

	public void setUserNameAndPassword(String userName, String password,String newPassword) {
		if(getUserByUserNameAndPassword(userName,password)!=null)
		{
			setNewPassword(newPassword, toDaoForUsers(getUserByUserNameAndPassword(userName,password)));
		}
	}
	
	private void setNewPassword(String newPassword,UsersDao user) {
		user.setPassword(newPassword);
		saveUser(user);
	}
	
	public void setUpdatedUser(UsersDao user,String modifiedBy) {
		user.setModifiedBy(modifiedBy);
		saveUser(user);
	}
	
	public void updateUsers(UsersDao user, String modifiedBy) {
		try {
			setUpdatedUser(user, modifiedBy);
			LOGGER.info("Succfully update the user");

		} catch (Exception e) {
			LOGGER.error(ExceptionMessages.UpdateUser + e);
			System.out.println(ExceptionMessages.UpdateUser + e);
		}

	}
	
	public void getUserById(int userId)
	{
		userRepository.findByUserId(userId).setDeactivate(true);
	}
	
	public String findUserId(int clientId, String userName) {
		int id = userRepository.findByClientIdAndIsDeactivateAndIsDeletedAndUserName(clientId, isDeactivate, isDeleted,userName).getUserId();
		String json = "{\"id\" : "+id+"}";
		return json;
	}
	
	public ClientMaster getClientNameByClientId(int clientId) {
		return clientMasterRepository.findByClientId(clientId);
	}
	
	
}
