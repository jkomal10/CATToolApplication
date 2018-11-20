package com.cattool.application.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cattool.application.entity.ReportIssue;
import com.cattool.application.repository.ReportIssueRepository;

@Service
@Transactional
public class ReportIssueService {

	@Autowired
	ReportIssueRepository reportIssueRepository;
//	public ReportIssue saveIssue(String issue) {
//		
//		return reportIssueRepository.save(issue);
//	}
	public ReportIssue saveIssue(ReportIssue reportIssue) {
		// TODO Auto-generated method stub
		return reportIssueRepository.save(reportIssue);
	}
	
	

}
