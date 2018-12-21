package com.cattool.application.dao;

public class ReportIssueDAO {
	
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
		return "ReportIssueDAO [issueId=" + issueId + ", issue=" + issue + ", userName=" + userName + ", clientId="
				+ clientId + "]";
	}
	
	

}
