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
	
	@GetMapping("/getAllFinalizeAplication/{clientId}/{fromDate}/{toDate}")
	public List<Application>getAllFinalizeAplication(@PathVariable int clientId,@PathVariable Date fromDate,@PathVariable Date toDate)
	{
		return assessmentReportService.getAllFinalizeAplication(clientId,fromDate,toDate);
	}
	
	@GetMapping("generateReport/{apps}")
	public String[] generateRepory(@PathVariable String apps) throws FileNotFoundException
	{
		 return assessmentReportService.summaryReport(apps);
	}
	
	@GetMapping("viewReport/{fromDate}/{toDate}")
	public List<ReportPDF> viewReport(@PathVariable Date fromDate,@PathVariable Date toDate)
	{
		return assessmentReportService.viewReport(fromDate,toDate);
	}
	
	@GetMapping("viewReportInBrowser/{appName}")
	public byte[] viewReportInBrowser(@PathVariable String appName) {
		return assessmentReportService.viewReportInBrowser(appName);
	}
	
	@GetMapping("zipExport/{fromDate}/{toDate}")
	public void zipExport(@PathVariable Date fromDate,@PathVariable Date toDate)
	{
			try {
				assessmentReportService.zipExport(fromDate,toDate);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		
	}

}
