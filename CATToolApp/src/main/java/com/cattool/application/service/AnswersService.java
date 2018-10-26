package com.cattool.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cattool.application.entity.Answers;
import com.cattool.application.repository.AnswersRepository;

@Service
public class AnswersService {

	@Autowired
	AnswersRepository answersRepository;
	
	
	public List<Answers> getAllAnswers()
	{
		return 	answersRepository.findAll();
	}
	
	public void saveAnswers(List<Answers> AnswersList ) {
		
		List<Answers> ansList=new ArrayList<Answers>();
		for(Answers answers : AnswersList )
		{ 
			Answers answersObject=new Answers();
			answersObject=answers;
			System.out.println("new answers"+answers.getAnswerId());
			answersObject.setApplicationId(answers.getApplicationId());
			answersObject.setAnswerId(answers.getAnswerId());
			 answersRepository.saveAndFlush(answersObject);
		}
		 //answersRepository.saveAll(AnswersList);
	}
}
