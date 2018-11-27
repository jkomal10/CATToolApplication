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
            return applicationService.getAllAppsCount(clientId); 
    }
	
	@GetMapping("/getAll/{clientId}")
	public List<Application>getAllApplication(@PathVariable int clientId)
	{
	return applicationService.getAllApplication(clientId);
	}
	
	@GetMapping("/getApplicationById/{applicationId}")
	public Application getApplicationById(@PathVariable("applicationId") int id) {
	 return applicationService.GetSingleApplication(id);	
	}

	@PostMapping("/saveApplication/create")
	public Application saveApplication(@RequestBody Application application)
	{
		return applicationService.saveApplication(application);
	}
	
	@GetMapping("/getApplicationByName{applicationName}")
	public Application getApplicationByName(@PathVariable String applicationName)
	{
		Application application=applicationService.findbyApplicationName(applicationName);
		if(application!=null) {
		return applicationService.findbyApplicationName(applicationName);
	    }
		else {
		return null;
		}
	}
	
	@GetMapping("/getApplicationByUserName/{userName}")
	public Application getAppByUser(@PathVariable("userName") String userName) {
		return applicationService.getApplicationByUserName(userName);
	}
	
	@PutMapping("/updateApplictaion")
	public void updateApplication (@RequestBody Application application) {
		applicationService.updateApplication(application.getApplicationId(),application);
	}
		
	@DeleteMapping("/deleteApplicationById/{applicationId}")
	public void  deleteApplication(@PathVariable("applicationId") int id) {
		applicationService.deleteApplicationById(id);
	}
	
	@PutMapping("/resetApplicationById/{applicationId}")
	public void resetApplication (@PathVariable("applicationId") int applicationId) {
		applicationService.resetApplicationById(applicationId);
	}
	
	@PutMapping("/deactivateApplicationById/{applicationId}")
	public void deactivateApplication(@PathVariable("applicationId") int applicationId) {
		applicationService.deactivateApplicationById(applicationId);
	}
	
	@GetMapping("/getAllReassessment/{clientId}")
	public List<Application>getAllReassessment(@PathVariable int clientId)
	{
		return applicationService.getAllReassessment(clientId);
	}

	@GetMapping("AllRuleCheck/{applicationId}")
	public void allRuleCheck(@PathVariable("applicationId") int applicationId) {
		
		applicationService.allRuleCheck(applicationId);
	}
	
	@GetMapping("migrationCheck/{applicationId}/{isFinalize}")
	public void migrationCheck(@PathVariable("applicationId") int applicationId,@PathVariable int isFinalize) {
		System.out.println("All rule check!!!!");
		applicationService.migrationCheck(applicationId,isFinalize);
	}
	
	@GetMapping("cloudProviderCheck/{applicationId}")
	public void cloudProviderCheck(@PathVariable("applicationId") int applicationId) {
		
		applicationService.cloudProviderCheck(applicationId);
	}
	
	
	@GetMapping("/summaryReport")
	public void summaryRepory() throws FileNotFoundException
	{
		applicationService.summaryReport();
	}

}
