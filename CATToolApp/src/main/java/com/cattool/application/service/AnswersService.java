package com.cattool.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cattool.application.entity.Answers;
import com.cattool.application.entity.Application;
import com.cattool.application.repository.AnswersRepository;
import com.cattool.application.repository.ApplicationRepository;

@Service
public class AnswersService {

	@Autowired
	AnswersRepository answersRepository;
	
	@Autowired
	ApplicationRepository applicationRepository;
	
	
	
	
	public List<Answers> getAllAnswers()
	{
		return 	answersRepository.findAll();
	}
	
	public List<Answers> GetSingleApplication(int applicationId) {
		List<Answers> ansList=new ArrayList<>();
		for(Answers answers: answersRepository.findAll()) {
			if(answers.getApplicationId()==applicationId)
		ansList.add(answers);
		System.out.println(ansList);
		}
		return ansList;
		//answersRepository.findByApplicationId(applicationId);     findByApplicationId(applicationId)
	}
	
	public void saveAnswers(List<Answers> AnswersList ) {
		int count=0;
		int applicationIdFromUI=0;
		List<Answers> ansList=new ArrayList<Answers>();
		for(Answers answers : AnswersList )
		{ 
			Answers answersObject=new Answers();
			answersObject=answers;
//			System.out.println("new answers"+answers.getAnswerId());
			answersObject.setApplicationId(answers.getApplicationId());
			answersObject.setAnswerId(answers.getAnswerId());
//			System.out.println(answersObject);
			 answersRepository.saveAndFlush(answersObject);	
			 if(count==0)
			 {
				 Application application=new Application();
				 applicationIdFromUI=answers.getApplicationId();
				 application=applicationRepository.findByApplicationId(applicationIdFromUI);
				 application.setApplicationId(applicationIdFromUI);
				 application.setIsSaved(1);
				 System.out.println(application);
				 applicationRepository.save(application);
				 System.out.println(applicationIdFromUI);
				 count++;
			 }
		}
		
		
		
		System.out.println("applicationIdFromUI"+applicationIdFromUI);
		Application application=new Application();
		application=applicationRepository.findByApplicationId(applicationIdFromUI);
		application.setApplicationId(applicationIdFromUI);
		application.setIsSaved(1);
		applicationRepository.save(application);
		 //answersRepository.saveAll(AnswersList);
	}
}
