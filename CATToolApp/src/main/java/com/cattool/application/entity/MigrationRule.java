package com.cattool.application.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MigrationRule {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int migrationRuleId;
	private int questionId;
	private int migrationId;
	private String migrationRule;
	private int executionOrder;
	private String questionText;
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
	
	public MigrationRule() {
		super();
	}
	public MigrationRule(int migrationRuleId, int questionId, int migrationId, String migrationRule, int executionOrder,
			String questionText) {
		super();
		this.migrationRuleId = migrationRuleId;
		this.questionId = questionId;
		this.migrationId = migrationId;
		this.migrationRule = migrationRule;
		this.executionOrder = executionOrder;
		this.questionText = questionText;
	}
	@Override
	public String toString() {
		return "MigrationRule [migrationRuleId=" + migrationRuleId + ", questionId=" + questionId + ", migrationId="
				+ migrationId + ", migrationRule=" + migrationRule + ", executionOrder=" + executionOrder
				+ ", questionText=" + questionText + "]";
	}
	
	

}
