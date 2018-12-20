package com.cattool.application.dao;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CloudableRuleDAO {
	
	private int cloudableRuleId;
	private int questionId;
	private String cloudableRule;
	private int executionOrder;
	private String questionText;
	private int clientId;
	private int questionDisplayOrder;
	
	
	public int getQuestionDisplayOrder() {
		return questionDisplayOrder;
	}
	public void setQuestionDisplayOrder(int questionDisplayOrder) {
		this.questionDisplayOrder = questionDisplayOrder;
	}
	public int getCloudableRuleId() {
		return cloudableRuleId;
	}
	public void setCloudableRuleId(int cloudableRuleId) {
		this.cloudableRuleId = cloudableRuleId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getCloudableRule() {
		return cloudableRule;
	}
	public void setCloudableRule(String cloudableRule) {
		this.cloudableRule = cloudableRule;
	}
	public int getExecutionOrder() {
		return executionOrder;
	}
	public void setExecutionOrder(int executionOrder) {
		this.executionOrder = executionOrder;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	@Override
	public String toString() {
		return "CloudableRule [cloudableRuleId=" + cloudableRuleId + ", questionId=" + questionId + ", cloudableRule="
				+ cloudableRule + ", executionOrder=" + executionOrder + ", questionText=" + questionText
				+ ", clientId=" + clientId + ", questionDisplayOrder=" + questionDisplayOrder + "]";
	}
	
	
}