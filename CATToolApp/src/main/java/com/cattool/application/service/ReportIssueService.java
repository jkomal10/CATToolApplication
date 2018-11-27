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
	
	public ReportIssue saveIssue(ReportIssue reportIssue) {
		return reportIssueRepository.save(reportIssue);
	}
	
	

}
