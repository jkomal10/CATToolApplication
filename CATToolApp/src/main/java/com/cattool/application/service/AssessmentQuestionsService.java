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
import com.cattool.application.entity.Migration;
import com.cattool.application.entity.MigrationRule;
import com.cattool.application.exception.ExceptionMessages;
import com.cattool.application.repository.AssessmentQuestionsRepository;
import com.cattool.application.repository.CloudableRuleRepository;
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
			System.out.println(assessmentQuestionsList);
			return assessmentQuestionsList;
		} catch (Exception e) {
			LOGGER.error(ExceptionMessages.GetQuestion +e);
			System.out.println(ExceptionMessages.GetQuestion +e);
		}
		return null;
	}
	
	public List<AssessmentQuestions> getAllquestionsByClientName(String clientName)
	{
		List<AssessmentQuestions> assessmentQuestionsList = new ArrayList<>();
		try {
			for (AssessmentQuestions assessmentQuestions : assessmentQuestionsRepository.findAll()) {
				System.out.println(assessmentQuestions.getClientName()+"=="+clientName);
				if(assessmentQuestions.isActive()==0 && clientName.equals(assessmentQuestions.getClientName()))
				{
					assessmentQuestionsList.add(assessmentQuestions);
				}
				
			}
			LOGGER.error("Succfully get all users by client name");
			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"+assessmentQuestionsList);
			return assessmentQuestionsList;
		} catch (Exception e) {
			LOGGER.error(ExceptionMessages.GetQuestionByClientName +e);
			System.out.println(ExceptionMessages.GetQuestionByClientName +e);
		}
		return null;
		
	}
	
	public AssessmentQuestions saveQuestions(AssessmentQuestions assessmentQuestions)
	{
		System.out.println(assessmentQuestions);
		
		try {
			assessmentQuestionsRepository.save(assessmentQuestions);
			CloudableRule cloudableRule = new CloudableRule();
			System.out.println("((((((((   "+assessmentQuestions.getAssessmentTypeForCloudable());
			if(assessmentQuestions.getAssessmentTypeForCloudable() != null)
			{
				System.out.println("*********** "+assessmentQuestions.getAssessmentTypeForCloudable());
				cloudableRule.setQuestionId(assessmentQuestions.getQuestionId());
				cloudableRule.setQuestionText(assessmentQuestions.getQuestionText());
				cloudableRule.setClientName(assessmentQuestions.getClientName());
				cloudableRuleRepository .save(cloudableRule);	
			}
			LOGGER.info("Successfully saved the Questions");
		} catch (Exception e) {
			LOGGER.error(ExceptionMessages.SaveQuestion +e);
			System.out.println(ExceptionMessages.SaveQuestion +e);
		}
//		cloudableRuleRepository .save(cloudableRule);
		return null;

//		AssessmentQuestions a1=new AssessmentQuestions();
//		a1=assessmentQuestionsRepository.save(assessmentQuestions);
//		if(assessmentQuestions.getAssessmentTypeForCloudable()!=null || assessmentQuestions.getAssessmentTypeForCloudable()!="false")
//		{
//			CloudableRule cloudableRule=new CloudableRule();
//			cloudableRule.setQuestionId(a1.getQuestionId());
//			cloudableRule.setQuestionText(a1.getQuestionText());
//			cloudableRuleRepository.save(cloudableRule);
//		}
//		return a1;

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
			System.out.println(ExceptionMessages.DeleteQuestion +e);
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
			System.out.println(ExceptionMessages.UpdateQuestion +e);
		}
	}
	
	public List<AssessmentQuestions> getCloudableQuestions(String clientName){
		List<AssessmentQuestions> list=new ArrayList<AssessmentQuestions>();
		try {
			for(AssessmentQuestions assessmentQuestions:assessmentQuestionsRepository.findAll()) {
				if(assessmentQuestions.getAssessmentTypeForCloudable().equals("true"))
				{
					if(clientName.equals(assessmentQuestions.getClientName())) {
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

	/*public List<AssessmentQuestions> getAllMigrationPattern(int migrationId) {
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
		
	}*/
	
	public List<AssessmentQuestions> getAllMigrationPattern(int migrationId, String clientName) {
		List<AssessmentQuestions> assessmentQuestionsList=new ArrayList<>();
		try {
			for(AssessmentQuestions assessmentQuestions:assessmentQuestionsRepository.findAll()) {
				List<MigrationRule> migrationRuleList;
				for(MigrationRule migrationRule:assessmentQuestions.getMigrationRule()) {
					if(migrationId==migrationRule.getMigrationId()&&clientName.equals(migrationRule.getClientName())) {
					assessmentQuestionsList.add(assessmentQuestions);
					break;
					}
				}
				
			}
			System.out.println(assessmentQuestionsList);
			LOGGER.info("Succfully get all the migration pattern list for dicision tree");
			return assessmentQuestionsList;
			
			
		} catch (Exception e) {
			LOGGER.error(ExceptionMessages.MigrationPattern +e);
			System.out.println(ExceptionMessages.MigrationPattern +e);
		}
		return null;
	}
	
	public List<AssessmentQuestions> getAllcloudProviderRule(int cloudProviderId, String clientName) {
		List<AssessmentQuestions> assessmentQuestionsList=new ArrayList<>();
		try {
			for(AssessmentQuestions assessmentQuestions:assessmentQuestionsRepository.findAll()) {
				List<CloudProviderRule> cloudProviderRuleList;
				for(CloudProviderRule cloudProviderRule:assessmentQuestions.getCloudProviderRules()) {
					if(cloudProviderId==cloudProviderRule.getCloudProviderId() &&clientName.equals(cloudProviderRule.getClientName())) {
					assessmentQuestionsList.add(assessmentQuestions);
					break;
					}
				}
				
			}
			System.out.println(assessmentQuestionsList);
			LOGGER.info("Succfully get all the cloud provider pattern list for dicision tree");
			return assessmentQuestionsList;
		} catch (Exception e) {
			LOGGER.error(ExceptionMessages.CloudProviderPattern +e);
			System.out.println(ExceptionMessages.CloudProviderPattern +e);
		}
		return null;
	}

//	public List<AssessmentQuestions> getAllcloudProviderRule(int cloudProviderId, String clientName) {
//		List<AssessmentQuestions> assessmentQuestionsList=new ArrayList<>();
//		for(AssessmentQuestions assessmentQuestions:assessmentQuestionsRepository.findAll()) {
//			List<CloudProviderRule> cloudProviderRuleList;
//			for(CloudProviderRule cloudProviderRules : assessmentQuestions.getCloudProviderRules()) {
//				if(cloudProviderId == cloudProviderRules.getCloudProviderId() && clientName.equals(cloudProviderRules.getClientName()))
//				{
//					System.out.println(cloudProviderRules);
//					assessmentQuestionsList.add(assessmentQuestions);
//					break;
//				}
//			}
//		}
//		return assessmentQuestionsList;
//	}
}
