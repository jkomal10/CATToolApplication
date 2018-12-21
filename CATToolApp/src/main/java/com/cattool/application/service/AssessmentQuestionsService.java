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
import com.cattool.application.dao.CloudProviderRuleDAO;
import com.cattool.application.dao.MigrationRuleDAO;
import com.cattool.application.dao.service.AssessmentQuestionsDAOService;
import com.cattool.application.entity.AssessmentQuestions;
import com.cattool.application.exception.ExceptionMessages;


@Transactional
@Service
public class AssessmentQuestionsService{
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	AssessmentQuestionsDAOService assessmentQuestionsDAOService;
	
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
	
	public void updateQuestions(AssessmentQuestionsDAO assessmentQuestionsDAO)
	{
		try {
			assessmentQuestionsDAOService.deleteOptionByQuestionId(assessmentQuestionsDAO.getQuestionId());
			if(assessmentQuestionsDAO.getAssessmentTypeForCloudProvider()!="true")
			{
				assessmentQuestionsDAOService.deleteCloudProviderByQuestionId(assessmentQuestionsDAO.getQuestionId());
			}
			if(assessmentQuestionsDAO.getAssessmentTypeForMigration()!="true")
			{
				assessmentQuestionsDAOService.deleteMigrationRuleByQuestionId(assessmentQuestionsDAO.getQuestionId());
			}
			
			if(assessmentQuestionsDAO.getAssessmentTypeForCloudable() == "true")
			{
				assessmentQuestionsDAOService.setCloudableRule(assessmentQuestionsDAO);
			}
			else
			{
				assessmentQuestionsDAOService.deleteCloudableRuleByQuestionId(assessmentQuestionsDAO.getQuestionId());
			}
			assessmentQuestionsDAOService.saveQuestion(assessmentQuestionsDAO);
		} catch (Exception e) {
		}
	}
	
	public List<AssessmentQuestionsDAO> getAllMigrationPattern(int migrationId, int clientId) {
		List<AssessmentQuestionsDAO> assessmentQuestionsdaoList=new ArrayList<AssessmentQuestionsDAO>();
		try {
			for(AssessmentQuestionsDAO assessmentQuestionsDAO:assessmentQuestionsDAOService.getAllAssessmentQuestion(clientId)) {
				for(MigrationRuleDAO migrationRuleDAO:assessmentQuestionsDAO.getMigrationRule()) {
					if(migrationId==migrationRuleDAO.getMigrationId ()) {
						assessmentQuestionsdaoList.add(assessmentQuestionsDAO);
						break;
					}
				}
			}
			LOGGER.info("Succfully get all the migration pattern list for dicision tree");
			System.out.println(assessmentQuestionsdaoList);
			return assessmentQuestionsdaoList;
		} catch (Exception e) {
			LOGGER.error(ExceptionMessages.MigrationPattern +e);
		}
		return assessmentQuestionsdaoList;
	}
	
	public List<AssessmentQuestionsDAO> getAllcloudProviderRule(int cloudProviderId, int clientId) {
		List<AssessmentQuestionsDAO> assessmentQuestionsList=new ArrayList<AssessmentQuestionsDAO>();
		try {
			for(AssessmentQuestionsDAO assessmentQuestionsDAO:assessmentQuestionsDAOService.getAllAssessmentQuestion(clientId)) {
				for(CloudProviderRuleDAO cloudProviderRule:assessmentQuestionsDAO.getCloudProviderRules()) {
					if(cloudProviderId==cloudProviderRule.getCloudProviderId()) {
						assessmentQuestionsList.add(assessmentQuestionsDAO);
						break;
					}
				}
				
			}
			LOGGER.info("Succfully get all the cloud provider list for dicision tree");
			System.out.println(assessmentQuestionsList);
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
