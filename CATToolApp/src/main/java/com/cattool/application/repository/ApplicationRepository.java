package com.cattool.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cattool.application.entity.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

	

	Application findByApplicationName(String applicationName);

	
}
