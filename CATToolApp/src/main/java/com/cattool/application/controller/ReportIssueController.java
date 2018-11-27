package com.cattool.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cattool.application.entity.ReportIssue;
import com.cattool.application.entity.Users;
import com.cattool.application.service.ReportIssueService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/reportIssue")
public class ReportIssueController {

	@Autowired
	ReportIssueService reportIssueService;
	
	@PostMapping("/issue")
	public ReportIssue saveIssue(@RequestBody ReportIssue reportIssue)
	{
		System.out.print(reportIssue);
		return reportIssueService.saveIssue(reportIssue);
		
	}

}
