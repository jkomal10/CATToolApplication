package com.cattool.application.dao.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cattool.application.dao.AssessmentQuestionsDAO;
import com.cattool.application.dao.CloudProviderRuleDAO;
import com.cattool.application.dao.CloudableRuleDAO;
import com.cattool.application.dao.MigrationRuleDAO;
import com.cattool.application.dao.OptionDAO;
import com.cattool.application.entity.AssessmentQuestions;
import com.cattool.application.entity.CloudProviderRule;
import com.cattool.application.entity.CloudableRule;
import com.cattool.application.entity.MigrationRule;
import com.cattool.application.entity.QuestionOption;
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
	int isDelete=1;
	
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
		
		List<OptionDAO> optionDAOs = new ArrayList<>();
		for(QuestionOption questionOption:assessmentQuestion.getQuestionOption())
		{
			optionDAOs.add(toOptiontoDAO(questionOption));
		}
		assessmentQuestionsDAO.setQuestionOption(optionDAOs);
		
		List<MigrationRuleDAO> migrationRuleDAOs = new ArrayList<>();
		for(MigrationRule migrationRule:assessmentQuestion.getMigrationRule())
		{
			migrationRuleDAOs.add(toMigrationRuleDAO(migrationRule));
		}
		assessmentQuestionsDAO.setMigrationRule(migrationRuleDAOs);
		
		List<CloudProviderRuleDAO> cloudProviderRuleDAOs=new ArrayList<>();
		for(CloudProviderRule cloudProviderRule:assessmentQuestion.getCloudProviderRules())
		{
			cloudProviderRuleDAOs.add(toCloudProviderRuleDAO(cloudProviderRule));
		}
		assessmentQuestionsDAO.setCloudProviderRules(cloudProviderRuleDAOs);
		return assessmentQuestionsDAO;
		
		
	}
	
	private OptionDAO toOptiontoDAO(QuestionOption questionOption) {
		
		OptionDAO optionDAO = new OptionDAO();
		optionDAO.setOptionId(questionOption.getOptionId());
		optionDAO.setOptionText(questionOption.getOptionText());
		optionDAO.setQuestionId(questionOption.getQuestionId());
		
		return optionDAO;

	}
	
private MigrationRuleDAO toMigrationRuleDAO(MigrationRule migrationRule) {
		
	MigrationRuleDAO migrationRuleDAO = new MigrationRuleDAO();
	migrationRuleDAO.setClientId(migrationRule.getClientId());
	migrationRuleDAO.setMigrationId(migrationRule.getMigrationId());
	migrationRuleDAO.setMigrationRule(migrationRule.getMigrationRule());
	migrationRuleDAO.setMigrationRuleId(migrationRule.getMigrationRuleId());
	migrationRuleDAO.setQuestionId(migrationRule.getQuestionId());
	migrationRuleDAO.setQuestionText(migrationRule.getQuestionText());
	return migrationRuleDAO;
	}

