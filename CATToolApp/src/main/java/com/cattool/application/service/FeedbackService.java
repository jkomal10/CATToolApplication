package com.cattool.application.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.cattool.application.entity.Feedback;
import com.cattool.application.repository.FeedbackRepository;

public class FeedbackService {
	
	@Autowired
	FeedbackRepository feedbackRepository;

	public void saveFeedback(Feedback feedback) {
		feedbackRepository.save(feedback);
	}
}
