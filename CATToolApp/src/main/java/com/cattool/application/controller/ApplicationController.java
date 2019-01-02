package com.cattool.application.controller;

import java.io.FileNotFoundException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cattool.application.dao.ApplicationDAO;
import com.cattool.application.entity.Application;
import com.cattool.application.service.ApplicationService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/application")
public class ApplicationController {
	@Autowired
	ApplicationService applicationService;
	
	@GetMapping("/getTotalApplicationsCount/{clientId}") 
    public int getAllApplicationCount(@PathVariable int clientId) 
    { 
		 System.out.println("Get application count!!");
         return applicationService.getAllAppsCount(clientId); 
    }
	
	@GetMapping("/getAll/{clientId}")
	public List<ApplicationDAO> getAllApplication(@PathVariable int clientId)
	{
		System.out.println("Get all application!!");
		return applicationService.getAllApplication(clientId);
	}
	
	@GetMapping("/getAllFinalizeAplication/{clientId}")
	public List<ApplicationDAO>getAllFinalizeAplication(@PathVariable int clientId)
	{
		System.out.println("Get all application!!");
		return applicationService.getAllFinalizeAplication(clientId);
	}
	
	@GetMapping("/getApplicationById/{applicationId}")
	public ApplicationDAO getApplicationById(@PathVariable("applicationId") int id) {
		System.out.println("Get application by id!!");
		return applicationService.getApplicationById(id);	
	}

	@PostMapping("/saveApplication/create")
	public void saveApplication(@RequestBody ApplicationDAO application)
	{
		applicationService.saveApplication(application);
	}
	
	@GetMapping("/getApplicationByName{applicationName}")
	public ApplicationDAO getApplicationByName(@PathVariable String applicationName)
	{
		System.out.println("Get application by name!!");
		ApplicationDAO application=applicationService.findbyApplicationName(applicationName);
		if(application!=null) {
			return applicationService.findbyApplicationName(applicationName);
	    }
		else {
			return null;
		}
	}
	
	@GetMapping("/getApplicationByUserName/{userName}")
	public ApplicationDAO getAppByUser(@PathVariable("userName") String userName) {
		System.out.println("Get application by username!!");
		return applicationService.getApplicationByUserName(userName);
	}
	
	@PutMapping("/updateApplictaion/{clientName}")
	public void updateApplication (@PathVariable String clientName,@RequestBody ApplicationDAO application) {
		System.out.println("Update application!!");
		applicationService.updateApplication(clientName,application);
	}
		
	@DeleteMapping("/deleteApplicationById/{applicationId}")
	public void  deleteApplication(@PathVariable("applicationId") int id) {
		System.out.println("Delete application!!");
		applicationService.deleteApplicationById(id);
	}
	
	@PutMapping("/resetApplicationById/{applicationId}")
	public void resetApplication (@PathVariable("applicationId") int applicationId) {
		System.out.println("Reset application!!");
		applicationService.resetApplicationById(applicationId);
	}
	
	@PutMapping("/deactivateApplicationById/{applicationId}")
	public void deactivateApplication(@PathVariable("applicationId") int applicationId) {
		System.out.println("Deactivate questions!!");
		applicationService.deactivateApplicationById(applicationId);
	}
	
	@GetMapping("/getAllReassessment/{clientId}")
	public List<ApplicationDAO>getAllReassessment(@PathVariable int clientId)
	{
		System.out.println("Get all reassessment!!");
		return applicationService.getAllReassessment(clientId);
	}

	@GetMapping("AllRuleCheck/{applicationId}")
	public void allRuleCheck(@PathVariable int applicationId) {
		System.out.println(applicationId);
		System.out.println("Rule check!!");
		applicationService.allRuleCheck(applicationId);
	}
	
	@GetMapping("migrationCheck/{applicationId}")
	public void migrationCheck(@PathVariable("applicationId") int applicationId) {
		System.out.println("migration rule check!!!!");
		applicationService.migrationCheck(applicationId);
	}
	
	@GetMapping("/cloudProviderCheck/{applicationId}")
	public void cloudProviderCheck(@PathVariable("applicationId") int applicationId) {
		System.out.println("Cloud provider rule check!!");
		applicationService.cloudProviderCheck(applicationId);
	} 
	
}
