package com.cattool.assessment.report.controller;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cattool.assessment.report.service.AssessmentReportService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/assessment/report")
public class AssessmentReportController {
	
	@Autowired
	AssessmentReportService assessmentReportService;
	
	@GetMapping
	public void checkAssessmentReportController() {
		System.out.println("Assessment Report Controller!!!");
	}
	
	@GetMapping("/get/report")
	public void summaryRepory() throws FileNotFoundException
	{
		System.out.println("Assessment Report works!!");
		assessmentReportService.summaryReport();
	}

}
