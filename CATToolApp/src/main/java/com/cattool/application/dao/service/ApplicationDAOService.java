package com.cattool.application.dao.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cattool.application.dao.AnswersDAO;
import com.cattool.application.dao.ApplicationDAO;
import com.cattool.application.entity.Answers;
import com.cattool.application.entity.Application;
import com.cattool.application.entity.Users;
import com.cattool.application.repository.AnswersRepository;
import com.cattool.application.repository.ApplicationRepository;
import com.cattool.application.repository.AssessmentQuestionsRepository;
import com.cattool.application.repository.CloudProviderRepository;
import com.cattool.application.repository.CloudProviderRuleRepository;
import com.cattool.application.repository.CloudableRuleRepository;
import com.cattool.application.repository.MigrationRepository;
import com.cattool.application.repository.MigrationRuleRepository;
import com.cattool.application.repository.UserRepository;

@Component
public class ApplicationDAOService {

	@Autowired
	ApplicationRepository applicationRepository;

	@Autowired
	AssessmentQuestionsRepository assessmentQuestionsRepository;

	@Autowired
	AnswersRepository answerRepository;

	@Autowired
	MigrationRuleRepository migrationRuleRepository;

	@Autowired
	CloudableRuleRepository cloudableRuleRepository;

	@Autowired
	CloudProviderRuleRepository cloudProviderRuleRepository;

	@Autowired
	CloudProviderRepository cloudProviderRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	MigrationRepository migrationRepository;

	Boolean isDeactivate = false;
	Boolean isDelete = false;
	int isFinalizeValue = 1;
	Boolean isDeleted = false;

	public List<Application> getAllApplications(int clientId) {
		List<Application> applicationList = new ArrayList<Application>();
		applicationList = applicationRepository.findByClientIdAndIsDeactivateAndIsDeleted(clientId, isDeactivate,
				isDeleted);
		return applicationList;
	}

	public int getAllApplicationCount(int clientId) {
		return getAllApplications(clientId).size();
	}

	public List<ApplicationDAO> getApplicationList(int clientId) {
		List<Application> applicationList = getAllApplications(clientId);
		List<ApplicationDAO> applicationDAOlist = new ArrayList<ApplicationDAO>();

		for (Application application : applicationList) {
			applicationDAOlist.add(ToDAO(application));
		}
		return applicationDAOlist;

	}

	private ApplicationDAO ToDAO(Application application) {
		ApplicationDAO applicationDAO = new ApplicationDAO();
		applicationDAO.setApplicationId(application.getApplicationId());
		applicationDAO.setApplicationName(application.getApplicationName());
		applicationDAO.setApplicationDescription(application.getApplicationDescription());
		applicationDAO.setIsCloudable(application.getIsCloudable());
		applicationDAO.setCloudProvider(application.getCloudProvider());
		applicationDAO.setMigrationPattern(application.getMigrationPattern());
		applicationDAO.setClientId(application.getClientId());
		applicationDAO.setCreatedBy(application.getCreatedBy());
		applicationDAO.setModifiedBy(application.getModifiedBy());
		applicationDAO.setUserId(application.getUserId());
		applicationDAO.setIsSaved(application.getIsSaved());
		applicationDAO.setAssessApplicationTime(application.getAssessApplicationTime());
		applicationDAO.setAssessment(application.isAssessment());
		applicationDAO.setCreatedDate(application.getCreatedDate());
		applicationDAO.setDeactivate(application.isDeactivate());
		applicationDAO.setDeleted(application.isDeleted());
		applicationDAO.setDeletedDateTime(application.getDeletedDateTime());
		applicationDAO.setIsFinalize(application.getIsFinalize());
		applicationDAO.setModifiedDateTime(application.getModifiedDateTime());
		applicationDAO.setVerified(application.isVerified());
		applicationDAO.setRecommendedCloudable(application.getRecommendedCloudable());
		applicationDAO.setRecommendedCloudProvider(application.getRecommendedCloudProvider());
		applicationDAO.setRecommendedMigrationPattern(application.getRecommendedMigrationPattern());
		return applicationDAO;
	}

	public ApplicationDAO getApplicationById(int applicationId) {
		Application application = applicationRepository.findByApplicationId(applicationId);
		ApplicationDAO applicationDAO = ToDAO(application);
		return applicationDAO;
	}

	public Application getApplicationByApplicationId(int applicationId) {
		Application application = applicationRepository.findByApplicationId(applicationId);
		return application;
	}

	public ApplicationDAO findbyApplicationName(String applicationName) {
		Application application = applicationRepository.findByApplicationName(applicationName);
		ApplicationDAO applicationDAO = ToDAO(application);
		return applicationDAO;
	}

	public ApplicationDAO getApplicationByUserName(String userName) {
		Users user = new Users();
		user = userRepository.findByUserName(userName);
		Application application = applicationRepository.findByUserId(user.getUserId());
		ApplicationDAO applicationDAO = ToDAO(application);
		return applicationDAO;

	}

