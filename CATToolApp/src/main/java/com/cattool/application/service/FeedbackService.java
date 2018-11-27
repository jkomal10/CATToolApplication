package com.cattool.application.service;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cattool.application.entity.Feedback;
import com.cattool.application.repository.FeedbackRepository;

@Transactional
@Service
public class FeedbackService {
	
	@Autowired
	FeedbackRepository feedbackRepository;

	public void saveFeedback(Feedback feedback,String userName,int clientId) {
		Feedback feedbackObj=new Feedback();
		feedbackObj=feedbackRepository.findByUserName(userName);
		if(feedbackObj!=null)
		{
			System.out.println("Feedback form already exist for user");
		}
		else
		{
			System.out.println(userName);
			feedback.setClientId(clientId);
			feedback.setUserName(userName);
			feedbackRepository.save(feedback);
		}
		
	}

}
