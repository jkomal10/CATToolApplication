package com.cattool.assessment.Report.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cattool.assessment.Report.entity.Answers;



@Repository
public interface AnswersRepository extends JpaRepository<Answers, Long> {

	List<Answers> findByApplicationId(int applicationId);
	Answers deleteByApplicationId(int applicationId);
	
}

