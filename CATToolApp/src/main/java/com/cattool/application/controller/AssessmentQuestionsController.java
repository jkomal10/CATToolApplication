package com.cattool.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cattool.application.entity.AssessmentQuestions;
import com.cattool.application.service.AssessmentQuestionsService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/assessmentQuestions")
public class AssessmentQuestionsController {
	
	@Autowired
	AssessmentQuestionsService  assessmentQuestionsService;
	
	@GetMapping("/getAllQuestions")
	public List<AssessmentQuestions> getAllquestions()
	{
		System.out.println("****************get all question******************");
		return assessmentQuestionsService.getAllquestions();
	}
	
	@RequestMapping("/saveAssessmentQuestions/create")
	public AssessmentQuestions saveAssessmentQuestions(@RequestBody AssessmentQuestions assessmentQuestions)
	{
		System.out.println("****************save all question******************");
		return assessmentQuestionsService.saveQuestions(assessmentQuestions);
	}


	/*@PostMapping("/saveAssessmentQuestions")
	public AssessmentQuestions saveAssessmentQuestions(@RequestBody AssessmentQuestions assessmentQuestions)
	{
		System.out.println("****************save all question******************");
		return assessmentQuestionsService.saveQuestions(assessmentQuestions);
	}
*/
}
