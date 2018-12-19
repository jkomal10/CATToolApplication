package com.cattool.assessment.Report.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cattool.assessment.Report.entity.Application;
import com.cattool.assessment.Report.entity.ReportPDF;
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
	
	@GetMapping("/getAllFinalizeAplication/{clientId}/{fromDate}/{toDate}")
	public List<Application>getAllFinalizeAplication(@PathVariable int clientId,@PathVariable Date fromDate,@PathVariable Date toDate)
	{
		System.out.println("Get all application!!");
		return assessmentReportService.getAllFinalizeAplication(clientId,fromDate,toDate);
	}
	
	@GetMapping("/get/report")
	public void summaryRepory() throws FileNotFoundException
	{
		System.out.println("Assessment Report works!!");
//		assessmentReportService.summaryReport();
	}
	@GetMapping("generateReport/{apps}")
	public String[] generateRepory(@PathVariable String apps) throws FileNotFoundException
	{
		System.out.println("-------***************"+apps);
		 return assessmentReportService.summaryReport(apps);
	}
	
	@GetMapping("viewReport/{fromDate}/{toDate}")
	public List<ReportPDF> viewReport(@PathVariable Date fromDate,@PathVariable Date toDate)
	{
		System.out.println("OPOPOPOPOPOPOPOPOPOP");
		return assessmentReportService.viewReport(fromDate,toDate);
	}
	
	@GetMapping("viewReportInBrowser/{appName}")
	public byte[] viewReportInBrowser(@PathVariable String appName) {
		System.out.println("LLLLLLLLLLLLLLLLLLLLLLLLL");
		return assessmentReportService.viewReportInBrowser(appName);
	}
	
	@GetMapping("zipExport/{fromDate}/{toDate}")
	public void zipExport(@PathVariable Date fromDate,@PathVariable Date toDate)
	{
		
			try {
				assessmentReportService.zipExport(fromDate,toDate);
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
