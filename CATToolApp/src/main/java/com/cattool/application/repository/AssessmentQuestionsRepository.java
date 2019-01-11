package com.cattool.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cattool.application.entity.AssessmentQuestions;

public interface AssessmentQuestionsRepository extends JpaRepository<AssessmentQuestions, Long> {
	
	public void deleteByQuestionId(int questionId);
	public AssessmentQuestions getByQuestionId(int questionId);
	public List<AssessmentQuestions> findByClientIdAndAssessmentTypeForCloudableAndIsDelete(int clientId, String assessmentTypeForCloudable,Boolean isDelete);
	
	public List<AssessmentQuestions> findByClientIdAndAssessmentTypeForCloudable(int clientId, String assessmentTypeForCloudable);
	public List<AssessmentQuestions> findByClientId(int clientId);
	public List<AssessmentQuestions> findByClientIdAndIsDelete(int clientId, int isDelete);
	public List<AssessmentQuestions> findByClientIdAndAssessmentTypeForCloudableAndIsDelete(int clientId,
			String string, int isDelete);
	public List<AssessmentQuestions> findByClientIdAndIsDelete(int clientId, Boolean isDelete);
	public List<AssessmentQuestions> findByClientIdAndIsDeleteAndAssessmentTypeForCloudable(int clientId, int i, String assessmentTypeForCloudable);

}
