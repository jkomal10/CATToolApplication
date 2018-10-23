package com.cattool.application.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cattool.application.entity.AssessmentQuestions;
import com.cattool.application.entity.Migration;
import com.cattool.application.entity.QuestionOption;
import com.cattool.application.service.MigrationRuleService;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/migrationRule")
public class MigrationRuleController {
	
	@Autowired
	MigrationRuleService migrationRuleService;
	
	List<Migration> list;
	
	@GetMapping("/getAll")
	public List<Migration> getAllApplication()
	{
		return migrationRuleService.getAllmigrationRule();
	}
	
//	@GetMapping("/getAllQuestionsForMigration")
//	public List<AssessmentQuestions> getAllquestions()
//	{
//		System.out.println("****************get all migration question******************");
//		System.out.println(migrationRuleService.getAllAssessmentTypeForMigration());
//		return migrationRuleService.getAllAssessmentTypeForMigration();
//	}
//	
//	@PostMapping("/setExceutionOrder/create")
//	public void setExceutionOrder(@RequestBody List<Migration> migrationlist)
//	{
//		System.out.println("****************set execution question******************");
//		migrationRuleService.setExceutionOrder(migrationlist);
//	}
//
//	@PostMapping("/addMigrationRule")
//	public void addData(@RequestBody Migration migration){
//		System.out.println("add migration pattern");
//		migrationRuleService.addMigration(migration);
//	}
}