private CloudProviderRuleDAO toCloudProviderRuleDAO(CloudProviderRule cloudProviderRule) {
	
	CloudProviderRuleDAO cloudProviderRuleDAO = new CloudProviderRuleDAO();
	cloudProviderRuleDAO.setClientId(cloudProviderRule.getClientId());
	cloudProviderRuleDAO.setCloudProviderId(cloudProviderRule.getCloudProviderId());
	cloudProviderRuleDAO.setCloudProviderRule(cloudProviderRule.getCloudProviderRule());
	cloudProviderRuleDAO.setCloudProviderRuleId(cloudProviderRule.getCloudProviderRuleId());
	cloudProviderRuleDAO.setExecutionOrder(cloudProviderRule.getExecutionOrder());
	cloudProviderRuleDAO.setQuestionId(cloudProviderRule.getQuestionId());
	cloudProviderRuleDAO.setQuestionText(cloudProviderRule.getQuestionText());
	return cloudProviderRuleDAO;
	}

	private void saveCloudableRule(CloudableRuleDAO cloudableRuleDAO,AssessmentQuestionsDAO assessmentQuestionsDAO) {
		cloudableRuleDAO.setQuestionId(assessmentQuestionsDAO.getQuestionId());
		cloudableRuleDAO.setQuestionText(assessmentQuestionsDAO.getQuestionText());
		cloudableRuleDAO.setClientId(assessmentQuestionsDAO.getClientId());
		cloudableRuleDAO.setQuestionDisplayOrder(assessmentQuestionsDAO.getQuestionDisplayOrder());
		cloudableRuleRepository .save(cloudableRuleDAOService.toCloudableRule(cloudableRuleDAO));
	}
	
	
	public AssessmentQuestions toService(AssessmentQuestionsDAO assessmentQuestionDao) {
		AssessmentQuestions assessmentQuestion = new AssessmentQuestions();
		assessmentQuestion.setQuestionId(assessmentQuestionDao.getQuestionId());
		assessmentQuestion.setAssessmentTypeForCloudable(assessmentQuestionDao.getAssessmentTypeForCloudable());
		assessmentQuestion.setAssessmentTypeForCloudProvider(assessmentQuestionDao.getAssessmentTypeForCloudProvider());
		assessmentQuestion.setAssessmentTypeForMigration(assessmentQuestionDao.getAssessmentTypeForMigration());
		assessmentQuestion.setClientId(assessmentQuestionDao.getClientId());
		assessmentQuestion.setIsActive(assessmentQuestionDao.getIsActive());
		assessmentQuestion.setIsDelete(assessmentQuestionDao.getIsDelete());
		assessmentQuestion.setNumberOfOption(assessmentQuestionDao.getNumberOfOption());
		assessmentQuestion.setQuestionDescription(assessmentQuestionDao.getQuestionDescription());
		assessmentQuestion.setQuestionDisplayOrder(assessmentQuestionDao.getQuestionDisplayOrder());
		assessmentQuestion.setQuestionText(assessmentQuestionDao.getQuestionText());
		assessmentQuestion.setQuestionType(assessmentQuestionDao.getQuestionType());
		List<QuestionOption> optionList = new ArrayList<>();
		for(OptionDAO questionOption:assessmentQuestionDao.getQuestionOption())
		{
			optionList.add(toOption(questionOption));
		}
		assessmentQuestion.setQuestionOption(optionList);
		if(assessmentQuestionDao.getMigrationRule()!=null)
		{
			List<MigrationRule> migrationRuleList = new ArrayList<>();
			for(MigrationRuleDAO migrationRuleDAOs:assessmentQuestionDao.getMigrationRule())
			{
				migrationRuleList.add(toMigrationRule(migrationRuleDAOs));
			}
			assessmentQuestion.setMigrationRule(migrationRuleList);
		}
		
		if(assessmentQuestionDao.getCloudProviderRules()!=null)
		{
			List<CloudProviderRule> cloudProviderRuleList=new ArrayList<>();
			for(CloudProviderRuleDAO cloudProviderRuleDAO:assessmentQuestionDao.getCloudProviderRules())
			{
				cloudProviderRuleList.add(toCloudProviderRule(cloudProviderRuleDAO));
			}
			assessmentQuestion.setCloudProviderRules(cloudProviderRuleList);
		}
		return assessmentQuestion;
	}
	
private QuestionOption toOption(OptionDAO optionDAO) {
		
		QuestionOption option = new QuestionOption();
		option.setOptionId(optionDAO.getOptionId());
		option.setOptionText(optionDAO.getOptionText());
		option.setQuestionId(optionDAO.getQuestionId());
		return option;
	}
	
private MigrationRule toMigrationRule(MigrationRuleDAO migrationRuleDAO) {
		
		MigrationRule migrationRule = new MigrationRule();
		migrationRule.setClientId(migrationRuleDAO.getClientId());
		migrationRule.setMigrationId(migrationRuleDAO.getMigrationId());
		migrationRule.setQuestionText(migrationRuleDAO.getQuestionText());
		migrationRule.setMigrationRule(migrationRuleDAO.getMigrationRule());
		migrationRule.setMigrationRuleId(migrationRuleDAO.getMigrationRuleId());
		migrationRule.setQuestionId(migrationRuleDAO.getQuestionId());
		return migrationRule;
	}

private CloudProviderRule toCloudProviderRule(CloudProviderRuleDAO cloudProviderRuleDao) {
	
		CloudProviderRule cloudProviderRule = new CloudProviderRule();
		cloudProviderRule.setClientId(cloudProviderRuleDao.getClientId());
		cloudProviderRule.setCloudProviderId(cloudProviderRuleDao.getCloudProviderId());
		cloudProviderRule.setCloudProviderRule(cloudProviderRuleDao.getCloudProviderRule());
		cloudProviderRule.setCloudProviderRuleId(cloudProviderRuleDao.getCloudProviderRuleId());
		cloudProviderRule.setExecutionOrder(cloudProviderRuleDao.getExecutionOrder());
		cloudProviderRule.setQuestionId(cloudProviderRuleDao.getQuestionId());
		cloudProviderRule.setQuestionText(cloudProviderRuleDao.getQuestionText());
		return cloudProviderRule;
	}


	public void saveQuestion(AssessmentQuestionsDAO assessmentQuestions) {
		assessmentQuestionsRepository.save(toService(assessmentQuestions));
	}

	public List<AssessmentQuestions> getQuestions(int clientId) {
		return assessmentQuestionsRepository.findByClientIdAndIsActiveAndIsDelete(clientId, isActive, 0);
	}

}
