package com.cattool.application.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cattool.application.entity.Answers;
import com.cattool.application.entity.Application;
import com.cattool.application.service.AnswersService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/answer")
public class AnswersController {
	
	@Autowired
	AnswersService answersService;
	
	@GetMapping("getAll")
	public List<Answers> getAllAnswers()
	{
		System.out.println("getAll answer*******");
		return answersService.getAllAnswers();
	}
	@GetMapping("/getAnswersByApplicationId/{applicationId}")
	public List<Answers> getAnswersByApplicationId(@PathVariable("applicationId") int id) {
		System.out.println("get answer by id "+id);
	 return answersService.GetSingleApplication(id);	
	}
	
	@PostMapping("/save/create")
	public void saveAnswers(@RequestBody  List<Answers> answers)
	{
		System.out.println("***********************************************************************************%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"+answers);
//		for( Answers list : answers)
//		System.out.println("new answ"+list);
		answersService.saveAnswers(answers);
		
	}

}
