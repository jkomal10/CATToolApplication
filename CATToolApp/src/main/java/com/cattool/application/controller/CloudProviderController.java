package com.cattool.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cattool.application.entity.CloudProvider;
import com.cattool.application.entity.CloudProviderRule;
import com.cattool.application.service.CloudProviderService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cloudProvider")
public class CloudProviderController {
	
	@Autowired
	CloudProviderService cloudProviderService;
	
	@GetMapping("/getAll/{clientId}")
	public List<CloudProvider> getCloudProvider(@PathVariable int clientId)
	{
		return cloudProviderService.getAllcloudProvider(clientId);
	}

	@PutMapping("/setEvaluationOrder")
	public void setEvaluationOrder(@RequestBody List<CloudProvider> cloudProvider)
	{
		cloudProviderService.setEvaluationOrder(cloudProvider);
	}
	
	@PutMapping("/updateCloudProviderRule/{clientId}")
	public void updateCloudProviderRule(@RequestBody List<CloudProviderRule> cloudProviderRule,@PathVariable int clientId)
	{
		cloudProviderService.updateCloudProviderRule(cloudProviderRule,clientId);
	}

}
