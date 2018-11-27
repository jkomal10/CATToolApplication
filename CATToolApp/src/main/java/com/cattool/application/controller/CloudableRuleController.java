package com.cattool.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.cattool.application.entity.CloudableRule;
import com.cattool.application.service.CloudableRuleService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cloudableRule")
public class CloudableRuleController {
	
	@Autowired
	CloudableRuleService cloudableRuleService;
	@GetMapping("/getAll/{clientId}")
	public List<CloudableRule> getAllCloudableRules(@PathVariable int clientId)
	{
		return cloudableRuleService.getAll(clientId);
	}
	
	@PostMapping("/save/create")
	public void saveAll(@RequestBody List<CloudableRule> cloudableRule )
	{
		cloudableRuleService.createClodableRule(cloudableRule);
	}

}
