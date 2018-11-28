package com.cattool.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cattool.application.entity.AssessmentQuestions;

public interface AssessmentQuestionsRepository extends JpaRepository<AssessmentQuestions, Long> {
	
	public void deleteByQuestionId(int questionId);
	public AssessmentQuestions getByQuestionId(int questionId);
	
	public List<AssessmentQuestions> findByClientIdAndAssessmentTypeForCloudable(int clientId, String assessmentTypeForCloudable);
	public List<AssessmentQuestions> findByClientIdAndIsActive(int clientId,int isActive);
    //public List<AssessmentQuestions> findByClientIdAndMigrationRule(int clientId,int migrtaion)	

}
