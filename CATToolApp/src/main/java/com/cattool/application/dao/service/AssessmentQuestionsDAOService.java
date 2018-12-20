package com.cattool.application.dao.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cattool.application.dao.AssessmentQuestionsDAO;
import com.cattool.application.dao.CloudableRuleDAO;
import com.cattool.application.entity.AssessmentQuestions;
import com.cattool.application.entity.CloudableRule;
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
	
	@Autowired
	CloudableRuleDAOService cloudableRuleDAOService;
	
	
	int isActive=0;
	int isDelete=1;//Boolean isDelete=false;
	
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
	
	public void saveQuestions(AssessmentQuestionsDAO assessmentQuestions)
	{
			assessmentQuestionsRepository.save(toService(assessmentQuestions));
			CloudableRuleDAO cloudableRuleDAO = new CloudableRuleDAO();
			if(assessmentQuestions.getAssessmentTypeForCloudable() != null)
			{
				saveCloudableRule(cloudableRuleDAO,assessmentQuestions);
			}
	}

	public void deleteQuestions(int questionId)
	{
			assessmentQuestionsRepository.deleteByQuestionId(questionId);
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
	
	public List<AssessmentQuestionsDAO> getQuestionsforCloudable(int clientId) {
	      List<AssessmentQuestionsDAO> list=new ArrayList<AssessmentQuestionsDAO>();
			list = getAllAssessmentQuestion(clientId);
			return list;
		}
	
	public void setCloudableRule(CloudableRuleDAO cloudableRuleDAO,AssessmentQuestions assessmentQuestion) {
		cloudableRuleDAO.setCloudableRuleId(cloudableRuleDAO.getCloudableRuleId());
		cloudableRuleDAO.setQuestionId(assessmentQuestion.getQuestionId());
		cloudableRuleDAO.setQuestionText(assessmentQuestion.getQuestionText());
		cloudableRuleDAO.setClientId(assessmentQuestion.getClientId());
		cloudableRuleDAO.setQuestionDisplayOrder(assessmentQuestion.getQuestionDisplayOrder());
		cloudableRuleRepository.save(cloudableRuleDAOService.toCloudableRule(cloudableRuleDAO));
	}
	
	public void deleteCloudableRuleByQuestionId(int questionId) {
		cloudableRuleRepository.deleteByQuestionId(questionId);
	}
	
	public List<AssessmentQuestions> getAssessmentQuestions(int clientId) {
		return assessmentQuestionsRepository.findByClientIdAndIsActive(clientId, 0);
	}
	
	public void saveCloudableRule(CloudableRule cloudableRule)
	{
		cloudableRuleRepository.save(cloudableRule);
	}
	
	public CloudableRule getCloudableRuleByQuestionId(int questionId)
	{
		return cloudableRuleRepository.findByQuestionId(questionId);
	}
	
	public AssessmentQuestions getQuestionsByQuestionId(int questionId)
	{
		return assessmentQuestionsRepository.getByQuestionId(questionId);
	}

	public void deleteMigrationRuleByQuestionId(int questionId) {
		migrationRuleRepository.deleteByQuestionId(Integer.toString(questionId));
	}

	public void deleteCloudProviderByQuestionId(int questionId) {
		cloudProviderRuleRepository.deleteByQuestionId(Integer.toString(questionId));
	}

	public void deleteOptionByQuestionId(int questionId) {
		optionRepository.deleteByQuestionId(Integer.toString(questionId));
	}
	
	public void setCloudableRule(AssessmentQuestionsDAO assessmentQuestion)
	{
		CloudableRuleDAO cloudableRuleDAO = cloudableRuleDAOService.ToDAO(getCloudableRuleByQuestionId(assessmentQuestion.getQuestionId()));
		cloudableRuleDAO.setCloudableRuleId(cloudableRuleDAO.getCloudableRuleId());
		cloudableRuleDAO.setQuestionId(assessmentQuestion.getQuestionId());
		cloudableRuleDAO.setQuestionText(assessmentQuestion.getQuestionText());
		cloudableRuleDAO.setClientId(assessmentQuestion.getClientId());
		cloudableRuleDAO.setQuestionDisplayOrder(assessmentQuestion.getQuestionDisplayOrder());
		saveCloudableRule(cloudableRuleDAOService.toCloudableRule(cloudableRuleDAO));
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
	
	private void saveCloudableRule(CloudableRuleDAO cloudableRuleDAO,AssessmentQuestionsDAO assessmentQuestionsDAO) {
		cloudableRuleDAO.setQuestionId(assessmentQuestionsDAO.getQuestionId());
		cloudableRuleDAO.setQuestionText(assessmentQuestionsDAO.getQuestionText());
		cloudableRuleDAO.setClientId(assessmentQuestionsDAO.getClientId());
		cloudableRuleDAO.setQuestionDisplayOrder(assessmentQuestionsDAO.getQuestionDisplayOrder());
		cloudableRuleRepository .save(cloudableRuleDAOService.toCloudableRule(cloudableRuleDAO));
	}
	
	
	public AssessmentQuestions toService(AssessmentQuestionsDAO assessmentQuestion) {
		// TODO Auto-generated method stub
		AssessmentQuestions assessmentQuestionsDAO = new AssessmentQuestions();
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

	public void saveQuestion(AssessmentQuestionsDAO assessmentQuestions) {
		assessmentQuestionsRepository.save(toService(assessmentQuestions));
	}

//	public List<AssessmentQuestions> getQuestions(int clientId) {
//		System.out.println(assessmentQuestionsRepository.findByClientIdAndIsActiveAndIsDelete(clientId, isActive, 0));
//		return assessmentQuestionsRepository.findByClientIdAndIsActiveAndIsDelete(clientId, isActive, 0);
//	}

}
