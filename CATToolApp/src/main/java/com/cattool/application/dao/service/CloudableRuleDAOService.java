package com.cattool.application.dao.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cattool.application.dao.CloudableRuleDAO;
import com.cattool.application.entity.CloudableRule;
import com.cattool.application.repository.CloudableRuleRepository;

@Component
public class CloudableRuleDAOService {

	@Autowired
	CloudableRuleRepository cloudableRuleRepository;
	public List<CloudableRuleDAO> findcloudableRule(int clientId) {

		List<CloudableRuleDAO> cloudableRuleDAO = new ArrayList<CloudableRuleDAO>();
			
		for(CloudableRule cloudableRule: cloudableRuleRepository.findByClientId(clientId))
		{
			cloudableRuleDAO.add(ToDAO(cloudableRule));
		}
		return cloudableRuleDAO;
	}
	private CloudableRuleDAO ToDAO(CloudableRule cloudableRule) {

		CloudableRuleDAO cloudableRuleDAO = new CloudableRuleDAO();
		cloudableRuleDAO.setClientId(cloudableRule.getClientId());
		cloudableRuleDAO.setCloudableRule(cloudableRule.getCloudableRule());
		cloudableRuleDAO.setCloudableRuleId(cloudableRule.getCloudableRuleId());
		cloudableRuleDAO.setQuestionId(cloudableRule.getQuestionId());
		return cloudableRuleDAO;
	}
	
	

}
