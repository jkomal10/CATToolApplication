package com.cattool.application.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Migration {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int migrationId;
	private String migrationPattern;
	private int evaluationOrder;
	
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
	
	public Migration() {
		super();
	}
	@Override
	public String toString() {
		return "Migration [migrationId=" + migrationId + ", migrationPattern=" + migrationPattern + ", evaluationOrder="
				+ evaluationOrder + "]";
	}
	
	
	
	
}
