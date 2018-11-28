package com.cattool.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cattool.application.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long>{
	
	Users findByUserName(String userName);

	Users findByUserId(int userId);

	void deleteByUserId(int userId);
	 
	List<Users> findByClientIdAndIsDeactivate(int clientId,int isDeactivate);



}
