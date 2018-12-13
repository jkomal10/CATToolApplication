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
import com.cattool.application.entity.CloudProvider;
import com.cattool.application.entity.CloudProviderRule;
import com.cattool.application.entity.CloudableRule;
import com.cattool.application.entity.Migration;
import com.cattool.application.entity.MigrationRule;
import com.cattool.application.entity.SummaryReport;
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


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
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
	CloudProviderRepository cloudProviderRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	MigrationRepository migrationRepository;
	
	Boolean isDeactivate=false;
	Boolean isDelete=false;
	int isFinalizeValue=1;
	Boolean isDeleted = false;
	String publicPass="Public Pass";
	public int getAllAppsCount(int clientId) 
    {   int appsCount=0;
     
        List<Application> applicationList= new ArrayList<Application>(); 
        applicationList=applicationRepository.findByClientIdAndIsDeactivateAndIsDeleted(clientId, isDeactivate, isDeleted);
        
        appsCount=applicationList.size(); 
            return appsCount; 
    }
	
	public List<Application> getAllApplication(int clientId)
	{
		List<Application> applicationList = new ArrayList<>();
		applicationList=applicationRepository.findByClientIdAndIsDeactivateAndIsDeleted(clientId, isDeactivate, isDeleted);
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
		
		Application app=new Application();
		app = applicationRepository.findByApplicationId(id);
		app.setDeleted(true);
		applicationRepository.save(app);
//		applicationRepository.deleteByApplicationId(id);
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
		Application application=applicationRepository.findByApplicationId(applicationId);
		application.setIsFinalize(1);
		Date dNow = new Date( );
	    application.setAssessApplicationTime(dNow);
	    System.out.println(dNow);
		applicationRepository.save(application);
		boolean cloudabilityCheck= cloudableCheck(applicationId);
		if(cloudabilityCheck) {
			cloudProviderCheck(applicationId);
			migrationCheck(applicationId);
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
			String[] cloudableRuleArray=cloudableRule.getCloudableRule().split(",");
			for(Answers answers:answersList) {
				if(cloudableRule.getQuestionId()==(answers.getQuestionId())) {
					for(int i=0;i<cloudableRuleArray.length;i++)
					{
						if(cloudableRuleArray[i].equals(answers.getAnswerText()))
						{
							answers.setCloudAbility(1);
							cloudableRuleFlag++;
						}
					}
				}
			}
		}
		if(cloudableRuleFlag==cloudableRuleListByClientId.size()){
			application.setCloudable("Yes");
			
		return true;}
		else {
			application.setCloudable("No");
			application.setCloudProvider("Not Applicable");
			application.setMigrationPattern("Not Applicable");
			return false;}
	}
	
public void cloudProviderCheck(int applicationId){
		
		Application application=new Application();
		application = applicationRepository.findByApplicationId(applicationId);
		List<Answers> allanswers = answerRepository.findByApplicationId(applicationId);
		for(CloudProvider cloudProvider:cloudProviderRepository.findByClientId(application.getClientId()))
		{
			int count = 0,numberOfRules = 0;
			for(CloudProviderRule getCloudProviderRules:cloudProviderRuleRepository.findByCloudProviderId(cloudProvider.getCloudProviderId()))
			{   
				String[] cloudProviderRuleArray=getCloudProviderRules.getCloudProviderRule().split(",");
				numberOfRules++;
				
				for(Answers answers:allanswers)
				{
					if(answers.getQuestionId()==Integer.parseInt(getCloudProviderRules.getQuestionId()))
					{
						
						for(int i=0;i<cloudProviderRuleArray.length;i++)
						{
								if(cloudProviderRuleArray[i].equals(answers.getAnswerText()))
								{
									
									count++;
									System.out.println(answers.getAnswerText()+"=="+count);
								}
						}					
					}
				}
			}
			System.out.println(count);
			if(count>0)
			{
				application.setCloudProvider(cloudProvider.getCloudProviders());
				break;
			}
			if(numberOfRules==count)
			{
				
				application.setCloudProvider(cloudProvider.getCloudProviders());
				break;
			}
		}
		
		
	}


public void migrationCheck(int applicationId){
	int migrationFinal=0;
	Application application=new Application();
	application = applicationRepository.findByApplicationId(applicationId);
	List<Answers> allanswers = answerRepository.findByApplicationId(applicationId);
	for(Migration migration:migrationRepository.findByClientId(application.getClientId()))
	{
		int count = 0,numberOfRules = 0;	
		for(MigrationRule migrationRule:migrationRuleRepository.findByMigrationId(migration.getMigrationId()))
		{
			String[] migrationRuleArray = migrationRule.getMigrationRule().split(",");
			numberOfRules++;
			for(Answers answers:allanswers)
			{
				if(answers.getQuestionId()==Integer.parseInt(migrationRule.getQuestionId()))
				{
					for(int i=0;i<migrationRuleArray.length;i++)
					{
						
							if(migrationRuleArray[i].equals(answers.getAnswerText()))
							{
								count++;
							}
					}
				}
			}
		}
		if(count==numberOfRules) {
		application.setMigrationPattern(migration.getMigrationPattern());
		applicationRepository.save(application);
		migrationFinal++;
		break;
		}
		
	if(migrationFinal==0)
	{
		application.setMigrationPattern(migration.getMigrationPattern());
	}
		
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