package com.cattool.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cattool.application.entity.AssessmentQuestions;
import com.cattool.application.service.AssessmentQuestionsService;

@RestController
@RequestMapping("/assessmentQuestions")
public class AssessmentQuestionsController {
	
	@Autowired
	AssessmentQuestionsService  assessmentQuestionsService;
	
	@GetMapping("/getAllQuestions")
	public List<AssessmentQuestions> getAllquestions()
	{
		return assessmentQuestionsService.getAllquestions();
	}

	@PostMapping("/saveApplication")
	public AssessmentQuestions saveAssessmentQuestions(@RequestBody AssessmentQuestions assessmentQuestions)
	{
		return assessmentQuestionsService.saveQuestions(assessmentQuestions);
	}

}
