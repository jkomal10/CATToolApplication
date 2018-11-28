package com.cattool.application.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cattool.application.entity.AssessmentQuestions;
import com.cattool.application.entity.CloudProviderRule;
import com.cattool.application.entity.CloudableRule;
import com.cattool.application.entity.MigrationRule;
import com.cattool.application.entity.Users;
import com.cattool.application.exception.ExceptionMessages;
import com.cattool.application.repository.AssessmentQuestionsRepository;
import com.cattool.application.repository.CloudableRuleRepository;
import com.cattool.application.repository.MigrationRepository;

@Transactional
@Service
public class AssessmentQuestionsService{
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	AssessmentQuestionsRepository assessmentQuestionsRepository;
	
	@Autowired
	MigrationRepository migrationRepository;
	
	@Autowired
	CloudableRuleRepository cloudableRuleRepository;
	
	public List<AssessmentQuestions> getAllquestions()
	{
		List<AssessmentQuestions> assessmentQuestionsList = new ArrayList<>();
		try {
			for (AssessmentQuestions assessmentQuestions : assessmentQuestionsRepository.findAll()) {
				
				if(assessmentQuestions.isActive()==0)
				{
					assessmentQuestionsList.add(assessmentQuestions);
				}
				
			}
			LOGGER.info("Successfully get all the questions");
			return assessmentQuestionsList;
		} catch (Exception e) {
			LOGGER.error(ExceptionMessages.GetQuestion +e);
		}
		return null;
	}

	
	public List<AssessmentQuestions> getAllquestionsByClientId(int clientId) {
		List<AssessmentQuestions> assessmentQuestionList = new ArrayList<>();
		
		System.out.println(assessmentQuestionsRepository.findAll());
		try {
			for (AssessmentQuestions users : assessmentQuestionsRepository.findAll()) {
				if (clientId==users.getClientId()) {
					assessmentQuestionList.add(users);
				}
			}
			LOGGER.error("Succfully get all users by client name");
			return assessmentQuestionList;
		} catch (Exception e) {
			LOGGER.error(ExceptionMessages.GetQuestionByClientName +e);
			System.out.println(ExceptionMessages.GetUserDetails + e);
		}
		return null;

	}
	
	public AssessmentQuestions saveQuestions(AssessmentQuestions assessmentQuestions)
	{
		try {
			assessmentQuestionsRepository.save(assessmentQuestions);
			CloudableRule cloudableRule = new CloudableRule();
			if(assessmentQuestions.getAssessmentTypeForCloudable() != null)
			{
				cloudableRule.setQuestionId(assessmentQuestions.getQuestionId());
				cloudableRule.setQuestionText(assessmentQuestions.getQuestionText());
				cloudableRule.setClientId(assessmentQuestions.getClientId());
				cloudableRuleRepository .save(cloudableRule);	
			}
			LOGGER.info("Successfully saved the Questions");
		} catch (Exception e) {
			LOGGER.error(ExceptionMessages.SaveQuestion +e);
		}
		return null;
	}
	
	public void deleteQuestions(int questionId)
	{
		try {
			assessmentQuestionsRepository.deleteByQuestionId(questionId);
			List<CloudableRule>cloudableRuleList=new ArrayList<>();
			cloudableRuleList=cloudableRuleRepository.findAll();
			for(CloudableRule cloudableRule : cloudableRuleList)
			{
				if(cloudableRule.getQuestionId() == questionId) {
					int cloudableRuleId=cloudableRule.getCloudableRuleId();
					cloudableRuleRepository.deleteBycloudableRuleId(cloudableRuleId);
				}
				
			}
			LOGGER.info("Succfully delete the question");
		} catch (Exception e) {
			LOGGER.error(ExceptionMessages.DeleteQuestion +e);
		}
	}
	
	public void updateQuestions(AssessmentQuestions assessmentQuestions)
	{
		try {
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
			LOGGER.info("Succfully updated the questions");
		} catch (Exception e) {
			LOGGER.error(ExceptionMessages.UpdateQuestion +e);
		}
	}
	
	public List<AssessmentQuestions> getCloudableQuestions(int clientId){
		List<AssessmentQuestions> list=new ArrayList<AssessmentQuestions>();
		try {
			for(AssessmentQuestions assessmentQuestions:assessmentQuestionsRepository.findAll()) {
				if(assessmentQuestions.getAssessmentTypeForCloudable().equals("true"))
				{
					if((clientId==assessmentQuestions.getClientId())) {
					list.add(assessmentQuestions);
					}
				}
			}
			LOGGER.info("Successfully get all the cloudable questions");
			return list;
		} catch (Exception e) {
			LOGGER.error(ExceptionMessages.CloudableQuestion +e);
			System.out.println(ExceptionMessages.CloudableQuestion +e);
		}
		return null;
	}

	public List<AssessmentQuestions> getAllMigrationPattern(int migrationId, int clientId) {
		List<AssessmentQuestions> assessmentQuestionsList=new ArrayList<AssessmentQuestions>();
		try {
			for(AssessmentQuestions assessmentQuestions:assessmentQuestionsRepository.findAll()) {
				for(MigrationRule migrationRule:assessmentQuestions.getMigrationRule()) {
					if(migrationId==migrationRule.getMigrationId ()&& (clientId==(migrationRule.getClientId()))) {
						assessmentQuestionsList.add(assessmentQuestions);
						break;
					}
				}
				
			}
			LOGGER.info("Succfully get all the migration pattern list for dicision tree");
			System.out.println(assessmentQuestionsList);
			return assessmentQuestionsList;
		} catch (Exception e) {
			LOGGER.error(ExceptionMessages.MigrationPattern +e);
		}
		return null;
	}
	
	public List<AssessmentQuestions> getAllcloudProviderRule(int cloudProviderId, int clientId) {
		List<AssessmentQuestions> assessmentQuestionsList=new ArrayList<AssessmentQuestions>();
		try {
			for(AssessmentQuestions assessmentQuestions:assessmentQuestionsRepository.findAll()) {
				for(CloudProviderRule cloudProviderRule:assessmentQuestions.getCloudProviderRules()) {
					if(cloudProviderId==cloudProviderRule.getCloudProviderId()&& (clientId==(cloudProviderRule.getClientId()))) {
						assessmentQuestionsList.add(assessmentQuestions);
						break;
					}
				}
				
			}
			LOGGER.info("Succfully get all the migration pattern list for dicision tree");
			System.out.println(assessmentQuestionsList);
			return assessmentQuestionsList;
		} catch (Exception e) {
			LOGGER.error(ExceptionMessages.MigrationPattern +e);
		}
		return null;
	}

	public List<AssessmentQuestions> getQuestionsforCloudable(int clientId) {
      List<AssessmentQuestions> list=new ArrayList<AssessmentQuestions>();
		list = assessmentQuestionsRepository.findByClientIdAndAssessmentTypeForCloudable(clientId,"true");
		System.out.println(list);
		return null;
	}

}
