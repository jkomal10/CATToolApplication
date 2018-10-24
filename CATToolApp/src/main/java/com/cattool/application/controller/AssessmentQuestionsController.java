package com.cattool.application.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cattool.application.entity.AssessmentQuestions;
import com.cattool.application.entity.MigrationRule;
import com.cattool.application.entity.QuestionOption;
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
	
	@PostMapping("/saveAssessmentQuestions/create")
	public void saveAssessmentQuestions(@RequestBody AssessmentQuestions assessmentQuestions)
	{
		System.out.println("****************save all question******************"+assessmentQuestions);
		System.out.println("migration rule +++++++++++++++++"+assessmentQuestions.getMigrationRule());
//		List<MigrationRule> migrationRuleList =new ArrayList<>();
//		migrationRuleList=assessmentQuestions.getMigrationRule();
//		assessmentQuestions.setMigrationRule(migrationRuleList);
		//assessmentQuestions.setMigrationRule(assessmentQuestions.getMigrationRule());

	//List<QuestionOption> questionOptionList =new ArrayList<>();
	//questionOptionList=assessmentQuestions.getQuestionOption();
  // assessmentQuestions.setQuestionOption(assessmentQuestions.getQuestionOption());
//		
	//assessmentQuestions.setQuestionOption(questionOptionList);
//		
//		System.out.println("secoooooooooooooooooooooooooooooo");
		assessmentQuestionsService.saveQuestions(assessmentQuestions);
	}
	
	@DeleteMapping("/deleteQuestions/{questionId}")
	public void deleteQuestions(@PathVariable int questionId)
	{
		System.out.println("****************delete question******************");
		assessmentQuestionsService.deleteQuestions(questionId);
		
	}
	
	@PutMapping("/updateQuestions/update")
	public void updateQuestionById(@RequestBody AssessmentQuestions assessmentQuestions) {
		System.out.println("***************Update question******************");
		System.out.println("########"+assessmentQuestions.getQuestionId());
		assessmentQuestionsService.updateQuestions(assessmentQuestions);
	}
	
	
}
