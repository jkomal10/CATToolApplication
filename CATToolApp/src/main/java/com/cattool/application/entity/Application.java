package com.cattool.application.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="applications")
public class Application {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int applicationId;
	
	@Column
	private String applicationName;
	
	@Column
	private String applicationDescription;
	
	@Column
	private String isCloudable;
	
	@Column
	private String MigrationPattern;
	
	@Column
	private String cloudProvider;
	
	@Column
	private boolean isAssessment;
	
	@Column
	private int isFinalize;
	
	@Column
	private boolean isDeleted;
	
	@Column
	private boolean isDeactivate;
	
	@Column
	private Date deletedDateTime;
	
	@Column
	private boolean isVerified;
	
	@Column
	@CreatedDate
	private Date createdDate;
	
	@Column 
	@LastModifiedDate
	private Date modifiedDateTime;
	
	@Column
	@CreatedBy
	private String createdBy;
	
	@Column
	@LastModifiedBy
	private String modifiedBy;
	
	@Column
	private int userId;
	
	@Column
	private int isSaved;
	
	@Column
	private int clientId;
	
	@Column
	private Date assessApplicationTime;
	
	@Column
	private String recommendedCloudable;
	
	@Column
	private String recommendedCloudProvider;
	
	@Column
	private String recommendedMigrationPattern;
	
	
	public int getApplicationId() {
		return applicationId;
	}

	public int getIsFinalize() {
		return isFinalize;
	}

	public void setIsFinalize(int isFinalize) {
		this.isFinalize = isFinalize;
	}

	public int getIsSaved() {
		return isSaved;
	}

	public void setIsSaved(int isSaved) {
		this.isSaved = isSaved;
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

	public String isCloudable() {
		return isCloudable;
	}

	public void setCloudable(String isCloudable) {
		this.isCloudable = isCloudable;
	}

	public boolean isAssessment() {
		return isAssessment;
	}

	public void setAssessment(boolean isAssessment) {
		this.isAssessment = isAssessment;
	}

	public int isFinalize() {
		return isFinalize;
	}

	public void setFinalize(int isFinalize) {
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
	
	public Application() {
		super();
	}

	public String getIsCloudable() {
		return isCloudable;
	}

	public void setIsCloudable(String isCloudable) {
		this.isCloudable = isCloudable;
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
		return "Application [applicationId=" + applicationId + ", applicationName=" + applicationName
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
