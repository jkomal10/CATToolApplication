package com.cattool.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cattool.application.entity.Application;
import com.cattool.application.service.ApplicationService;

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

	@PostMapping("/saveApplication")
	public Application saveApplication(@RequestBody Application application)
	{
		return applicationService.saveApplication(application);
	}
	
	@PostMapping("/getApplicationByName{applicationName}")
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
	
}
