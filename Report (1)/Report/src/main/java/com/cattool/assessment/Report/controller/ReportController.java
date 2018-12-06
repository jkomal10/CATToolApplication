package com.cattool.assessment.Report.controller;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cattool.assessment.Report.repository.service.ReportService;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/assessment/report")
public class ReportController {
	
	@Autowired
	ReportService assessmentReportService;
	
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
