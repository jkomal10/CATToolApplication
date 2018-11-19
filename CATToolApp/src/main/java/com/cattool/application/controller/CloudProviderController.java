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

import com.cattool.application.entity.AssessmentQuestions;
import com.cattool.application.entity.CloudProvider;
import com.cattool.application.entity.CloudProviderRule;
import com.cattool.application.service.AssessmentQuestionsService;
import com.cattool.application.service.CloudProviderService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cloudProvider")
public class CloudProviderController {
	
	@Autowired
	CloudProviderService cloudProviderService;
	
	@GetMapping("/getAll/{clientName}")
	public List<CloudProvider> getCloudProvider(@PathVariable String clientName)
	{
		return cloudProviderService.getAllcloudProvider(clientName);
	}
	
//	@GetMapping("/getAllCloudProviderQuestion/{cloudProviderId}")
//	public List<AssessmentQuestions> getCloudProviderQuestion(@PathVariable int cloudProviderId)
//	{
//		System.out.println("**********getAllCloudProviderQuestion*********");
//		return cloudProviderService.getCloudProviderQuestion(cloudProviderId);
//	}
//	
	@PutMapping("/setEvaluationOrder")
	public void setEvaluationOrder(@RequestBody List<CloudProvider> cloudProvider)
	{
		
		System.out.println("*************SetEvaluationOrder**********"+cloudProvider);
		
		cloudProviderService.setEvaluationOrder(cloudProvider);
		 
	}
	@PutMapping("/updateCloudProviderRule/{clientName}")
	public void updateCloudProviderRule(@RequestBody List<CloudProviderRule> cloudProviderRule,@PathVariable String clientName)
	{
		System.out.println("***************************************");
		System.out.println(cloudProviderRule);
		cloudProviderService.updateCloudProviderRule(cloudProviderRule,clientName);
	}

}
