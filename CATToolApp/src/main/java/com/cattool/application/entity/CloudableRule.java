package com.cattool.application.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cloudable_Rule_table")
public class CloudableRule {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cloudableRuleId;
	private int questionId;
	private String cloudableRule;
	private int executionOrder;
	private String questionText;
	private int clientId;
	
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
				+ ", clientId=" + clientId + "]";
	}
	
}
