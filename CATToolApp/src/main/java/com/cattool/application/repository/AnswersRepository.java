package com.cattool.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cattool.application.entity.Answers;

@Repository
public interface AnswersRepository extends JpaRepository<Answers, Long> {

	Answers findByApplicationId(int applicationId);

//    List<Answers> findById(int applicationId);


	
}

