package com.cattool.application.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cattool.application.entity.Answers;
import com.cattool.application.entity.Application;
import com.cattool.application.entity.AssessmentQuestions;
import com.cattool.application.entity.CloudProviderRule;
import com.cattool.application.entity.CloudableRule;
import com.cattool.application.entity.Migration;
import com.cattool.application.entity.MigrationRule;
import com.cattool.application.entity.SummaryReport;
import com.cattool.application.entity.Users;
import com.cattool.application.repository.AnswersRepository;
import com.cattool.application.repository.ApplicationRepository;
import com.cattool.application.repository.AssessmentQuestionsRepository;
import com.cattool.application.repository.CloudProviderRuleRepository;
import com.cattool.application.repository.CloudableRuleRepository;
import com.cattool.application.repository.MigrationRepository;
import com.cattool.application.repository.MigrationRuleRepository;
import com.cattool.application.repository.UserRepository;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
@Transactional
public class ApplicationService {
	
	
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
	UserRepository userRepository;
	
	@Autowired
	MigrationRepository migrationRepository;
	
	Boolean isDeactivate=false;
	Boolean isDelete=false;
	int isFinalizeValue=1;
	public int getAllAppsCount(int clientId) 
    {   int appsCount=0;
     
        List<Application> applicationList= new ArrayList<Application>(); 
        applicationList=applicationRepository.findByClientIdAndIsDeleted(clientId,isDelete);
        
        appsCount=applicationList.size(); 
            return appsCount; 
    }
	
	public List<Application> getAllApplication(int clientId)
	{
		List<Application> applicationList = new ArrayList<>();
		applicationList=applicationRepository.findByClientIdAndIsDeleted(clientId,isDelete);
		return applicationList;
	}
	
	public Application GetSingleApplication(int applicationId) {
		return applicationRepository.findByApplicationId(applicationId);
	}
	
	public Application saveApplication(Application application)
	{
		return applicationRepository.save(application);
	}
	
	public Application findbyApplicationName(String applicationName)
	{
		return applicationRepository.findByApplicationName(applicationName);
	}
	public Application getApplicationByUserName(String userName) {
		Users user=new Users();
		user=userRepository.findByUserName(userName);
		return applicationRepository.findByUserId(user.getUserId());
	}
	
	public Application updateApplication(int applicationId,Application application)
	{
		Application app=new Application();
		app.setApplicationId(application.getApplicationId());
		app.setApplicationName(application.getApplicationName());
		app.setApplicationDescription(application.getApplicationDescription());
		app.setMigrationPattern(application.getMigrationPattern());
		app.setUserId(application.getUserId());
		return applicationRepository.save(application);
	}
	public void deleteApplicationById(int id) {
		
		applicationRepository.deleteByApplicationId(id);
	}
	public void resetApplicationById(int applicationId)
	{
		Application application=new Application();
		application.setApplicationId(applicationId);
		application.setUserId(applicationRepository.findByApplicationId(applicationId).getUserId());
		application.setClientId(application.getClientId());
		applicationRepository.save(application);
	}
	public void deactivateApplicationById(int applicationId) {
		Application application=new Application();
		application = applicationRepository.findByApplicationId(applicationId);
		application.setDeactivate(true);
		application.setUserId(applicationRepository.findByApplicationId(applicationId).getUserId());
		applicationRepository.save(application);
	}
	public List<Application> getAllReassessment(int clientId) {
		 List<Application> applicationList=new ArrayList<Application>();
		 
		 applicationList=applicationRepository.findByClientIdAndIsDeleted(clientId,isDelete);
   		return applicationList;
	}

