package com.cattool.application.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cattool.application.entity.Answers;
import com.cattool.application.entity.Application;
import com.cattool.application.entity.CloudProviderRule;
import com.cattool.application.entity.CloudableRule;
import com.cattool.application.entity.MigrationRule;
import com.cattool.application.repository.AnswersRepository;
import com.cattool.application.repository.ApplicationRepository;
import com.cattool.application.repository.CloudProviderRuleRepository;
import com.cattool.application.repository.CloudableRuleRepository;
import com.cattool.application.repository.MigrationRuleRepository;

@Service
@Transactional
public class ApplicationService {
	
	private int gitcCheck=0;

	@Autowired
	ApplicationRepository applicationRepository;

	@Autowired
	AnswersRepository answerRepository;
	
	@Autowired
	MigrationRuleRepository migrationRuleRepository;
	
	@Autowired
	CloudableRuleRepository cloudableRuleRepository;
	
	@Autowired
	CloudProviderRuleRepository cloudProviderRuleRepository;

	
	public List<Application> getAllApplication()
	{
		return applicationRepository.findAll();
	}
	
	public Application saveApplication(Application application)
	{
		return applicationRepository.save(application);
	}
	
	public Application findbyApplicationName(String applicationName)
	{
		return applicationRepository.findByApplicationName(applicationName);
	}

	public void deleteApplicationById(int id) {
		
		applicationRepository.deleteByApplicationId(id);
	}

