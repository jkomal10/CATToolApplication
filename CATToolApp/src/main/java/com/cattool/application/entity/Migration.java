package com.cattool.application.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Migration {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int migrationId;
	private String migrationPattern;
	private int evaluationOrder;
	private String clientName;
	
	public int getMigrationId() {
		return migrationId;
	}
	public void setMigrationId(int migrationId) {
		this.migrationId = migrationId;
	}
	public String getMigrationPattern() {
		return migrationPattern;
	}
	public void setMigrationPattern(String migrationPattern) {
		this.migrationPattern = migrationPattern;
	}
	public int getEvaluationOrder() {
		return evaluationOrder;
	}
	public void setEvaluationOrder(int evaluationOrder) {
		this.evaluationOrder = evaluationOrder;
	}
	
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public Migration() {
		super();
	}
	public Migration(int migrationId, String migrationPattern, int evaluationOrder) {
		super();
		this.migrationId = migrationId;
		this.migrationPattern = migrationPattern;
		this.evaluationOrder = evaluationOrder;
	}
	@Override
	public String toString() {
		return "Migration [migrationId=" + migrationId + ", migrationPattern=" + migrationPattern + ", evaluationOrder="
				+ evaluationOrder + ", clientName=" + clientName + "]";
	}
	
	
}
