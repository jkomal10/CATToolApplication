package com.cattool.application.dao;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CloudableRuleDAO {
	
	private int cloudableRuleId;
	public int getCloudableRuleId() {
		return cloudableRuleId;
	}
	public void setCloudableRuleId(int cloudableRuleId) {
		this.cloudableRuleId = cloudableRuleId;
	}
	private int questionId;
	private String cloudableRule;
	private int clientId;
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
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	@Override
	public String toString() {
		return "CloudableRuleDAO [cloudableRuleId=" + cloudableRuleId + ", questionId=" + questionId
				+ ", cloudableRule=" + cloudableRule + ", clientId=" + clientId + "]";
	}
	
	
	

}
