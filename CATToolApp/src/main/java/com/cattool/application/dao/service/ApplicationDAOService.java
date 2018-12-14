package com.cattool.application.dao.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cattool.application.dao.ApplicationDAO;
import com.cattool.application.entity.Application;
import com.cattool.application.repository.AnswersRepository;
import com.cattool.application.repository.ApplicationRepository;
import com.cattool.application.repository.AssessmentQuestionsRepository;
import com.cattool.application.repository.CloudProviderRepository;
import com.cattool.application.repository.CloudProviderRuleRepository;
import com.cattool.application.repository.CloudableRuleRepository;
import com.cattool.application.repository.MigrationRepository;
import com.cattool.application.repository.MigrationRuleRepository;
import com.cattool.application.repository.UserRepository;

@Component
public class ApplicationDAOService {
	
	@Autowired
	ApplicationRepository applicationRepository;

	@Autowired
	AssessmentQuestionsRepository assessmentQuestionsRepository;

	@Autowired
	AnswersRepository answerRepository;

	@Autowired
	MigrationRuleRepository migrationRuleRepository;

	@Autowired
	CloudableRuleRepository cloudableRuleRepository;

	@Autowired
	CloudProviderRuleRepository cloudProviderRuleRepository;

	@Autowired
	CloudProviderRepository cloudProviderRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	MigrationRepository migrationRepository;

	Boolean isDeactivate = false;
	Boolean isDelete = false;
	int isFinalizeValue = 1;
	Boolean isDeleted = false;
	
	public List<Application> getAllApplications(int clientId) {
		List<Application> applicationList = new ArrayList<Application>();
		applicationList = applicationRepository.findByClientIdAndIsDeactivateAndIsDeleted(clientId, isDeactivate,isDeleted);
		return applicationList;
	}
	
	public int getAllApplicationCount(int clientId) {
		return getAllApplications(clientId).size();
	}
	
	public List<ApplicationDAO> getApplicationList(int clientId)
	{
		List<Application> applicationList = getAllApplications(clientId);
		List<ApplicationDAO> applicationDAOlist = new ArrayList<ApplicationDAO>();
		return null;
		
	}
	
	
}
