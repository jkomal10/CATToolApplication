package com.cattool.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cattool.application.entity.AssessmentQuestions;
import com.cattool.application.entity.Migration;
import com.cattool.application.repository.AssessmentQuestionsRepository;
import com.cattool.application.repository.MigrationRuleRepository;

@Service
@Transactional
public class MigrationRuleService {
	String value="true";
	
	@Autowired
	MigrationRuleRepository migrationRuleRepository;
	
	@Autowired
	AssessmentQuestionsRepository assessmentQuestionsRepository;
	
	public List<Migration> getAllmigrationRule()
	{
		return migrationRuleRepository.findAll();
	}
	
	public List<AssessmentQuestions> getAllAssessmentTypeForMigration()
	{
		List<AssessmentQuestions> assessmentQuestionList=new ArrayList<AssessmentQuestions>();
		List<AssessmentQuestions> assessmentQuestionListForMigration=new ArrayList<AssessmentQuestions>();
		assessmentQuestionList=assessmentQuestionsRepository.findAll();
		for(AssessmentQuestions assessmentQuestions:assessmentQuestionList) {
			System.out.println(assessmentQuestions.getAssessmentTypeForMigration());
			if(value.equals(assessmentQuestions.getAssessmentTypeForMigration())) {
					System.out.println(assessmentQuestions.getAssessmentTypeForMigration());
					assessmentQuestionListForMigration.add(assessmentQuestions);
			}
		}
		return assessmentQuestionListForMigration;
	}
	
	public List<AssessmentQuestions> getAllAssessmentTypeForCloudable()
	{
		List<AssessmentQuestions> assessmentQuestionList=new ArrayList<AssessmentQuestions>();
		List<AssessmentQuestions> assessmentQuestionListForCloudable=new ArrayList<AssessmentQuestions>();
		assessmentQuestionList=assessmentQuestionsRepository.findAll();
		for(AssessmentQuestions assessmentQuestions:assessmentQuestionList) {
			System.out.println(assessmentQuestions.getAssessmentTypeForCloudable());
			if(value.equals(assessmentQuestions.getAssessmentTypeForCloudable())) {
					System.out.println(assessmentQuestions.getAssessmentTypeForCloudable());
					assessmentQuestionListForCloudable.add(assessmentQuestions);
			}
		}
		return assessmentQuestionListForCloudable;
	}
	
	public List<AssessmentQuestions> getAllAssessmentTypeForCloudProvider()
	{
		List<AssessmentQuestions> assessmentQuestionList=new ArrayList<AssessmentQuestions>();
		List<AssessmentQuestions> assessmentQuestionListForCloudProvider=new ArrayList<AssessmentQuestions>();
		assessmentQuestionList=assessmentQuestionsRepository.findAll();
		for(AssessmentQuestions assessmentQuestions:assessmentQuestionList) {
			System.out.println(assessmentQuestions.getAssessmentTypeForCloudProvider());
			if(value.equals(assessmentQuestions.getAssessmentTypeForCloudProvider())) {
					System.out.println(assessmentQuestions.getAssessmentTypeForMigration());
					assessmentQuestionListForCloudProvider.add(assessmentQuestions);
			}
		}
		return assessmentQuestionListForCloudProvider;
	}
	
	public void setExceutionOrder(List<Migration> migrationlist) {
		migrationRuleRepository.saveAll(migrationlist);
	}

	public void addMigration(Migration migration) {
		migrationRuleRepository.save(migration);		
	}
}
