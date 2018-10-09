package com.cattool.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cattool.application.entity.AssessmentQuestions;
import com.cattool.application.entity.QuestionOption;
import com.cattool.application.repository.OptionRepository;
import com.cattool.application.service.OptionService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/option")
public class OptionController {
	@Autowired
	private OptionService optionService;

	@GetMapping("/getAll")
	public List<QuestionOption> getAll()
	{
		return optionService.getAll();
	}
   
	@PostMapping("/save/create")
	public QuestionOption saveQuestionOption(@RequestBody QuestionOption questionOption)
	{
		//AssessmentQuestions assessmentQuestions=new AssessmentQuestions();
		//questionOption.setAssessmentQuestions(questionOption.getAssessmentQuestions());
		System.out.println(questionOption);
		System.out.println("save create in option i=api");
		
		return optionService.saveQuestionOption(questionOption);
	}
}
