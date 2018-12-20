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
import com.cattool.application.entity.MigrationRule;
import com.cattool.application.exception.ExceptionMessages;
import com.cattool.application.repository.AssessmentQuestionsRepository;


@Transactional
@Service
public class AssessmentQuestionsService{
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	AssessmentQuestionsDAOService assessmentQuestionsDAOService;
	
	@Autowired
	AssessmentQuestionsRepository assessmentQuestionsRepository;
	
	int isActive=0;
	int isDelete=1;//Boolean isDelete=false;
	
	

	public List<AssessmentQuestionsDAO> getAllquestionsByClientId(int clientId) {
		return assessmentQuestionsDAOService.getAllAssessmentQuestion(clientId);
	}
	
	public void saveQuestions(AssessmentQuestionsDAO assessmentQuestions)
	{
		assessmentQuestionsDAOService.saveQuestions(assessmentQuestions);
	}
	
	public void deleteQuestions(int questionId)
	{
		assessmentQuestionsDAOService.deleteQuestions(questionId);
		if(assessmentQuestionsDAOService.getCloudableRuleById(questionId)!=null)
		{
			assessmentQuestionsDAOService.deleteCloudableRule(assessmentQuestionsDAOService.getCloudableRuleById(questionId).getCloudableRuleId());
		}
	}
	
	public void updateQuestions(AssessmentQuestionsDAO assessmentQuestions)
	{
		try {
			assessmentQuestionsDAOService.deleteOptionByQuestionId(assessmentQuestions.getQuestionId());
			if(assessmentQuestions.getAssessmentTypeForCloudProvider()!="true")
			{
				assessmentQuestionsDAOService.deleteCloudProviderByQuestionId(assessmentQuestions.getQuestionId());
			}
			if(assessmentQuestions.getAssessmentTypeForMigration()!="true")
			{
				assessmentQuestionsDAOService.deleteMigrationRuleByQuestionId(assessmentQuestions.getQuestionId());
			}
			
			if(assessmentQuestions.getAssessmentTypeForCloudable() == "true")
			{
				assessmentQuestionsDAOService.setCloudableRule(assessmentQuestions);
			}
			else
			{
				assessmentQuestionsDAOService.deleteCloudableRuleByQuestionId(assessmentQuestions.getQuestionId());
			}
			assessmentQuestionsDAOService.saveQuestion(assessmentQuestions);
		} catch (Exception e) {
		}
	}
	
	public List<AssessmentQuestions> getAllMigrationPattern(int migrationId, int clientId) {
		List<AssessmentQuestions> assessmentQuestionsList=new ArrayList<AssessmentQuestions>();
		try {
			for(AssessmentQuestions assessmentQuestions:assessmentQuestionsDAOService.getAssessmentQuestions(clientId)) {
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
			for(AssessmentQuestions assessmentQuestions:assessmentQuestionsDAOService.getAssessmentQuestions(clientId)) {
				for(CloudProviderRule cloudProviderRule:assessmentQuestions.getCloudProviderRules()) {
					if(cloudProviderId==cloudProviderRule.getCloudProviderId()) {
						assessmentQuestionsList.add(assessmentQuestions);
						break;
					}
				}
				
			}
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
	
	public List<AssessmentQuestions> getQuestions(int clientId) {
		return assessmentQuestionsDAOService.getQuestions(clientId);
	}
	
//	public List<AssessmentQuestionsDAO> getAllMigrationPattern(int migrationId, int clientId) {
//	List<AssessmentQuestionsDAO> assessmentQuestionsList=new ArrayList<AssessmentQuestionsDAO>();
//	try {
//		for(AssessmentQuestions assessmentQuestions:assessmentQuestionsDAOService.getAssessmentQuestions(clientId)) {
//			for(MigrationRule migrationRule:assessmentQuestions.getMigrationRule()) {
//				if(migrationId==migrationRule.getMigrationId ()) {
//					assessmentQuestionsList.add(assessmentQuestionsDAOService.toDao(assessmentQuestions));
//					break;
//				}
//			}
//		}
//		System.out.println(assessmentQuestionsList);
//		return assessmentQuestionsList;
//	} catch (Exception e) {
//	}
//	return assessmentQuestionsList;
//}
	

}
