package com.cattool.assessment.Report.dao;

import java.util.Date;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

public class AssessmentQuestionsDAO {

	private int questionId;
	private String questionText;
	private String questionDescription;
	private String questionType;
	private int questionDisplayOrder;
	private int numberOfOption;
	private int isActive;
	private int isDelete;
	private String assessmentTypeForMigration;
	private String assessmentTypeForCloudProvider;
	private String assessmentTypeForCloudable;
	private String createdBy;
	private Date cteatedTime;
	private String modifiedBy;
	private Date modifiedTime;
	private int clientId;
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public String getQuestionDescription() {
		return questionDescription;
	}
	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	public int getQuestionDisplayOrder() {
		return questionDisplayOrder;
	}
	public void setQuestionDisplayOrder(int questionDisplayOrder) {
		this.questionDisplayOrder = questionDisplayOrder;
	}
	public int getNumberOfOption() {
		return numberOfOption;
	}
	public void setNumberOfOption(int numberOfOption) {
		this.numberOfOption = numberOfOption;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	public String getAssessmentTypeForMigration() {
		return assessmentTypeForMigration;
	}
	public void setAssessmentTypeForMigration(String assessmentTypeForMigration) {
		this.assessmentTypeForMigration = assessmentTypeForMigration;
	}
	public String getAssessmentTypeForCloudProvider() {
		return assessmentTypeForCloudProvider;
	}
	public void setAssessmentTypeForCloudProvider(String assessmentTypeForCloudProvider) {
		this.assessmentTypeForCloudProvider = assessmentTypeForCloudProvider;
	}
	public String getAssessmentTypeForCloudable() {
		return assessmentTypeForCloudable;
	}
	public void setAssessmentTypeForCloudable(String assessmentTypeForCloudable) {
		this.assessmentTypeForCloudable = assessmentTypeForCloudable;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCteatedTime() {
		return cteatedTime;
	}
	public void setCteatedTime(Date cteatedTime) {
		this.cteatedTime = cteatedTime;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	@Override
	public String toString() {
		return "AssessmentQuestionsDAO [questionId=" + questionId + ", questionText=" + questionText
				+ ", questionDescription=" + questionDescription + ", questionType=" + questionType
				+ ", questionDisplayOrder=" + questionDisplayOrder + ", numberOfOption=" + numberOfOption
				+ ", isActive=" + isActive + ", isDelete=" + isDelete + ", assessmentTypeForMigration="
				+ assessmentTypeForMigration + ", assessmentTypeForCloudProvider=" + assessmentTypeForCloudProvider
				+ ", assessmentTypeForCloudable=" + assessmentTypeForCloudable + ", createdBy=" + createdBy
				+ ", cteatedTime=" + cteatedTime + ", modifiedBy=" + modifiedBy + ", modifiedTime=" + modifiedTime
				+ ", clientId=" + clientId + "]";
	}
	
	
	
}
