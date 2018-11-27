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
	private int clientId;
	
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
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public Migration() {
		super();
	}
	@Override
	public String toString() {
		return "Migration [migrationId=" + migrationId + ", migrationPattern=" + migrationPattern + ", evaluationOrder="
				+ evaluationOrder + ", clientId=" + clientId + "]";
	}

	
}
