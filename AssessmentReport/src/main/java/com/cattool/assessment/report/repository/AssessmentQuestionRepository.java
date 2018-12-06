package com.cattool.assessment.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cattool.assessment.report.entity.AssessmentQuestions;


public interface AssessmentQuestionRepository extends JpaRepository<AssessmentQuestions, Long>{

}
