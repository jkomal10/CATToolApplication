package com.cattool.application.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CloudProviderRule {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int cloudProviderRuleId;
	private String questionId;
	private int cloudProviderId;
	private String cloudProviderRule;
	private int executionOrder;
	private String questionText;
	private String clientName;
	
	public int getCloudProviderRuleId() {
		return cloudProviderRuleId;
	}
	public void setCloudProviderRuleId(int cloudProviderRuleId) {
		this.cloudProviderRuleId = cloudProviderRuleId;
	}
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public int getCloudProviderId() {
		return cloudProviderId;
	}
	public void setCloudProviderId(int cloudProviderId) {
		this.cloudProviderId = cloudProviderId;
	}
	public String getCloudProviderRule() {
		return cloudProviderRule;
	}
	public void setCloudProviderRule(String cloudProviderRule) {
		this.cloudProviderRule = cloudProviderRule;
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
	
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public CloudProviderRule() {
		super();
	}
	@Override
	public String toString() {
		return "CloudProviderRule [cloudProviderRuleId=" + cloudProviderRuleId + ", questionId=" + questionId
				+ ", cloudProviderId=" + cloudProviderId + ", cloudProviderRule=" + cloudProviderRule
				+ ", executionOrder=" + executionOrder + ", questionText=" + questionText + ", clientName=" + clientName
				+ "]";
	}
	
	
	
}
