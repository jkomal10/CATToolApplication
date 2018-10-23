package com.cattool.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cattool.application.entity.CloudableRule;
import com.cattool.application.service.CloudableRuleService;

@RestController
@RequestMapping("/cloudableRule")
public class CloudableRuleController {
	
	@Autowired
	CloudableRuleService cloudableRuleService;
	@GetMapping("/getAll")
	public List<CloudableRule> getAllCloudableRules()
	{
		return cloudableRuleService.getAll();
	}
	
	@PostMapping("/save/create")
	public void saveAll(@RequestBody CloudableRule cloudableRule )
	{
		cloudableRuleService.createClodableRule(cloudableRule);
	}

}
