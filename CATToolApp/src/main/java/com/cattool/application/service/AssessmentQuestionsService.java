package com.cattool.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cattool.application.entity.AssessmentQuestions;
import com.cattool.application.repository.AssessmentQuestionsRepository;

@Service
public class AssessmentQuestionsService {
	
	@Autowired
	AssessmentQuestionsRepository assessmentQuestionsRepository;
	
	public List<AssessmentQuestions> getAllquestions()
	{
		return assessmentQuestionsRepository.findAll();
	}
	
	public AssessmentQuestions saveQuestions(AssessmentQuestions assessmentQuestions)
	{
		return assessmentQuestionsRepository.save(assessmentQuestions);
	}
	

}
