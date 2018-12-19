package com.cattool.application.dao;

public class CloudProviderRuleDAO {

	private int clientId;
	private int cloudProviderRuleId;
	private int questionId;
	private String cloudProviderRule;
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public int getCloudProviderRuleId() {
		return cloudProviderRuleId;
	}
	public void setCloudProviderRuleId(int cloudProviderRuleId) {
		this.cloudProviderRuleId = cloudProviderRuleId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getCloudProviderRule() {
		return cloudProviderRule;
	}
	public void setCloudProviderRule(String cloudProviderRule) {
		this.cloudProviderRule = cloudProviderRule;
	}
	@Override
	public String toString() {
		return "CloudProviderRuleDAOService [clientId=" + clientId + ", cloudProviderRuleId=" + cloudProviderRuleId
				+ ", questionId=" + questionId + ", cloudProviderRule=" + cloudProviderRule + "]";
	}
	
	
	
}
