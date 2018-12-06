package com.cattool.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cattool.application.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long>{
	
	Users findByUserName(String userName);

	Users findByUserId(int userId);

	void deleteByUserId(int userId);
	 
	List<Users> findByClientIdAndIsDeactivate(int clientId,boolean isDeactivate);

	Users findByClientIdAndUserId(int clientId, int userId);

	List<Users> findByClientIdAndIsDeactivateAndIsDeleted(int clientId, boolean isDeactivate, int isDeleted);
	List<Users> findByClientIdAndIsDeleted(int clientId,int isDeleted);


}
