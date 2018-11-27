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
	private String userName;
	private int clientId;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	@Override
	public String toString() {
		return "ReportIssue [issueId=" + issueId + ", issue=" + issue + ", userName=" + userName + ", clientId="
				+ clientId + "]";
	}
	
	
}
