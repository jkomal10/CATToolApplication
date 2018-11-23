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
	
	@GetMapping("/getAll/{clientName}")
	public List<Application>getAllApplication(@PathVariable String clientName)
	{
		System.out.println(clientName+" get all application with this client ");
		return applicationService.getAllApplication(clientName);
	}
	@GetMapping("/getApplicationById/{applicationId}")
	public Application getApplicationById(@PathVariable("applicationId") int id) {
	 return applicationService.GetSingleApplication(id);	
	}

	@PostMapping("/saveApplication/create")
	public Application saveApplication(@RequestBody Application application)
	{
		System.out.println("******************************************add application*************************");
		System.out.println(application);
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
	
	@PutMapping("/updateApplictaion")
	public void updateApplication (@RequestBody Application application) {
		System.out.println("*******update*******");
		applicationService.updateApplication(application.getApplicationId(),application);
	}
	
	
	@DeleteMapping("/deleteApplicationById/{applicationId}")
	public void  deleteApplication(@PathVariable("applicationId") int id) {
		System.out.println("*******delete*******");
		applicationService.deleteApplicationById(id);
	}
	
	@PutMapping("/resetApplicationById/{applicationId}")
	public void resetApplication (@PathVariable("applicationId") int applicationId) {
		System.out.println("*******Reset*******");
		applicationService.resetApplicationById(applicationId);
	}
	
	@PutMapping("/deactivateApplicationById/{applicationId}")
	public void deactivateApplication(@PathVariable("applicationId") int applicationId) {
		System.out.println("*******deactivate*******"+applicationId);
		applicationService.deactivateApplicationById(applicationId);
	}
	
	@GetMapping("/getAllReassessment/{clientName}")
	public List<Application>getAllReassessment(@PathVariable String clientName)
	{
		return applicationService.getAllReassessment(clientName);
	}

	@GetMapping("AllRuleCheck/{applicationId}")
	public void allRuleCheck(@PathVariable("applicationId") int applicationId) {
		System.out.println("All rule check!!!!");
		applicationService.allRuleCheck(applicationId);
	}
	
//	@GetMapping("migrationCheck/{applicationId}/")
//	public void migrationCheck(@PathVariable("applicationId") int applicationId) {
//		System.out.println("All rule check!!!!");
//		applicationService.migrationCheck(applicationId);
//	}
	
	@GetMapping("cloudProviderCheck/{applicationId}")
	public void cloudProviderCheck(@PathVariable("applicationId") int applicationId) {
		System.out.println("cloud provider rule check!!!!");
		applicationService.cloudProviderCheck(applicationId);
	}
	
	@GetMapping("/getApplicationByUserName/{userName}")
	public Application getAppByUser(@PathVariable("userName") String userName) {
		System.out.println("application get by user name!!!!"+userName);
		return applicationService.getApplicationByUserName(userName);
	}
	
	@GetMapping("/summaryReport")
	public void summaryRepory() throws FileNotFoundException
	{
		System.out.println("Summary report works!!!");
		applicationService.summaryReport();
	}

}
