package com.cattool.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cattool.application.dao.OptionDAO;
import com.cattool.application.dao.service.OptionDAOService;
import com.cattool.application.entity.AssessmentQuestions;
import com.cattool.application.entity.QuestionOption;
import com.cattool.application.repository.OptionRepository;

@Service
public class OptionService {

	@Autowired
	private OptionDAOService optionDAOService;
	
	public List<OptionDAO> getAll()
	{
		return optionDAOService.getAll();
	}

	public QuestionOption saveQuestionOption(OptionDAO questionOption) {
		return optionDAOService.saveQuestionOption(questionOption);
		
	}
}
