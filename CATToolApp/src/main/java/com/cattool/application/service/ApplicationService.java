package com.cattool.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cattool.application.entity.Answers;
import com.cattool.application.entity.Application;
import com.cattool.application.entity.CloudProviderRule;
import com.cattool.application.repository.AnswersRepository;
import com.cattool.application.repository.ApplicationRepository;
import com.cattool.application.repository.CloudProviderRuleRepository;

@Service
@Transactional
public class ApplicationService {

	@Autowired
	ApplicationRepository applicationRepository;
	
	@Autowired
	AnswersRepository answersRepository;
	
	@Autowired
	CloudProviderRuleRepository cloudProviderRuleRepository;
	
	public List<Application> getAllApplication()
	{
		return applicationRepository.findAll();
	}
	
	public Application saveApplication(Application application)
	{
		return applicationRepository.save(application);
	}
	
	public Application findbyApplicationName(String applicationName)
	{
		return applicationRepository.findByApplicationName(applicationName);
	}

	public void deleteApplicationById(int id) {
		
		applicationRepository.deleteByApplicationId(id);
	}

	public Application GetSingleApplication(int applicationId) {
		return applicationRepository.findByApplicationId(applicationId);
	}
	
	public Application updateApplication(int applicationId,Application application)
	{
		Application app=new Application();
		app.setApplicationId(application.getApplicationId());
		app.setApplicationName(application.getApplicationName());
		app.setApplicationDescription(application.getApplicationDescription());
		app.setMigrationPattern(application.getMigrationPattern());
		app.setUserId(application.getUserId());
		return applicationRepository.save(application);
	}
	
	public void resetApplicationById(int applicationId)
	{
		Application application=new Application();
		application.setApplicationId(applicationId);
		application.setUserId(applicationRepository.findByApplicationId(applicationId).getUserId());
		applicationRepository.save(application);
	}
	
	public void deactivateApplicationById(int applicationId) {
		Application application=new Application();
		application = applicationRepository.findByApplicationId(applicationId);
		application.setDeactivate(true);
		application.setUserId(applicationRepository.findByApplicationId(applicationId).getUserId());
		applicationRepository.save(application);
	}

	public List<Application> getAllReassessment() {
		// TODO Auto-generated method stub
		 List<Application> appList=new ArrayList<Application>();
		 
         for(Application application: applicationRepository.findAll()){
       	 if(application.isFinalize()==1)
        	 {
        		 appList.add(application);
        		 System.out.println(appList);
        	 }
        	 System.out.println(application.getApplicationName());
         }
       
         System.out.println("**************************"+appList+"v  *****************");
		return appList;
	}

	public void allRuleCheck(int applicationId) {
		//boolean cloudabilityCheck= cloudableCheck(applicationId);
		if (cloudableCheck(applicationId)) {
//		migrationCheck(applicationId);
		cloudProviderCheck(applicationId);
		}
	}
	
	private void cloudProviderCheck(int applicationId) {
		// TODO Auto-generated method stub
		
	}

	public boolean cloudableCheck(int applicationId){
		return true;
	}
	public void migrationCheck(int applicationId){}
	
	
	
	
}