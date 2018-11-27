package com.cattool.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cattool.application.entity.Feedback;
import com.cattool.application.service.FeedbackService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/feedback")
public class FeedbackController {
	
	@Autowired
	FeedbackService feedbackService;
	
	@PostMapping("/save/{userName}/{clientId}")
	public void saveAll(@RequestBody Feedback feedback,@PathVariable String userName,@PathVariable int clientId)
	{
		feedbackService.saveFeedback(feedback,userName,clientId);
	}

}
