package com.cattool.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cattool.application.entity.AssessmentQuestions;
import com.cattool.application.entity.CloudProvider;
import com.cattool.application.entity.CloudProviderRule;
import com.cattool.application.repository.AssessmentQuestionsRepository;
import com.cattool.application.repository.CloudProviderRepository;

@Service
@Transactional
public class CloudProviderService {
	
	@Autowired
	CloudProviderRepository cloudProviderRepository;
	
	@Autowired
	AssessmentQuestionsRepository assessmentQuestionsRepository;
	
	public List<CloudProvider> getAllcloudProvider(){
		return cloudProviderRepository.findAll();
		
	}

	public void setEvaluationOrder(List<CloudProvider> cloudProvider) {
		
		cloudProviderRepository.saveAll(cloudProvider);
	}

	public List<AssessmentQuestions> getCloudProviderQuestion(int cloudProviderId) {
		
		List<AssessmentQuestions> returnAssessmentQuestions = new ArrayList<AssessmentQuestions>();
		for(AssessmentQuestions questions:assessmentQuestionsRepository.findAll()) {
			List<CloudProviderRule> cloudProviderRule = questions.getCloudProviderRules();
			List<CloudProviderRule> cloudProRul = new ArrayList<CloudProviderRule>();
			for (CloudProviderRule cloudProviderRule2 : cloudProviderRule) {
				
				if(cloudProviderId == cloudProviderRule2.getCloudProviderId()) {
					System.out.println(cloudProviderRule2);

					
					cloudProRul.add(cloudProviderRule2);
					questions.setCloudProviderRules(cloudProRul);
					
					returnAssessmentQuestions.add(questions);

				}
				else
				{
					System.out.println("different");
				}
				
				
			}
			questions.setCloudProviderRules(cloudProviderRule);
	}

		return returnAssessmentQuestions;
		
	}

}
