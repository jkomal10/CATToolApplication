package com.cattool.application.service;
/*-----------
 * Author by: 
 * Description
 * 
 */

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cattool.application.dao.AssessmentQuestionsDAO;
import com.cattool.application.dao.service.AssessmentQuestionsDAOService;
import com.cattool.application.entity.AssessmentQuestions;
import com.cattool.application.entity.CloudProviderRule;
import com.cattool.application.entity.CloudableRule;
import com.cattool.application.entity.MigrationRule;
import com.cattool.application.exception.ExceptionMessages;
import com.cattool.application.repository.AssessmentQuestionsRepository;
import com.cattool.application.repository.CloudProviderRuleRepository;
import com.cattool.application.repository.CloudableRuleRepository;
import com.cattool.application.repository.MigrationRepository;
import com.cattool.application.repository.MigrationRuleRepository;
import com.cattool.application.repository.OptionRepository;

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
	
	@Autowired
	CloudProviderRuleRepository cloudProviderRuleRepository;
	
	@Autowired
	MigrationRuleRepository migrationRuleRepository;
	
	@Autowired
	OptionRepository optionRepository;
	
	//-------------------------------------------------------------------------------\\
	
	@Autowired
	AssessmentQuestionsDAOService assessmentQuestionsDAOService;
	
	int isActive=0;
	Boolean isDelete=false;

	public List<AssessmentQuestionsDAO> getAllquestionsByClientId(int clientId) {
		return assessmentQuestionsDAOService.getAllAssessmentQuestion(clientId);
	}
	
	public void saveQuestions(AssessmentQuestions assessmentQuestions)
	{
		assessmentQuestionsDAOService.saveQuestions(assessmentQuestions);
	}
	
	/* */
	public void deleteQuestions(int questionId)
	{
		assessmentQuestionsDAOService.deleteQuestions(questionId);
	}
	
	public void updateQuestions(AssessmentQuestions assessmentQuestions)
	{
		try {
			AssessmentQuestions assessmentQuestion=new AssessmentQuestions();
			optionRepository.deleteByQuestionId(Integer.toString(assessmentQuestions.getQuestionId()));
			if(assessmentQuestions.getAssessmentTypeForCloudProvider()!="true")
			{
				cloudProviderRuleRepository.deleteByQuestionId(Integer.toString(assessmentQuestions.getQuestionId()));
			}
			if(assessmentQuestions.getAssessmentTypeForMigration()!="true")
			{
				migrationRuleRepository.deleteByQuestionId(Integer.toString(assessmentQuestions.getQuestionId()));
			}
			assessmentQuestion=assessmentQuestionsRepository.getByQuestionId(assessmentQuestions.getQuestionId());
			assessmentQuestion.setQuestionId(assessmentQuestions.getQuestionId());
			assessmentQuestion=assessmentQuestions;
			CloudableRule cloudableRule = cloudableRuleRepository.findByQuestionId(assessmentQuestions.getQuestionId());
			System.out.println(assessmentQuestions.getAssessmentTypeForCloudable()+"********");
			if(assessmentQuestions.getAssessmentTypeForCloudable() == "true")
			{
				cloudableRule.setCloudableRuleId(cloudableRule.getCloudableRuleId());
				cloudableRule.setQuestionId(assessmentQuestion.getQuestionId());
				cloudableRule.setQuestionText(assessmentQuestion.getQuestionText());
				cloudableRule.setClientId(assessmentQuestion.getClientId());
				cloudableRule.setQuestionDisplayOrder(assessmentQuestion.getQuestionDisplayOrder());
				cloudableRuleRepository.save(cloudableRule);	
			}
			else
			{
				cloudableRuleRepository.deleteByQuestionId(assessmentQuestion.getQuestionId());
			}
			assessmentQuestionsRepository.save(assessmentQuestion);
			LOGGER.info("Succfully updated the questions");
		} catch (Exception e) {
			LOGGER.error(ExceptionMessages.UpdateQuestion +e);
		}
	}
	
	public List<AssessmentQuestionsDAO> getAllMigrationPattern(int migrationId, int clientId) {
		List<AssessmentQuestionsDAO> assessmentQuestionsList=new ArrayList<AssessmentQuestionsDAO>();
		try {
			for(AssessmentQuestions assessmentQuestions:assessmentQuestionsDAOService.getAssessmentQuestions(clientId)) {
				for(MigrationRule migrationRule:assessmentQuestions.getMigrationRule()) {
					if(migrationId==migrationRule.getMigrationId ()) {
						assessmentQuestionsList.add(assessmentQuestionsDAOService.toDao(assessmentQuestions));
						break;
					}
				}
			}
			System.out.println(assessmentQuestionsList);
			return assessmentQuestionsList;
		} catch (Exception e) {
		}
		return assessmentQuestionsList;
	}
	
	public List<AssessmentQuestionsDAO> getAllcloudProviderRule(int cloudProviderId, int clientId) {
		List<AssessmentQuestionsDAO> assessmentQuestionsList=new ArrayList<AssessmentQuestionsDAO>();
		try {
			for(AssessmentQuestions assessmentQuestions:assessmentQuestionsDAOService.getAssessmentQuestions(clientId)) {
				for(CloudProviderRule cloudProviderRule:assessmentQuestions.getCloudProviderRules()) {
					if(cloudProviderId==cloudProviderRule.getCloudProviderId()) {
						assessmentQuestionsList.add(assessmentQuestionsDAOService.toDao(assessmentQuestions));
						break;
					}
				}
				
			}
			System.out.println(assessmentQuestionsList);
			LOGGER.info("Succfully get all the cloud provider list for dicision tree");
			return assessmentQuestionsList;
		} catch (Exception e) {
			LOGGER.error(ExceptionMessages.MigrationPattern +e);
		}
		return null;
	}

	public List<AssessmentQuestionsDAO> getQuestionsforCloudable(int clientId) {
		return assessmentQuestionsDAOService.getAllAssessmentQuestion(clientId);
	}

}
