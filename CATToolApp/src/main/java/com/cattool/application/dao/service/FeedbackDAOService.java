package com.cattool.application.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cattool.application.dao.FeedbackDao;
import com.cattool.application.entity.Feedback;
import com.cattool.application.repository.FeedbackRepository;

@Component
public class FeedbackDAOService {
	
	@Autowired
	FeedbackRepository feedbackRepository;
	
	

	public Feedback getFeedbackByUserName(String userName) {
		return feedbackRepository.findByUserName(userName);
	}
	
	public FeedbackDao toDao(Feedback feedback) {
		FeedbackDao feedbackDao=new FeedbackDao();
		feedbackDao.setFeedbackId(feedback.getFeedbackId());
		feedbackDao.setClientId(feedback.getClientId());
		feedbackDao.setOther(feedback.getOther());
		feedbackDao.setQuestion1(feedback.getQuestion1());
		feedbackDao.setQuestion2(feedback.getQuestion2());
		feedbackDao.setQuestion3(feedback.getQuestion3());
		feedbackDao.setRating(feedback.getRating());
		feedbackDao.setRecommend(feedback.getRecommend());
		feedbackDao.setUserName(feedback.getUserName());
		return feedbackDao;
	}
	
	public void saveFeedback(Feedback feedback)
	{
		feedbackRepository.save(feedback);
	}

}
