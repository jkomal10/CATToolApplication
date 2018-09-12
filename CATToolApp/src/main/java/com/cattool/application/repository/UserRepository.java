package com.cattool.cattool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cattool.cattool.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long>{
	
	Users findByUserName(String userName);

}
