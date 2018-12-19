package com.cattool.application.dao.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cattool.application.dao.AnswersDAO;
import com.cattool.application.entity.Answers;
import com.cattool.application.repository.AnswersRepository;

@Component
public class AnswesDAOService {
	

	@Autowired
	AnswersRepository answerRepository;

	public List<AnswersDAO> findAnswers(int applicationId) {
		
		List<AnswersDAO> answersDAOs = new ArrayList<AnswersDAO>();
		AnswersDAO answersDAO = new AnswersDAO();
		for(Answers answer : answerRepository.findByApplicationId(applicationId))
		{
			answersDAOs.add(ToAnsDAO(answer));
		}
		
		
		
		 return answersDAOs;
	}

	private AnswersDAO ToAnsDAO(Answers answer) {
		AnswersDAO answersDAO = new AnswersDAO();
//		for(Answers answer:allAnswer)
//		{
			answersDAO.setAnswerId(answer.getAnswerId());
			answersDAO.setAnswerText(answer.getAnswerText());
			answersDAO.setApplicationId(answer.getApplicationId());
			answersDAO.setQuestionId(answer.getQuestionId());
//		}
		return answersDAO;
	}
	
	

}
