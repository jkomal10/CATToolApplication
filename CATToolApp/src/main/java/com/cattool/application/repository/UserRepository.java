package com.cattool.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cattool.application.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long>{
	
	Users findByUserName(String userName);

}
