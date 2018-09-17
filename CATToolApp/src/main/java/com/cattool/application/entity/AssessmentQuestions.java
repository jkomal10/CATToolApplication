package com.cattool.application.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AssessmentQuestions {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int questionId;
	private String questionText;
	private String questionDescription;
	private String questionType;
	private int questionDisplayOrder;
	private int numberOfOption;
	private boolean isActive;
	private boolean isDelete;
	private String assessmentTypeForMigration;
	private String assessmentTypeForCloudProvider;
	private String assessmentTypeForCloudable;
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
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public boolean isDelete() {
		return isDelete;
	}
	public void setDelete(boolean isDelete) {
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
	
	public AssessmentQuestions() {
		super();
	}
	public AssessmentQuestions(int questionId, String questionText, String questionDescription, String questionType,
			int questionDisplayOrder, int numberOfOption, boolean isActive, boolean isDelete,
			String assessmentTypeForMigration, String assessmentTypeForCloudProvider,
			String assessmentTypeForCloudable) {
		super();
		this.questionId = questionId;
		this.questionText = questionText;
		this.questionDescription = questionDescription;
		this.questionType = questionType;
		this.questionDisplayOrder = questionDisplayOrder;
		this.numberOfOption = numberOfOption;
		this.isActive = isActive;
		this.isDelete = isDelete;
		this.assessmentTypeForMigration = assessmentTypeForMigration;
		this.assessmentTypeForCloudProvider = assessmentTypeForCloudProvider;
		this.assessmentTypeForCloudable = assessmentTypeForCloudable;
	}
	@Override
	public String toString() {
		return "AssessmentQuestions [questionId=" + questionId + ", questionText=" + questionText
				+ ", questionDescription=" + questionDescription + ", questionType=" + questionType
				+ ", questionDisplayOrder=" + questionDisplayOrder + ", numberOfOption=" + numberOfOption
				+ ", isActive=" + isActive + ", isDelete=" + isDelete + ", assessmentTypeForMigration="
				+ assessmentTypeForMigration + ", assessmentTypeForCloudProvider=" + assessmentTypeForCloudProvider
				+ ", assessmentTypeForCloudable=" + assessmentTypeForCloudable + "]";
	}
	
	
	
	

}
