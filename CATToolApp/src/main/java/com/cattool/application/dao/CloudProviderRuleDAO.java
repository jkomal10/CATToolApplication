package com.cattool.application.dao;

public class CloudProviderRuleDAO {

	private int cloudProviderRuleId;
	private String questionId;
	private int cloudProviderId;
	private String cloudProviderRule;
	private int executionOrder;
	private String questionText;
	private int clientId;
	
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
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	@Override
	public String toString() {
		return "CloudProviderRule [cloudProviderRuleId=" + cloudProviderRuleId + ", questionId=" + questionId
				+ ", cloudProviderId=" + cloudProviderId + ", cloudProviderRule=" + cloudProviderRule
				+ ", executionOrder=" + executionOrder + ", questionText=" + questionText + ", clientId=" + clientId
				+ "]";
	}
	
	
	
}
