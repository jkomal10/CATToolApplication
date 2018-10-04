package com.cattool.application.controller;

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
	
	@GetMapping("/getAll")
	public List<Application>getAllApplication()
	{
		return applicationService.getAllApplication();
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
	
	@PutMapping("/updateApplictaion")
	public void updateApplication (@RequestBody Application application) {
		System.out.println("*******update*******");
		applicationService.updateApplication(application.getApplicationId(),application);
	}
	
	
//	@PutMapping("/updateApplictaion/{applicationId}")
//	public void updateApplication (@PathVariable String applicationId, @RequestBody Application application) {
//		System.out.println("*******update*******");
//		int appId=Integer.parseInt(applicationId);
//		System.out.println(appId);
//		applicationService.updateApplication(appId,application);
//	}
	
	@DeleteMapping("/deleteApplicationById/{applicationId}")
	public void  deleteApplication(@PathVariable("applicationId") int id) {
		applicationService.deleteApplicationById(id);
	}
	
	@PutMapping("/resetApplicationById/{applicationId}")
	public void resetApplication (@PathVariable("applicationId") int applicationId) {
		System.out.println("*******Reset*******");
		applicationService.resetApplicationById(applicationId);
	}
}
