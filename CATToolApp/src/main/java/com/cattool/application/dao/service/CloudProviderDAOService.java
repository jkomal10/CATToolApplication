package com.cattool.application.dao.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cattool.application.dao.CloudProviderDAO;
import com.cattool.application.dao.CloudProviderRuleDAO;
import com.cattool.application.entity.CloudProvider;
import com.cattool.application.entity.CloudProviderRule;
import com.cattool.application.repository.CloudProviderRepository;
import com.cattool.application.repository.CloudProviderRuleRepository;

@Component
public class CloudProviderDAOService {
	
	@Autowired
	CloudProviderRepository cloudProviderRepository;

	@Autowired
	CloudProviderRuleRepository cloudProviderRuleRepository;

	public List<CloudProviderDAO> findCloudProviderRules(int clientId) {
		
		List<CloudProviderDAO> CloudProviderDAOs = new ArrayList<CloudProviderDAO>();
		
		for(CloudProvider cloudProvider:cloudProviderRepository.findByClientId(clientId))
		{
			List<CloudProviderRuleDAO> cloudProviderRuleDAO = new ArrayList<CloudProviderRuleDAO>();
			for(CloudProviderRule cloudProviderRule:cloudProviderRuleRepository.findByCloudProviderId(cloudProvider.getCloudProviderId()))
			{
				
				cloudProviderRuleDAO.add(ToDAO(cloudProviderRule));
				
			}
			CloudProviderDAOs.add(ToDAOCloudProvider(cloudProvider,cloudProviderRuleDAO));
		}
		 
		 return CloudProviderDAOs;
	}

	private CloudProviderDAO ToDAOCloudProvider(CloudProvider cloudProvider,
			List<CloudProviderRuleDAO> cloudProviderRuleDAO) {
		CloudProviderDAO CloudProviderDAO = new CloudProviderDAO();
		CloudProviderDAO.setClientId(cloudProvider.getClientId());
		CloudProviderDAO.setCloudProviderId(cloudProvider.getCloudProviderId());
		CloudProviderDAO.setCloudProviders(cloudProvider.getCloudProviders());
		CloudProviderDAO.setCloudProviderRules(cloudProviderRuleDAO);
		return CloudProviderDAO;
	}

	private CloudProviderRuleDAO ToDAO(CloudProviderRule cloudProviderRule) {
		
		CloudProviderRuleDAO cloudProviderRuleDAO = new CloudProviderRuleDAO();
		
		
		cloudProviderRuleDAO.setClientId(cloudProviderRule.getClientId());
		cloudProviderRuleDAO.setCloudProviderRule(cloudProviderRule.getCloudProviderRule());
		cloudProviderRuleDAO.setCloudProviderRuleId(cloudProviderRule.getCloudProviderRuleId());
		cloudProviderRuleDAO.setQuestionId(cloudProviderRule.getQuestionId());
		
		return cloudProviderRuleDAO;
	}

}