	public void allRuleCheck(int applicationId) {
		int gitcCheck=0;
		Application application=applicationRepository.findByApplicationId(applicationId);
		application.setIsFinalize(1);
		Date dNow = new Date( );
//		SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
//	    System.out.println("Current Date: " + ft.format(dNow));
	    application.setAssessApplicationTime(dNow);
	    System.out.println(dNow);
		applicationRepository.save(application);
		boolean cloudabilityCheck= cloudableCheck(applicationId);
		if(cloudabilityCheck) {
			boolean cloudproviderCheck=cloudProviderCheck(applicationId);
			if(cloudproviderCheck==false)
			{
				gitcCheck=1;
				migrationCheck(applicationId,gitcCheck);
			}
			else
			{
				gitcCheck=0;
				migrationCheck(applicationId,gitcCheck);
			}
		}
	}
	public boolean cloudableCheck(int applicationId){
		int cloudableRuleFlag=0;
		Application application=new Application();
		application=applicationRepository.findByApplicationId(applicationId);
		int clientId=application.getClientId();
		List<CloudableRule> cloudableRuleListByClientId = new ArrayList<CloudableRule>();
		cloudableRuleListByClientId=cloudableRuleRepository.findByClientId(clientId);
		List<Answers> answersList=new ArrayList<>();
		answersList=answerRepository.findByApplicationId(applicationId);
		for(CloudableRule cloudableRule:cloudableRuleListByClientId) {
			for(Answers answers:answersList) {
				if(cloudableRule.getQuestionId()==(answers.getQuestionId())) {
					if(cloudableRule.getCloudableRule().contains(answers.getAnswerText())){
						answers.setCloudAbility(1);
						cloudableRuleFlag++;
					}
				}
			}
		}
		if(cloudableRuleFlag==cloudableRuleListByClientId.size()){
			application.setCloudable("Yes");
			
		return true;}
		else {
			application.setCloudable("No");
			return false;}
	}
	
public boolean cloudProviderCheck(int applicationId){
		
		int count = 0,numberOfRules = 0;
		List<Answers> allAnswers = new ArrayList<>();
		List<Answers> answers = new ArrayList<>();
		Application application=new Application();
		application = applicationRepository.findByApplicationId(applicationId);
		allAnswers = answerRepository.findAll();
		for (Answers getAnswers : allAnswers) {
			if(applicationId==getAnswers.getApplicationId())
			{
				answers.add(getAnswers);
			}
			
		}
		List<CloudProviderRule> cloudProviderRuleList=new ArrayList<CloudProviderRule>();
		for(CloudProviderRule cloudProviderRuleClientName:cloudProviderRuleRepository.findAll()) {
			{
				cloudProviderRuleList.add(cloudProviderRuleClientName);
			}
		}
		numberOfRules = cloudProviderRuleList.size();
		for (Answers userAnswers : answers) {
			for(CloudProviderRule cloudProviderRules : cloudProviderRuleList)
			{
				if(userAnswers.getQuestionId() == Integer.parseInt(cloudProviderRules.getQuestionId()))
				{
					if(cloudProviderRules.getCloudProviderRule().contains(userAnswers.getAnswerText()))
					{
						count = count+1;
					}
					
				}
			}
			
		}
		
		if(count == numberOfRules)
		{
			application.setCloudProvider("GITC");
			application.setIsSaved(1);
			applicationRepository.save(application);
			return false;
		}
		
		else 
		{
			application.setCloudProvider("AWS");
			application.setIsSaved(1);
			applicationRepository.save(application);
			return true;
		}		
	}

public void migrationCheck(int applicationId,int gitcCheck){
	int migrationFinal=0;
	List<MigrationRule> migrationRuleByClientName = new ArrayList<MigrationRule>();
	for(MigrationRule migrationRuleAllRule:migrationRuleRepository.findAll())
	{
		{
			migrationRuleByClientName.add(migrationRuleAllRule);
		}
	}
	
	List<Answers> answerlist = new ArrayList<Answers>();
	for(Answers answers:answerRepository.findAll())
	{
		if(answers.getApplicationId()==applicationId)
		{
			answerlist.add(answers);
		}
	}

	for(Migration migration:migrationRepository.findAll())
	{
		int count=0;
		for(MigrationRule migrationRuleCount:migrationRuleRepository.findAll())
		{
			if(migration.getMigrationId()==migrationRuleCount.getMigrationId())
			{
				count++;
			}
		}
		
		int countAfter=0;
		for(MigrationRule migrationRule:migrationRuleRepository.findAll()){
			for(Answers answer:answerlist) 
			{
				if(migration.getMigrationId()==migrationRule.getMigrationId())
				{
					if(migrationRule.getMigrationRule().contains(answer.getAnswerText()) || answer.getAnswerText().contains(migrationRule.getMigrationRule()))
					{
						if(Integer.parseInt(migrationRule.getQuestionId())==answer.getQuestionId()) {
							countAfter++;
						}
					}
				}
			}
		}

		if(count==countAfter) {
			if(count>0)
			{
				if(gitcCheck==0)
				{
					Application application=new Application();
					application=applicationRepository.findByApplicationId(applicationId);
					application.setMigrationPattern(migration.getMigrationPattern());
				}
				migrationFinal++;
			}
		}
		
	}

	if(migrationFinal==0)
	{
		Application application=new Application();
		application=applicationRepository.findByApplicationId(applicationId);
		application.setMigrationPattern("Replateform");
	}
}

	

