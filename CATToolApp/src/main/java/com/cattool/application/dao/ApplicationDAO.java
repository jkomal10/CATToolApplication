package com.cattool.application.dao;

import java.io.Serializable;
import java.util.Date;

public class ApplicationDAO implements Serializable {

	private int applicationId;

	private String applicationName;

	private String applicationDescription;

	private String isCloudable;

	private String MigrationPattern;

	private String cloudProvider;

	private int userId;

	private String createdBy;

	private String modifiedBy;

	private int clientId;

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getApplicationDescription() {
		return applicationDescription;
	}

	public void setApplicationDescription(String applicationDescription) {
		this.applicationDescription = applicationDescription;
	}

	public String getIsCloudable() {
		return isCloudable;
	}

	public void setIsCloudable(String isCloudable) {
		this.isCloudable = isCloudable;
	}

	public String getMigrationPattern() {
		return MigrationPattern;
	}

	public void setMigrationPattern(String migrationPattern) {
		MigrationPattern = migrationPattern;
	}

	public String getCloudProvider() {
		return cloudProvider;
	}

	public void setCloudProvider(String cloudProvider) {
		this.cloudProvider = cloudProvider;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	@Override
	public String toString() {
		return "ApplicationDAO [applicationId=" + applicationId + ", applicationName=" + applicationName
				+ ", applicationDescription=" + applicationDescription + ", isCloudable=" + isCloudable
				+ ", MigrationPattern=" + MigrationPattern + ", cloudProvider=" + cloudProvider + ", userId=" + userId
				+ ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + ", clientId=" + clientId + "]";
	}

	
}
