package com.cattool.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cattool.application.entity.AssessmentQuestions;

public interface AssessmentQuestionsRepository extends JpaRepository<AssessmentQuestions, Long> {
	
	public void deleteByQuestionId(int questionId);
	public AssessmentQuestions getByQuestionId(int questionId);
	public List<AssessmentQuestions> findByClientIdAndAssessmentTypeForCloudableAndIsDelete(int clientId, String assessmentTypeForCloudable,Boolean isDelete);
	
	public List<AssessmentQuestions> findByClientIdAndAssessmentTypeForCloudable(int clientId, String assessmentTypeForCloudable);
	public List<AssessmentQuestions> findByClientIdAndIsActive(int clientId,int isActive);
    //public List<AssessmentQuestions> findByClientIdAndMigrationRule(int clientId,int migrtaion)	
	public List<AssessmentQuestions> findByClientIdAndIsActiveAndIsDelete(int clientId, int isActive, int isDelete);
	public List<AssessmentQuestions> findByClientIdAndAssessmentTypeForCloudableAndIsActiveAndIsDelete(int clientId,
			String string, int isActive, int isDelete);

}
