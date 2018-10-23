package com.cattool.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cattool.application.entity.CloudableRule;
import com.cattool.application.repository.CloudableRuleRepository;

@Service
public class CloudableRuleService {

	@Autowired
	CloudableRuleRepository cloudableRuleRepository;
	public List<CloudableRule> getAll() {
		
		return cloudableRuleRepository.findAll();
	}
	public void createClodableRule(CloudableRule cloudableRule) {
		
		cloudableRuleRepository.save(cloudableRule);
	}

}
