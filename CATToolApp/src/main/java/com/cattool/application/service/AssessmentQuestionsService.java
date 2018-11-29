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
	
	int isActive=0;

	public List<AssessmentQuestions> getAllquestionsByClientId(int clientId) {
		List<AssessmentQuestions> assessmentQuestionList = new ArrayList<AssessmentQuestions>();
		try {
			assessmentQuestionList=assessmentQuestionsRepository.findByClientIdAndIsActive(clientId, isActive);
			LOGGER.info("Succfully get all users by client name");
			return assessmentQuestionList;
		} catch (Exception e) {
			LOGGER.error(ExceptionMessages.GetQuestionByClientName +e);
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
				cloudableRule.setQuestionDisplayOrder(assessmentQuestions.getQuestionDisplayOrder());
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
			list=assessmentQuestionsRepository.findByClientIdAndAssessmentTypeForCloudable(clientId,"true");
			LOGGER.info("Successfully get all the cloudable questions");
			return list;
		} catch (Exception e) {
			LOGGER.error(ExceptionMessages.CloudableQuestion +e);
		}
		return null;
	}
	
	public List<AssessmentQuestions> getAllMigrationPattern(int migrationId, int clientId) {
		List<AssessmentQuestions> assessmentQuestionsList=new ArrayList<AssessmentQuestions>();
		try {
			for(AssessmentQuestions assessmentQuestions:assessmentQuestionsRepository.findByClientIdAndIsActive(clientId, isActive)) {
				for(MigrationRule migrationRule:assessmentQuestions.getMigrationRule()) {
					if(migrationId==migrationRule.getMigrationId ()) {
						assessmentQuestionsList.add(assessmentQuestions);
						break;
					}
				}
			}
			LOGGER.info("Succfully get all the migration pattern list for dicision tree");
			return assessmentQuestionsList;
		} catch (Exception e) {
			LOGGER.error(ExceptionMessages.MigrationPattern +e);
		}
		return assessmentQuestionsList;
	}
	
	public List<AssessmentQuestions> getAllcloudProviderRule(int cloudProviderId, int clientId) {
		List<AssessmentQuestions> assessmentQuestionsList=new ArrayList<AssessmentQuestions>();
		try {
			for(AssessmentQuestions assessmentQuestions:assessmentQuestionsRepository.findByClientIdAndIsActive(clientId, isActive)) {
				for(CloudProviderRule cloudProviderRule:assessmentQuestions.getCloudProviderRules()) {
					if(cloudProviderId==cloudProviderRule.getCloudProviderId()) {
						assessmentQuestionsList.add(assessmentQuestions);
						break;
					}
				}
				
			}
			LOGGER.info("Succfully get all the migration pattern list for dicision tree");
			return assessmentQuestionsList;
		} catch (Exception e) {
			LOGGER.error(ExceptionMessages.MigrationPattern +e);
		}
		return null;
	}

	public List<AssessmentQuestions> getQuestionsforCloudable(int clientId) {
      List<AssessmentQuestions> list=new ArrayList<AssessmentQuestions>();
		list = assessmentQuestionsRepository.findByClientIdAndAssessmentTypeForCloudable(clientId,"true");
		return list;
	}

}
