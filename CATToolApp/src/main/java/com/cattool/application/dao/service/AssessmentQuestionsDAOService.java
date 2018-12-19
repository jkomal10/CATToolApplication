package com.cattool.application.dao.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cattool.application.dao.AssessmentQuestionsDAO;
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

@Component
public class AssessmentQuestionsDAOService {

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
	
	int isActive=0;
	Boolean isDelete=false;
	
	
	public List<AssessmentQuestionsDAO> getAllAssessmentQuestion(int clientId){
		List<AssessmentQuestionsDAO> assessmentQuestionDAOList=new ArrayList<AssessmentQuestionsDAO>();
		List<AssessmentQuestions> assessmentQuestionList=assessmentQuestionsRepository.findByClientIdAndIsActiveAndIsDelete(clientId, isActive, 0);
		return toGetAllAssessmentQuestionDao(assessmentQuestionList,assessmentQuestionDAOList);
	}
	
	public List<AssessmentQuestionsDAO> toGetAllAssessmentQuestionDao(List<AssessmentQuestions> assessmentQuestionList,List<AssessmentQuestionsDAO> assessmentQuestionDAOList){
		for(AssessmentQuestions assessmentQuestion:assessmentQuestionList)
		{
			assessmentQuestionDAOList.add(toDao(assessmentQuestion));
		}
		return assessmentQuestionDAOList;
	}
	
	public AssessmentQuestionsDAO toDao(AssessmentQuestions assessmentQuestion) {
		// TODO Auto-generated method stub
		AssessmentQuestionsDAO assessmentQuestionsDAO = new AssessmentQuestionsDAO();
		assessmentQuestionsDAO.setQuestionId(assessmentQuestion.getQuestionId());
		assessmentQuestionsDAO.setAssessmentTypeForCloudable(assessmentQuestion.getAssessmentTypeForCloudable());
		assessmentQuestionsDAO.setAssessmentTypeForCloudProvider(assessmentQuestion.getAssessmentTypeForCloudProvider());
		assessmentQuestionsDAO.setAssessmentTypeForMigration(assessmentQuestion.getAssessmentTypeForMigration());
		assessmentQuestionsDAO.setClientId(assessmentQuestion.getClientId());
		assessmentQuestionsDAO.setIsActive(assessmentQuestion.getIsActive());
		assessmentQuestionsDAO.setIsDelete(assessmentQuestion.getIsDelete());
		assessmentQuestionsDAO.setNumberOfOption(assessmentQuestion.getNumberOfOption());
		assessmentQuestionsDAO.setQuestionDescription(assessmentQuestion.getQuestionDescription());
		assessmentQuestionsDAO.setQuestionDisplayOrder(assessmentQuestion.getQuestionDisplayOrder());
		assessmentQuestionsDAO.setQuestionText(assessmentQuestion.getQuestionText());
		assessmentQuestionsDAO.setQuestionType(assessmentQuestion.getQuestionType());
		return assessmentQuestionsDAO;
	}
	
	
	public void saveQuestions(AssessmentQuestions assessmentQuestions)
	{
			assessmentQuestionsRepository.save(assessmentQuestions);
			CloudableRule cloudableRule = new CloudableRule();
			if(assessmentQuestions.getAssessmentTypeForCloudable() != null)
			{
				saveCloudableRule(cloudableRule,assessmentQuestions);
			}
	}

	private void saveCloudableRule(CloudableRule cloudableRule,AssessmentQuestions assessmentQuestions) {
		cloudableRule.setQuestionId(assessmentQuestions.getQuestionId());
		cloudableRule.setQuestionText(assessmentQuestions.getQuestionText());
		cloudableRule.setClientId(assessmentQuestions.getClientId());
		cloudableRule.setQuestionDisplayOrder(assessmentQuestions.getQuestionDisplayOrder());
		cloudableRuleRepository .save(cloudableRule);
	}
	
	
	public void deleteQuestions(int questionId)
	{
			assessmentQuestionsRepository.deleteByQuestionId(questionId);
			if(getCloudableRuleById(questionId)!=null)
			{
				deleteCloudableRule(getCloudableRuleById(questionId).getCloudableRuleId());
			}
	}
	
	public CloudableRule getCloudableRuleById(int questionId) {
		return cloudableRuleRepository.findByQuestionId(questionId);
	}
	
	public void deleteCloudableRule(int cloudableRuleId)
	{
		cloudableRuleRepository.deleteBycloudableRuleId(cloudableRuleId);
	}
	
	public List<AssessmentQuestionsDAO> getCloudableQuestions(int clientId){
		return getCloudableQuestion(clientId);
		
	}
	
	public List<AssessmentQuestionsDAO> getCloudableQuestion(int clientId) {
		List<AssessmentQuestionsDAO> assessmentQuestionDAOList=new ArrayList<>();
		List<AssessmentQuestions> assessmentQuestionList= assessmentQuestionsRepository.findByClientIdAndAssessmentTypeForCloudable(clientId,"true");
		return toGetAllAssessmentQuestionDao(assessmentQuestionList,assessmentQuestionDAOList);
	}
	
	public List<AssessmentQuestionsDAO> getAllcloudProviderRule(int cloudProviderId, int clientId) {
		List<AssessmentQuestionsDAO> assessmentQuestionsDaoList=new ArrayList<AssessmentQuestionsDAO>();
		try {
			for(AssessmentQuestionsDAO assessmentQuestions:getAllAssessmentQuestion(clientId)) {
				for(CloudProviderRule cloudProviderRule:assessmentQuestions.getCloudProviderRules()) {
					if(cloudProviderId==cloudProviderRule.getCloudProviderId()) {
						assessmentQuestionsDaoList.add(assessmentQuestions);
						break;
					}
				}
				
			}
			System.out.println(assessmentQuestionsDaoList);
			return assessmentQuestionsDaoList;
		} catch (Exception e) {
		}
		return assessmentQuestionsDaoList;
	}
	
	public List<AssessmentQuestionsDAO> getQuestionsforCloudable(int clientId) {
	      List<AssessmentQuestionsDAO> list=new ArrayList<AssessmentQuestionsDAO>();
			list = getAllAssessmentQuestion(clientId);
			System.out.println(list);
			return list;
		}
	
	public void setCloudableRule(CloudableRule cloudableRule,AssessmentQuestions assessmentQuestion) {
		cloudableRule.setCloudableRuleId(cloudableRule.getCloudableRuleId());
		cloudableRule.setQuestionId(assessmentQuestion.getQuestionId());
		cloudableRule.setQuestionText(assessmentQuestion.getQuestionText());
		cloudableRule.setClientId(assessmentQuestion.getClientId());
		cloudableRule.setQuestionDisplayOrder(assessmentQuestion.getQuestionDisplayOrder());
		cloudableRuleRepository.save(cloudableRule);
	}
	
	public void deleteCloudableRuleByQuestionId(int questionId) {
		cloudableRuleRepository.deleteByQuestionId(questionId);
	}
	
	public List<AssessmentQuestions> getAssessmentQuestions(int clientId) {
		return assessmentQuestionsRepository.findByClientIdAndIsActive(clientId, 0);
	}

}
