package com.cattool.application.dao.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cattool.application.dao.AnswersDAO;
import com.cattool.application.entity.Answers;
import com.cattool.application.entity.Application;
import com.cattool.application.repository.AnswersRepository;
import com.cattool.application.repository.ApplicationRepository;

@Component
public class AnswesDAOService {
	

	@Autowired
	AnswersRepository answerRepository;
	
	@Autowired
	ApplicationRepository applicationRepository;
	
	@Autowired
	AnswersRepository answersRepository;

	public List<AnswersDAO> findAnswers(int applicationId) {
		
		List<AnswersDAO> answersDAOs = new ArrayList<AnswersDAO>();
		for(Answers answer : answerRepository.findByApplicationId(applicationId))
		{
			answersDAOs.add(ToAnsDAO(answer));
		}
		
		
		
		 return answersDAOs;
	}

	private AnswersDAO ToAnsDAO(Answers answer) {
		AnswersDAO answersDAO = new AnswersDAO();
			answersDAO.setAnswerId(answer.getAnswerId());
			answersDAO.setAnswerText(answer.getAnswerText());
			answersDAO.setCloudAbility(answer.getCloudAbility());
			answersDAO.setOptionId(answer.getOptionId());
			answersDAO.setApplicationId(answer.getApplicationId());
			answersDAO.setQuestionId(answer.getQuestionId());
		return answersDAO;
	}
	
	private Answers ToAnswers(AnswersDAO answers)
	{
		Answers answersObject=new Answers();
		answersObject.setApplicationId(answers.getApplicationId());
		answersObject.setAnswerId(answers.getAnswerId());
		answersObject.setAnswerText(answers.getAnswerText());
		answersObject.setCloudAbility(answers.getCloudAbility());
		answersObject.setOptionId(answers.getOptionId());
		answersObject.setQuestionId(answers.getQuestionId());
		return answersObject;
	}

	public void saveAnswers(List<AnswersDAO> AnswersList) {
		int count=0;
		int applicationIdFromUI=0;
		for(AnswersDAO answers : AnswersList )
		{ 
			Answers answersObject=ToAnswers(answers);
			if(answersObject.getAnswerText()!=null )
			{
			}
			else
			{
				answersObject.setAnswerText("0");
			}
			answerRepository.saveAndFlush(answersObject);	
			 if(count==0)
			 {
				 Application application=new Application();
				 applicationIdFromUI=answers.getApplicationId();
				 application=applicationRepository.findByApplicationId(applicationIdFromUI);
				 application.setApplicationId(applicationIdFromUI);
				 application.setIsSaved(1);
				 applicationRepository.save(application);
				 count++;
			 }
	}
	
}

	public List<AnswersDAO> getAll() {
		List<Answers> answers = answersRepository.findAll();
		List<AnswersDAO> answersDAO = new ArrayList<AnswersDAO>();
		for(Answers answer: answers) {
			answersDAO.add(ToDAO(answer));
		}
		
		return 	answersDAO;
	}

	private AnswersDAO ToDAO(Answers answer) {

		AnswersDAO answers = new AnswersDAO();
		answers.setAnswerId(answer.getAnswerId());
		answers.setAnswerText(answer.getAnswerText());
		answers.setApplicationId(answer.getApplicationId());
		answers.setCloudAbility(answer.getCloudAbility());
		answers.setOptionId(answer.getOptionId());
		answers.setQuestionId(answer.getQuestionId());
		return answers;
	}

	public List<AnswersDAO> GetSingleApplication(int applicationId) {
		List<Answers> ansList=new ArrayList<>();
		List<AnswersDAO> answersDAOlist = new ArrayList<AnswersDAO>();
		ansList=answersRepository.findByApplicationId(applicationId);
		for(Answers answers:ansList)
		{
			answersDAOlist.add(ToDAO(answers));
		}
		return answersDAOlist;
	}

	public void updateAns(List<AnswersDAO> answerList) {
		
		for(AnswersDAO answer: answerList )
		{ 
		Answers answerObj=ToAnswers(answer);
			answersRepository.save(answerObj);
		}
		
	}
}