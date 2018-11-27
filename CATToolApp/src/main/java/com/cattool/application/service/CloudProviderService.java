package com.cattool.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cattool.application.entity.CloudProvider;
import com.cattool.application.entity.CloudProviderRule;
import com.cattool.application.repository.AssessmentQuestionsRepository;
import com.cattool.application.repository.CloudProviderRepository;
import com.cattool.application.repository.CloudProviderRuleRepository;

@Service
@Transactional
public class CloudProviderService {
	
	@Autowired
	CloudProviderRepository cloudProviderRepository;
	
	@Autowired
	CloudProviderRuleRepository cloudProviderRuleRepository;
	
	@Autowired
	AssessmentQuestionsRepository assessmentQuestionsRepository;
	
	public List<CloudProvider> getAllcloudProvider(int clientId){
		List<CloudProvider> migrationList=new ArrayList<CloudProvider>();
		for(CloudProvider migration:cloudProviderRepository.findAll()) {
			if(clientId==migration.getClientId()) {
				migrationList.add(migration);
			}
		}
		System.out.println(migrationList);
		return migrationList;
	}

	public void setEvaluationOrder(List<CloudProvider> cloudProvider) {
		
		cloudProviderRepository.saveAll(cloudProvider);
	}

	public void updateCloudProviderRule(List<CloudProviderRule> cloudProviderRulelist,int clientId) {
		
		CloudProviderRule cloudProviderRules = new CloudProviderRule();
		for (CloudProviderRule cloudProviderRule : cloudProviderRulelist) {
			cloudProviderRules = cloudProviderRule;
			cloudProviderRules.setCloudProviderRuleId(cloudProviderRule.getCloudProviderRuleId());
			cloudProviderRules.setClientId(clientId);
			cloudProviderRuleRepository.save(cloudProviderRules);
		}
	}

}
