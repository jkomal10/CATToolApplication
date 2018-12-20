package com.cattool.application.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cattool.application.dao.FeedbackDao;
import com.cattool.application.dao.service.FeedbackDAOService;
import com.cattool.application.entity.Feedback;

@Transactional
@Service
public class FeedbackService {
	
	@Autowired
	FeedbackDAOService feedbackDAOService;

	public void saveFeedback(Feedback feedback,String userName,int clientId) {
		FeedbackDao feedbackObj=new FeedbackDao();
		feedbackObj=feedbackDAOService.toDao(feedbackDAOService.getFeedbackByUserName(userName));
		if(feedbackObj==null)
		{
			feedback.setClientId(clientId);
			feedback.setUserName(userName);
			feedbackDAOService.saveFeedback(feedback);
		}
	}

}
