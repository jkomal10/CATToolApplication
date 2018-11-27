package com.cattool.application.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cattool.application.entity.Answers;
import com.cattool.application.entity.Application;
import com.cattool.application.entity.AssessmentQuestions;
import com.cattool.application.entity.CloudProviderRule;
import com.cattool.application.entity.CloudableRule;
import com.cattool.application.entity.MigrationRule;
import com.cattool.application.entity.SummaryReport;
import com.cattool.application.entity.Users;
import com.cattool.application.repository.AnswersRepository;
import com.cattool.application.repository.ApplicationRepository;
import com.cattool.application.repository.AssessmentQuestionsRepository;
import com.cattool.application.repository.CloudProviderRuleRepository;
import com.cattool.application.repository.CloudableRuleRepository;
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
	UserRepository userRepository;
	
	Boolean isDeactivate=false;
	public int getAllAppsCount(int clientId) 
    {   int appsCount=0;
     
        List<Application> applicationList= new ArrayList<Application>(); 
        applicationList=applicationRepository.findByClientIdAndIsDeactivate(clientId, isDeactivate);
        
        appsCount=applicationList.size(); 
            return appsCount; 
    }
	
	public List<Application> getAllApplication(int clientId)
	{
		List<Application> applicationList = new ArrayList<>();
		applicationList=applicationRepository.findByClientIdAndIsDeactivate(clientId, isDeactivate);
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
		System.out.println("Komal");
		application.setApplicationId(applicationId);
		application.setUserId(applicationRepository.findByApplicationId(applicationId).getUserId());
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
		 
		 applicationList=applicationRepository.findByClientIdAndIsDeactivate(clientId, isDeactivate);
   		return applicationList;
	}

	public void allRuleCheck(int applicationId) {
		int gitcCheck=0;
		Application application=applicationRepository.findByApplicationId(applicationId);
		application.setIsFinalize(1);
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
		
		System.out.println("applicationId " + applicationId);
		
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
		System.out.println("numberOfRules"+numberOfRules);
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
		int migrationQuestionIdValue=0;
		int answerTextCount=0;
		int answerIdCount=0;
		boolean publicFalseCheck=true;
		boolean rehostFalseCheck=true;
		List<Answers> answerlist=new ArrayList<Answers>();
		List<MigrationRule> migrationRulelist=new ArrayList<MigrationRule>();
		Application application=applicationRepository.findByApplicationId(applicationId);
		Application application2=applicationRepository.findByApplicationId(applicationId);
		migrationRulelist=migrationRuleRepository.findAll();
		List<MigrationRule> migrationRuleByClientName = new ArrayList<MigrationRule>();
		for(MigrationRule migrationRuleAllRule:migrationRuleRepository.findAll())
		{
			{
				migrationRuleByClientName.add(migrationRuleAllRule);
			}
		}
		
		
		for(Answers answers:answerRepository.findAll())
		{
			if(answers.getApplicationId()==applicationId)
			{
				if(answers.getAnswerText()!=null)
				{
					answerTextCount++;
				}
				answerIdCount++;
				answerlist.add(answers);
			}
		}
		if(answerTextCount==answerIdCount)
		{
		for(MigrationRule migrationRule:migrationRuleByClientName)
		{
			if(gitcCheck!=0)
			{
				publicFalseCheck=false;
			}
			if(gitcCheck==0 &&publicFalseCheck==true && migrationRule.getMigrationId()==1001)//public-pass
			{
				for(Answers answers:answerlist) {
					migrationQuestionIdValue=Integer.parseInt(migrationRule.getQuestionId());
					if(migrationQuestionIdValue==answers.getQuestionId())
					{
						publicFalseCheck=migrationRule.getMigrationRule().contains(answers.getAnswerText());
						if(publicFalseCheck==false)
						{
							publicFalseCheck=(answers.getAnswerText()).contains(migrationRule.getMigrationRule());
						}
							if(publicFalseCheck)
								{
										if(gitcCheck!=0)
										{
											publicFalseCheck=false;
										}
										else
										{
											application.setApplicationId(applicationId);
											application.setMigrationPattern("public-pass");
											application.setIsFinalize(1);
											application.setAssessment(true);
											application.setIsSaved(1);
											applicationRepository.save(application);
										}
								}
							else {
								publicFalseCheck=false;
								break;
							}
							
					}
				}	
				if(publicFalseCheck==false)
				{
					System.out.println("break works in public paas");
				}
			}
			if(publicFalseCheck==false && rehostFalseCheck==true && migrationRule.getMigrationId()==1002)//Rehost
			{
				for(Answers answers:answerlist) {
					migrationQuestionIdValue=Integer.parseInt(migrationRule.getQuestionId());
					if(migrationQuestionIdValue==answers.getQuestionId())
					{
						rehostFalseCheck=answers.getAnswerText().contains(migrationRule.getMigrationRule());
							if(rehostFalseCheck)
								{
										application2.setApplicationId(applicationId);
										application2.setMigrationPattern("Rehost");
										application.setIsSaved(1);
										application.setAssessment(true);
										application.setIsFinalize(1);
										applicationRepository.save(application);
								}
							else {
								rehostFalseCheck=false;
								break;
							}
					}
				}
				if(rehostFalseCheck==false)
				{
					application.setApplicationId(applicationId);
					application.setIsSaved(1);
					application.setAssessment(true);
					application.setIsFinalize(1);
					application.setMigrationPattern("Re-Plateform");
					applicationRepository.save(application);
				}
			}
			else if(rehostFalseCheck==false)
				{
					System.out.println("replateform");
					application.setApplicationId(applicationId);
					application.setIsSaved(1);
					application.setIsFinalize(1);
					application.setAssessment(true);
					application.setMigrationPattern("Re-Plateform");
					applicationRepository.save(application);
				}
			}
	}else {
		
				System.out.println("No answers present for given application!!!!!");
				application.setApplicationId(applicationId);
				application.setMigrationPattern("Re-Plateform");;
				application.setIsSaved(0);
				applicationRepository.save(application);
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
					     System.out.println("filled");
					 JasperExportManager.exportReportToPdfFile(jasperPrint, "/hsjd/CloudRreport"+summaryReportCount+".pdf");
					 summaryReportCount++;
					 System.out.println("pdf done");
				} catch (JRException e) {
					e.printStackTrace();
				}
				System.out.println("After Removing "+summaryReportList);
				
		}
			summaryReportList.clear();
		}	
	}

}