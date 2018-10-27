package com.cattool.application.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cattool.application.entity.AssessmentQuestions;
import com.cattool.application.entity.CloudProviderRule;
import com.cattool.application.entity.Migration;
import com.cattool.application.entity.MigrationRule;
import com.cattool.application.repository.AssessmentQuestionsRepository;
@Transactional
@Service
public class AssessmentQuestionsService {
	
	@Autowired
	AssessmentQuestionsRepository assessmentQuestionsRepository;
	
	@Autowired
	MigrationRepository migrationRepository;
	
	public List<AssessmentQuestions> getAllquestions()
	{
		return assessmentQuestionsRepository.findAll();
	}
	
	public AssessmentQuestions saveQuestions(AssessmentQuestions assessmentQuestions)
	{
		System.out.println(assessmentQuestions);
		return assessmentQuestionsRepository.save(assessmentQuestions);
	}
	
	public void deleteQuestions(int questionId)
	{
		assessmentQuestionsRepository.deleteByQuestionId(questionId);
	}
	
	public void updateQuestions(AssessmentQuestions assessmentQuestions)
	{
		AssessmentQuestions assessmentQuestion=new AssessmentQuestions();
		assessmentQuestion=assessmentQuestionsRepository.getByQuestionId(assessmentQuestions.getQuestionId());
		assessmentQuestion.setQuestionId(assessmentQuestions.getQuestionId());
		assessmentQuestion.setQuestionText(assessmentQuestions.getQuestionText());
		assessmentQuestion.setQuestionDescription(assessmentQuestions.getQuestionDescription());
		assessmentQuestion.setQuestionType(assessmentQuestions.getQuestionType());
		assessmentQuestion.setQuestionDisplayOrder(assessmentQuestions.getQuestionDisplayOrder());
		assessmentQuestion.setNumberOfOption(assessmentQuestions.getNumberOfOption());
		assessmentQuestion.setActive(assessmentQuestions.isActive());
		assessmentQuestion.setDelete(assessmentQuestions.isDelete());
		assessmentQuestion.setAssessmentTypeForMigration(assessmentQuestions.getAssessmentTypeForMigration());
		assessmentQuestion.setAssessmentTypeForCloudProvider(assessmentQuestions.getAssessmentTypeForCloudProvider());
		assessmentQuestion.setAssessmentTypeForCloudable(assessmentQuestions.getAssessmentTypeForCloudProvider());
		assessmentQuestionsRepository.save(assessmentQuestion);
	}
	
	public List<AssessmentQuestions> getCloudableQuestions(){
		List<AssessmentQuestions> list=new ArrayList<AssessmentQuestions>();
		for(AssessmentQuestions assessmentQuestions:assessmentQuestionsRepository.findAll()) {
			if(assessmentQuestions.getAssessmentTypeForCloudable().equals("true"))
			{
				list.add(assessmentQuestions);
			}
		}
		return list;
	}

	public List<AssessmentQuestions> getAllMigrationPattern(int migrationId) {
		List<AssessmentQuestions> assessmentQuestionsList=new ArrayList<>();
		for(AssessmentQuestions assessmentQuestions:assessmentQuestionsRepository.findAll()) {
			List<MigrationRule> migrationRuleList;
			for(MigrationRule migrationRule:assessmentQuestions.getMigrationRule()) {
				if(migrationId==migrationRule.getMigrationId()) {
				System.out.println(migrationRule);
				
				assessmentQuestionsList.add(assessmentQuestions);
				break;}
			}
		}
		return assessmentQuestionsList;
		
	}

	public List<AssessmentQuestions> getAllcloudProviderRule(int cloudProviderId) {
		List<AssessmentQuestions> assessmentQuestionsList=new ArrayList<>();
		for(AssessmentQuestions assessmentQuestions:assessmentQuestionsRepository.findAll()) {
			List<CloudProviderRule> cloudProviderRuleList;
			for(CloudProviderRule cloudProviderRules : assessmentQuestions.getCloudProviderRules()) {
				if(cloudProviderId == cloudProviderRules.getCloudProviderId())
				{
					System.out.println(cloudProviderRules);
					assessmentQuestionsList.add(assessmentQuestions);
					break;
				}
			}
		}
		return assessmentQuestionsList;
	}
}
