package com.cattool.application.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Application {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int applicationId;
	
	@Column
	private String applicationName;
	
	@Column
	private String applicationDescription;
	
	@Column
	private boolean isCloudable;
	
	@Column
	private boolean isMigration;
	
	@Column
	private boolean cloudProvider;
	
	@Column
	private boolean isAssessment;
	
	@Column
	private boolean isFinalize;
	
	@Column
	private boolean isDeleted;
	
	@Column
	private Date deletedDateTime;
	
	@Column
	private boolean isVerified;
	
	@Column
	private Date createdDate;
	
	@Column 
	private Date modifiedDateTime;
	
	@Column
	private String createdBy;
	
	@Column
	private String modifiedBy;
	
	@Column
	private int userId;

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

	public boolean isCloudable() {
		return isCloudable;
	}

	public void setCloudable(boolean isCloudable) {
		this.isCloudable = isCloudable;
	}

	public boolean isMigration() {
		return isMigration;
	}

	public void setMigration(boolean isMigration) {
		this.isMigration = isMigration;
	}

	public boolean isCloudProvider() {
		return cloudProvider;
	}

	public void setCloudProvider(boolean cloudProvider) {
		this.cloudProvider = cloudProvider;
	}

	public boolean isAssessment() {
		return isAssessment;
	}

	public void setAssessment(boolean isAssessment) {
		this.isAssessment = isAssessment;
	}

	public boolean isFinalize() {
		return isFinalize;
	}

	public void setFinalize(boolean isFinalize) {
		this.isFinalize = isFinalize;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
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

	
	public Application() {
		super();
	}
	
	

	public Application(int applicationId, String applicationName, String applicationDescription, boolean isCloudable,
			boolean isMigration, boolean cloudProvider, boolean isAssessment, boolean isFinalize, boolean isDeleted,
			Date deletedDateTime, boolean isVerified, Date createdDate, Date modifiedDateTime, String createdBy,
			String modifiedBy, int userId) {
		super();
		this.applicationId = applicationId;
		this.applicationName = applicationName;
		this.applicationDescription = applicationDescription;
		this.isCloudable = isCloudable;
		this.isMigration = isMigration;
		this.cloudProvider = cloudProvider;
		this.isAssessment = isAssessment;
		this.isFinalize = isFinalize;
		this.isDeleted = isDeleted;
		this.deletedDateTime = deletedDateTime;
		this.isVerified = isVerified;
		this.createdDate = createdDate;
		this.modifiedDateTime = modifiedDateTime;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Application [applicationId=" + applicationId + ", applicationName=" + applicationName
				+ ", applicationDescription=" + applicationDescription + ", isCloudable=" + isCloudable
				+ ", isMigration=" + isMigration + ", cloudProvider=" + cloudProvider + ", isAssessment=" + isAssessment
				+ ", isFinalize=" + isFinalize + ", isDeleted=" + isDeleted + ", deletedDateTime=" + deletedDateTime
				+ ", isVerified=" + isVerified + ", createdDate=" + createdDate + ", modifiedDateTime="
				+ modifiedDateTime + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + ", userId=" + userId
				+ "]";
	}

	

}
