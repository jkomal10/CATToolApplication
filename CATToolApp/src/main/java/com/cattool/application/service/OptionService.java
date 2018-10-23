package com.cattool.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cattool.application.entity.AssessmentQuestions;
import com.cattool.application.entity.QuestionOption;
import com.cattool.application.repository.OptionRepository;

@Service
public class OptionService {

	@Autowired
	private OptionRepository optionRepository; 
	
	public List<QuestionOption> getAll()
	{
		return optionRepository.findAll();
	}

//	public QuestionOption saveQuestionOption(QuestionOption questionOption) {
//		this.optionRepository.saveAndFlush(questionOption);
//		return optionRepository.save(questionOption);
//		
//	}
	public QuestionOption saveQuestionOption(QuestionOption questionOption) {
		System.out.println();
		//questionOption.setAssessmentQuestions(questionOption.getAssessmentQuestions());
		return optionRepository.save(questionOption);
		
	}
}