	public Application GetSingleApplication(int applicationId) {
		return applicationRepository.findByApplicationId(applicationId);
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
	
	public void resetApplicationById(int applicationId)
	{
		Application application=new Application();
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

	public List<Application> getAllReassessment() {
		// TODO Auto-generated method stub
		 List<Application> appList=new ArrayList<Application>();
		 
         for(Application application: applicationRepository.findAll()){
       	 if(application.isFinalize()==1)
        	 {
        		 appList.add(application);
        		 System.out.println(appList);
        	 }
        	 System.out.println(application.getApplicationName());
         }
       
         System.out.println("**************************"+appList+"v  *****************");
		return appList;
	}


	public void allRuleCheck(int applicationId) {
		boolean cloudabilityCheck= cloudableCheck(applicationId);
		if (cloudabilityCheck) {
			boolean cloudProviderCheckTest= cloudProviderCheck(applicationId);
			
			if(cloudProviderCheckTest) {
				migrationCheck(applicationId);
			}
			else
			{
				gitcCheck++;
				migrationCheck(applicationId);
			}
		}
		
	}
	public boolean cloudableCheck(int applicationId){
		int cloudableRuleFlag=0;
		Application application=new Application();
		application=applicationRepository.findByApplicationId(applicationId);
		List<CloudableRule> cloudableRuleList=new ArrayList<CloudableRule>();
		cloudableRuleList = cloudableRuleRepository.findAll();
		
		List<Answers> answersList=new ArrayList<>();
		
		for(Answers  answers : answerRepository.findAll()) {
			if(answers.getApplicationId()==applicationId)
			{
				answersList.add(answers);
			}
		}
		for(CloudableRule cloudableRule:cloudableRuleList) {
			System.out.println("line 1");
			for(Answers answers:answersList) {
				System.out.println("line 2");
				if(cloudableRule.getQuestionId()==(answers.getQuestionId())) {
					System.out.println("cloudableRule.getQuestionId()"+cloudableRule.getQuestionId());
					System.out.println("answers.getQuestionId()"+answers.getQuestionId());
					if(cloudableRule.getCloudableRule().contains(answers.getAnswerText())){
						cloudableRuleFlag++;
						System.out.println(cloudableRule.getCloudableRule()+"cloudableRule.getCloudableRule()");
					    System.out.println(answers.getAnswerText()+"answers.getAnswerText()");
        				}//else {
//						cloudableRuleFlag=0;break;}
					//cloudableQuestionFlag=1;
				}//else {cloudableQuestionFlag=0;}
			}
		}
		if(cloudableRuleFlag==cloudableRuleList.size()){
			application.setCloudable(true);
		return true;}
		else {
			application.setCloudable(false);
			return false;}
	}
	
public boolean cloudProviderCheck(int applicationId){
		
		System.out.println("applicationId " + applicationId);
		
		int count = 0,numberOfRules = 0;
		List<Answers> allAnswers = new ArrayList<>();
		List<Answers> answers = new ArrayList<>();
		Application application=new Application();
		System.out.println("allAnswers** " + allAnswers);
		application = applicationRepository.findByApplicationId(applicationId);
		allAnswers = answerRepository.findAll();
		for (Answers getAnswers : allAnswers) {
			System.out.println("getAnswers.getQuestionId()*** "+getAnswers.getQuestionId());
			if(applicationId==getAnswers.getApplicationId())
			{
				System.out.println("true answerid");
				answers.add(getAnswers);
			}
			
		}
		System.out.println("Specific answers"+answers);
		
	
		List<CloudProviderRule> cloudProviderRule = new ArrayList<>();
		cloudProviderRule = cloudProviderRuleRepository.findAll();
		System.out.println("cloudProviderRule"+cloudProviderRule);
		numberOfRules = cloudProviderRule.size();
		System.out.println("numberOfRules"+numberOfRules);
		
		
		for (Answers userAnswers : answers) {
			
			for(CloudProviderRule cloudProviderRules : cloudProviderRule)
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
		
		System.out.println("count***  "+ count );
		
		if(count == numberOfRules)
		{
			application.setCloudProvider("GITC");
			application.setIsSaved(1);
			applicationRepository.save(application);
			System.out.println("CloudProvider is GITC");
			return false;
		}
		
		else
		{
			application.setCloudProvider("AWS");
			application.setIsSaved(1);
			applicationRepository.save(application);
			System.out.println("CloudProvider is AWS");
			return true;
		}		
	}

	
	public void migrationCheck(int applicationId){
		System.out.println("Migration works");
		int migrationQuestionIdValue=0;
		int answerTextCount=0;
		int answerIdCount=0;
		boolean publicFalseCheck=true;
		boolean rehostFalseCheck=true;
		List<Answers> answerlist=new ArrayList<Answers>();
		List<MigrationRule> migrationRulelist=new ArrayList<MigrationRule>();
		Application application=applicationRepository.findByApplicationId(applicationId);
		Application application2=applicationRepository.findByApplicationId(applicationId);
		System.out.println(application);
		migrationRulelist=migrationRuleRepository.findAll();
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
		for(MigrationRule migrationRule:migrationRulelist)
		{
			System.out.println("gitc check "+gitcCheck);
			if(gitcCheck!=0)
			{
				publicFalseCheck=false;
			}
			if(gitcCheck==0 &&publicFalseCheck==true && migrationRule.getMigrationId()==1001)//public-pass
			{
				System.out.println(migrationRule.getMigrationRule()+"^^^^^^^^^^^^^^public pass");
				for(Answers answers:answerlist) {
					migrationQuestionIdValue=Integer.parseInt(migrationRule.getQuestionId());
					System.out.println(migrationQuestionIdValue+"===="+answers.getQuestionId());
					if(migrationQuestionIdValue==answers.getQuestionId())
					{
						publicFalseCheck=migrationRule.getMigrationRule().contains(answers.getAnswerText());
						System.out.println(publicFalseCheck);
							if(publicFalseCheck)
								{
										if(gitcCheck!=0)
										{
											publicFalseCheck=false;
										}
										else
										{
											System.out.println("**************************public pass");
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
			else if(publicFalseCheck==false && rehostFalseCheck==true && migrationRule.getMigrationId()==1002)//Rehost
			{
				System.out.println(migrationRule.getMigrationRule()+"^^^^^^^^^^^^^^Rehost");
				System.out.println("answerssssssssss"+answerlist);
				for(Answers answers:answerlist) {
					migrationQuestionIdValue=Integer.parseInt(migrationRule.getQuestionId());
					System.out.println(answers.getAnswerText());
					if(migrationQuestionIdValue==answers.getQuestionId())
					{
						System.out.println(migrationRule.getMigrationRule()+"==="+answers.getAnswerText());
						rehostFalseCheck=answers.getAnswerText().contains(migrationRule.getMigrationRule());
						System.out.println(rehostFalseCheck);
							if(rehostFalseCheck)
								{
										System.out.println("Rehost pass");
										application2.setApplicationId(applicationId);
										application2.setMigrationPattern("Rehost");
										application.setIsSaved(1);
										application.setAssessment(true);
										application.setIsFinalize(1);
										applicationRepository.save(application);
										System.out.println(application);
								}
							else {
								rehostFalseCheck=false;
								System.out.println(rehostFalseCheck+" is rehostFalseCheck");
								break;
							}
					}
				}
				if(rehostFalseCheck==false)
				{
					System.out.println("break works in rehost");
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
				System.out.println(migrationRule.getMigrationRule()+"^^^^^^^^^^^^^^Replateform");
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
	
}