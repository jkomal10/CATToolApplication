package com.cattool.application.dao;

public class MigrationRuleDAO {
	
	private int migrationRuleId;
	private String questionId;
	private int migrationId;
	private String migrationRule;
	private int executionOrder;
	private String questionText;
	private int clientId;
	
	public int getMigrationRuleId() {
		return migrationRuleId;
	}
	public void setMigrationRuleId(int migrationRuleId) {
		this.migrationRuleId = migrationRuleId;
	}
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public int getMigrationId() {
		return migrationId;
	}
	public void setMigrationId(int migrationId) {
		this.migrationId = migrationId;
	}
	public String getMigrationRule() {
		return migrationRule;
	}
	public void setMigrationRule(String migrationRule) {
		this.migrationRule = migrationRule;
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
		return "MigrationRule [migrationRuleId=" + migrationRuleId + ", questionId=" + questionId + ", migrationId="
				+ migrationId + ", migrationRule=" + migrationRule + ", executionOrder=" + executionOrder
				+ ", questionText=" + questionText + ", clientId=" + clientId + "]";
	}
	
}