	public void summaryReport() throws FileNotFoundException{
		
		int summaryReportCount=1;
		List<SummaryReport> summaryReportList=new ArrayList<SummaryReport>();
		List<Application> appList=new ArrayList<Application>();
		List<AssessmentQuestions> assessmentQuestionsList=new ArrayList<AssessmentQuestions>();
		for(AssessmentQuestions assessmentQuestions:assessmentQuestionsRepository.findAll())
		{
			if("true".equals(assessmentQuestions.getAssessmentTypeForCloudable()))
			{
				assessmentQuestionsList.add(assessmentQuestions);
			}
		}
		
		for(Application application:applicationRepository.findAll()) {
			List<Answers> answerList=new ArrayList<Answers>();
			if(application.getIsFinalize()==1)
			{
				appList.add(application);
				for(AssessmentQuestions assessmentQuestions:assessmentQuestionsList) 
				{
						
						for(Answers answer:answerRepository.findAll())
						{
							if(answer.getApplicationId()==application.getApplicationId())
							{
								if(answer.getQuestionId()==assessmentQuestions.getQuestionId())
									{
										answerList.add(answer);
									}
							}
						}
				}
				
				List<String> answerTextList=new ArrayList<String>();
				for(Answers answer:answerList)
				{
					answerTextList.add(answer.getAnswerText());
				}
				for(AssessmentQuestions assessmentQuestions:assessmentQuestionsList)
				{
					
					SummaryReport summaryReport=new SummaryReport();
					summaryReport.setApplicationName(application.getApplicationName());
					summaryReport.setApplicationDescription(application.getApplicationDescription());
					for(Answers answer:answerList)
					{
						if(answer.getQuestionId()==assessmentQuestions.getQuestionId())
						{
							summaryReport.setAnswerText(answer.getAnswerText());
							if(answer.isCloudAbility()==1)
							{
								summaryReport.setCloudability("1");
							}
							else
							{
								summaryReport.setCloudability("0");
							}
							
						}
						
					}
					summaryReport.setQuestionText(assessmentQuestions.getQuestionText());
					summaryReport.setAssessment_type("Yes");
					summaryReportList.add(summaryReport);
				}
				
				JRBeanCollectionDataSource jds=new JRBeanCollectionDataSource(summaryReportList);
				Map<String,Object> parametres=new HashMap<String,Object>();
				parametres.put("ItemDataSource", jds);
				InputStream reportStream = new FileInputStream("\\Users\\priyanj\\Volkswagen\\jasperTemplate\\template.jrxml");
				JasperReport report;
				try {
					report = JasperCompileManager.compileReport(reportStream);
					     JasperPrint jasperPrint = JasperFillManager.fillReport(report,parametres, jds);
					 JasperExportManager.exportReportToPdfFile(jasperPrint, "/hsjd/CloudRreport"+summaryReportCount+".pdf");
					 summaryReportCount++;
				} catch (JRException e) {
					e.printStackTrace();
				}
		}
			summaryReportList.clear();
		}	
	}

	public List<Application> getAllFinalizeAplication(int clientId) {
		List<Application> applicationList = new ArrayList<>();
		applicationList=applicationRepository.findByClientIdAndIsDeletedAndIsFinalize(clientId,isDelete,isFinalizeValue);
		return applicationList;
	}

}