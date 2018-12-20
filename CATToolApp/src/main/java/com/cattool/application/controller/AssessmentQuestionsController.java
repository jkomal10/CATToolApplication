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

import com.cattool.application.dao.AssessmentQuestionsDAO;
import com.cattool.application.entity.AssessmentQuestions;
import com.cattool.application.entity.CloudableRule;
import com.cattool.application.entity.MigrationRule;
import com.cattool.application.entity.QuestionOption;
import com.cattool.application.service.AssessmentQuestionsService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/assessmentQuestions")
public class AssessmentQuestionsController {
	
	@Autowired
	AssessmentQuestionsService  assessmentQuestionsService;

	
	@GetMapping("/getCloudableQuestion/{clientId}")
	public List<AssessmentQuestionsDAO> getQuestionsforCloudable(@PathVariable int clientId)
	{
		return assessmentQuestionsService.getQuestionsforCloudable(clientId);
	}
		
	@GetMapping("/getAllQuestions/{clientId}")
	public List<AssessmentQuestionsDAO> getAllquestionsByClientId(@PathVariable int clientId)
	{
		return assessmentQuestionsService.getAllquestionsByClientId(clientId);
	}
	
//	@GetMapping("/getAllQuestions/{clientId}")
//	public List<AssessmentQuestions> getAllquestionsByClientId(@PathVariable int clientId)
//	{
//		return assessmentQuestionsService.getQuestions(clientId);
//	}
	
	@PostMapping("/saveAssessmentQuestions/create")
	public void saveAssessmentQuestions(@RequestBody AssessmentQuestionsDAO assessmentQuestionsDAO)
	{
		assessmentQuestionsService.saveQuestions(assessmentQuestionsDAO);
	}
	
	@DeleteMapping("/deleteQuestions/{questionId}")
	public void deleteQuestions(@PathVariable int questionId)
	{
		assessmentQuestionsService.deleteQuestions(questionId);
	}
	
	@PutMapping("/updateQuestions/update")
	public void updateQuestionById(@RequestBody AssessmentQuestionsDAO assessmentQuestions) {
		assessmentQuestionsService.updateQuestions(assessmentQuestions);
	}
	
//	@GetMapping("/getAllCloudableQuestions/{clientId}")
//	public List<AssessmentQuestions> getCloudableQuestions(@PathVariable int clientId)
//	{
//		return assessmentQuestionsService.getCloudableQuestions(clientId);
//	}
	
	@GetMapping("/getAllMigrationPattern/{migrationId}/{clientId}")
	public List<AssessmentQuestions> getAllMigrationPattern(@PathVariable("migrationId") int migrationId,@PathVariable int clientId)
	{
		return assessmentQuestionsService.getAllMigrationPattern(migrationId,clientId);
	}
	
	@GetMapping("/getAllCloudProviderRule/{cloudProviderId}/{clientId}")
	public List<AssessmentQuestions> getAllcloudProviderRule(@PathVariable("cloudProviderId") int cloudProviderId,@PathVariable int clientId)
	{
		return assessmentQuestionsService.getAllcloudProviderRule(cloudProviderId,clientId);
	}
	
	
}