	public void deleteApplicationById(int id) {
		Application app = getApplicationByApplicationId(id);
		app.setDeleted(true);
		applicationRepository.save(app);
	}

	public void resetApplicationById(int applicationId) {
		Application application = getApplicationByApplicationId(applicationId);
		application.setApplicationId(applicationId);
		application.setUserId(applicationRepository.findByApplicationId(applicationId).getUserId());
		application.setClientId(application.getClientId());
		applicationRepository.save(application);
	}

	public void deactivateApplicationById(int applicationId) {
		Application application = getApplicationByApplicationId(applicationId);
		application.setDeactivate(true);
		applicationRepository.save(application);
	}

	public List<ApplicationDAO> getAllReassessment(int clientId) {
		List<Application> applicationList = applicationRepository.findByClientIdAndIsDeletedAndIsFinalize(clientId,
				isDelete, isFinalizeValue);

		List<ApplicationDAO> applicationDAOlist = new ArrayList<ApplicationDAO>();

		for (Application application : applicationList) {
			applicationDAOlist.add(ToDAO(application));
		}
		return applicationDAOlist;
	}

	public void saveApplicationRuleCheck(ApplicationDAO application) {
		Application applications = getApplicationByApplicationId(application.getApplicationId());
		applications.setApplicationId(application.getApplicationId());
		applications.setIsFinalize(1);
		Date dNow = new Date();
		applications.setAssessApplicationTime(dNow);
		applicationRepository.save(applications);
	}

	public void setCloudableInAns(AnswersDAO answers) {
		Answers answer = answerRepository.findByAnswerId(answers.getAnswerId());
		answer.setAnswerId(answers.getAnswerId());
		answer.setCloudAbility(1);
		answerRepository.save(answer);
	}

	public void setCloudabilityForApplication(int applicationId, String string) {
		Application applications = getApplicationByApplicationId(applicationId);
		applications.setApplicationId(applicationId);
		if (string.equals("Yes"))
			applications.setCloudable("Yes");
		else {
			applications.setCloudable("No");
			applications.setCloudProvider("Not Applicable");
			applications.setMigrationPattern("Not Applicable");
		}
		applicationRepository.save(applications);
	}

	public void setCloudprovider(ApplicationDAO application, String cloudProviders) {
		Application applications = getApplicationByApplicationId(application.getApplicationId());
		applications.setApplicationId(application.getApplicationId());
		applications.setCloudProvider(cloudProviders);
		applicationRepository.save(applications);
	}

	public void setMigrationPattern(ApplicationDAO application, String migrationPattern) {
		Application applications = getApplicationByApplicationId(application.getApplicationId());
		applications.setApplicationId(application.getApplicationId());
		applications.setMigrationPattern(migrationPattern);
		applicationRepository.save(applications);
	}

	public List<ApplicationDAO> getAllFinalizeAplication(int clientId) {

		List<Application> applicationList = applicationRepository.findByClientIdAndIsDeletedAndIsFinalize(clientId,
				isDelete, isFinalizeValue);
		List<ApplicationDAO> applications = new ArrayList<ApplicationDAO>();
		for (Application allApplications : applicationList) {
			applications.add(ToDAO(allApplications));
		}

		return applications;
	}

	public void saveApplication(ApplicationDAO application) {
		
		applicationRepository.save(ToApplication(application));
	}

	private Application ToApplication(ApplicationDAO application) {
		Application app = new Application();
		app.setApplicationName(application.getApplicationName());
		app.setApplicationDescription(application.getApplicationDescription());
		app.setApplicationId(application.getApplicationId());
		app.setAssessApplicationTime(application.getAssessApplicationTime());
		app.setAssessment(application.isAssessment());
		app.setClientId(application.getClientId());
		app.setCloudProvider(application.getCloudProvider());
		app.setCreatedBy(application.getCreatedBy());
		app.setCreatedDate(application.getCreatedDate());
		app.setDeactivate(application.isDeactivate());
		app.setDeleted(application.isDeleted());
		app.setDeletedDateTime(application.getDeletedDateTime());
		app.setFinalize(application.getIsFinalize());
		app.setIsCloudable(application.getIsCloudable());
		app.setIsSaved(application.getIsSaved());
		app.setUserId(application.getUserId());
		app.setVerified(application.isVerified());
		app.setMigrationPattern(application.getMigrationPattern());
		app.setModifiedBy(application.getModifiedBy());
		app.setModifiedDateTime(application.getModifiedDateTime());
		app.setCreatedDate(application.getCreatedDate());
		app.setRecommendedCloudable(application.getRecommendedCloudable());
		app.setRecommendedCloudProvider(application.getRecommendedCloudProvider());
		app.setRecommendedMigrationPattern(application.getRecommendedMigrationPattern());
		return app;
	}

	public void updateApplication(String clientName, ApplicationDAO application) {
		Application app = ToApplication(application);
		app.setModifiedBy(clientName);
		applicationRepository.save(app);
	}

}

