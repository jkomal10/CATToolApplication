package com.cattool.application.dao;

public class MigrationRuleDAO {
	
	private int migrationRuleId;
	private int questionId;
	private int migrationId;
	private String migrationRule;
	private int clientId;
	public int getMigrationRuleId() {
		return migrationRuleId;
	}
	public void setMigrationRuleId(int migrationRuleId) {
		this.migrationRuleId = migrationRuleId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
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
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	@Override
	public String toString() {
		return "MigrationRuleDAO [migrationRuleId=" + migrationRuleId + ", questionId=" + questionId + ", migrationId="
				+ migrationId + ", migrationRule=" + migrationRule + ", clientId=" + clientId + "]";
	}

	
}
