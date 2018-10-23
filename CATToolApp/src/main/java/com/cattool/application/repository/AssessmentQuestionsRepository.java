package com.cattool.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cattool.application.entity.AssessmentQuestions;

public interface AssessmentQuestionsRepository extends JpaRepository<AssessmentQuestions, Long> {
	
	public void deleteByQuestionId(int questionId);
	public AssessmentQuestions getByQuestionId(int questionId);

}
