package com.cattool.application.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ReportIssue {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int issueId;
	private String issue;
	public int getIssueId() {
		return issueId;
	}
	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	
	@Override
	public String toString() {
		return "ReportIssue [issueId=" + issueId + ", issue=" + issue + "]";
	}
	
	
	
}
