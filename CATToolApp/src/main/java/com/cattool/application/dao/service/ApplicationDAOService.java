package com.cattool.application.dao.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cattool.application.dao.AnswersDAO;
import com.cattool.application.dao.ApplicationDAO;
import com.cattool.application.dao.CloudableRuleDAO;
import com.cattool.application.entity.Answers;
import com.cattool.application.entity.Application;
import com.cattool.application.entity.CloudableRule;
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
		application.setApplicationId(applicationId);
		application.setDeactivate(true);
		application.setUserId(applicationRepository.findByApplicationId(applicationId).getUserId());
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

	public void saveApplication(ApplicationDAO application) {
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

	public void setCloudabilityForApplication(ApplicationDAO application, String string) {
		Application applications = getApplicationByApplicationId(application.getApplicationId());
		applications.setApplicationId(application.getApplicationId());
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

	public void saveApplication(Application application) {
		applicationRepository.save(application);
	}

	public void updateApplication(int applicationId, Application application) {
//		Application app = new Application();
		Application app = getApplicationByApplicationId(application.getApplicationId());
		app.setApplicationId(application.getApplicationId());
		app.setApplicationName(application.getApplicationName());
		app.setApplicationDescription(application.getApplicationDescription());
		app.setMigrationPattern(application.getMigrationPattern());
		app.setUserId(application.getUserId());
		applicationRepository.save(application);
	}

}
