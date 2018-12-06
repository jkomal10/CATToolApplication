package com.cattool.assessment.Report.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cattool.assessment.Report.entity.Application;



@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long>{

	

	Application findByApplicationName(String applicationName);
	void  deleteByApplicationId(int applicationId);
	Application findByApplicationId(int applicationId);
	Application findByUserId(int userId);
	List<Application> findByClientIdAndIsDeactivate(int clientId,Boolean isDeactivate);
	List<Application> findByClientIdAndIsDeleted(int clientId,Boolean isDeleted);
	List<Application> findByClientId(int clientId);
}
