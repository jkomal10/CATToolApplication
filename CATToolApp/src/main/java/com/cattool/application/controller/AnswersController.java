package com.cattool.application.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cattool.application.dao.AnswersDAO;
import com.cattool.application.service.AnswersService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/answer")
public class AnswersController {
	
	@Autowired
	AnswersService answersService;
	
	@GetMapping("getAll")
	public List<AnswersDAO> getAllAnswers()
	{
		return answersService.getAllAnswers();
	}
	@GetMapping("/getAnswersByApplicationId/{applicationId}")
	public List<AnswersDAO> getAnswersByApplicationId(@PathVariable int applicationId) {
	 return answersService.GetSingleApplication(applicationId);	
	}
	
	@PostMapping("/save/create")
	public void saveAnswers(@RequestBody  List<AnswersDAO> answers)
	{
		answersService.saveAnswers(answers);
		
	}
	@PutMapping("/update")
	public void update(@RequestBody List<AnswersDAO> answerList) {
		answersService.updateAns(answerList);
	}


}
