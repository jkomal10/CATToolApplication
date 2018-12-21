package com.cattool.application.dao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

public class ApplicationDAO implements Serializable {

	private int applicationId;
	
	private String applicationName;
	
	private String applicationDescription;
	
	private String isCloudable;
	
	private String MigrationPattern;
	
	private String cloudProvider;
	
	private boolean isAssessment;
	
	private int isFinalize;
	
	private boolean isDeleted;
	
	private boolean isDeactivate;
	
	private Date deletedDateTime;
	
	private boolean isVerified;
	
	private Date createdDate;
	
	private Date modifiedDateTime;
	
	private String createdBy;
	
	private String modifiedBy;
	
	private int userId;
	
	private int isSaved;
	
	private int clientId;
	
	private Date assessApplicationTime;
	
	private String recommendedCloudable;
	
	private String recommendedCloudProvider;
	
	private String recommendedMigrationPattern;

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

	public boolean isAssessment() {
		return isAssessment;
	}

	public void setAssessment(boolean isAssessment) {
		this.isAssessment = isAssessment;
	}

	public int getIsFinalize() {
		return isFinalize;
	}

	public void setIsFinalize(int isFinalize) {
		this.isFinalize = isFinalize;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public boolean isDeactivate() {
		return isDeactivate;
	}

	public void setDeactivate(boolean isDeactivate) {
		this.isDeactivate = isDeactivate;
	}

	public Date getDeletedDateTime() {
		return deletedDateTime;
	}

	public void setDeletedDateTime(Date deletedDateTime) {
		this.deletedDateTime = deletedDateTime;
	}

	public boolean isVerified() {
		return isVerified;
	}

	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDateTime() {
		return modifiedDateTime;
	}

	public void setModifiedDateTime(Date modifiedDateTime) {
		this.modifiedDateTime = modifiedDateTime;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getIsSaved() {
		return isSaved;
	}

	public void setIsSaved(int isSaved) {
		this.isSaved = isSaved;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public Date getAssessApplicationTime() {
		return assessApplicationTime;
	}

	public void setAssessApplicationTime(Date assessApplicationTime) {
		this.assessApplicationTime = assessApplicationTime;
	}

	public String getRecommendedCloudable() {
		return recommendedCloudable;
	}

	public void setRecommendedCloudable(String recommendedCloudable) {
		this.recommendedCloudable = recommendedCloudable;
	}

	public String getRecommendedCloudProvider() {
		return recommendedCloudProvider;
	}

	public void setRecommendedCloudProvider(String recommendedCloudProvider) {
		this.recommendedCloudProvider = recommendedCloudProvider;
	}

	public String getRecommendedMigrationPattern() {
		return recommendedMigrationPattern;
	}

	public void setRecommendedMigrationPattern(String recommendedMigrationPattern) {
		this.recommendedMigrationPattern = recommendedMigrationPattern;
	}

	@Override
	public String toString() {
		return "ApplicationDAO [applicationId=" + applicationId + ", applicationName=" + applicationName
				+ ", applicationDescription=" + applicationDescription + ", isCloudable=" + isCloudable
				+ ", MigrationPattern=" + MigrationPattern + ", cloudProvider=" + cloudProvider + ", isAssessment="
				+ isAssessment + ", isFinalize=" + isFinalize + ", isDeleted=" + isDeleted + ", isDeactivate="
				+ isDeactivate + ", deletedDateTime=" + deletedDateTime + ", isVerified=" + isVerified
				+ ", createdDate=" + createdDate + ", modifiedDateTime=" + modifiedDateTime + ", createdBy=" + createdBy
				+ ", modifiedBy=" + modifiedBy + ", userId=" + userId + ", isSaved=" + isSaved + ", clientId="
				+ clientId + ", assessApplicationTime=" + assessApplicationTime + ", recommendedCloudable="
				+ recommendedCloudable + ", recommendedCloudProvider=" + recommendedCloudProvider
				+ ", recommendedMigrationPattern=" + recommendedMigrationPattern + "]";
	}
	
	
	

	
}
