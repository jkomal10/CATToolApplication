package com.cattool.application.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class AssessmentQuestions {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@SequenceGenerator(name="book_generator", sequenceName = "book_seq", allocationSize=50)
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
	private String createdBy;
	private Date cteatedTime;
	private String modifiedBy;
	private Date modifiedTime;
	
//	@OneToMany
//	@JoinColumn(name="questionId", referencedColumnName="questionId")
//	private List<Option> option;
//	
//	public List<Option> getOption() {
//		return option;
//	}
//	public void setOption(List<Option> option) {
//		this.option = option;
//	}
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
	
	public AssessmentQuestions() {
		super();
	}
	public AssessmentQuestions(int questionId, String questionText, String questionDescription, String questionType,
			int questionDisplayOrder, int numberOfOption, boolean isActive, boolean isDelete,
			String assessmentTypeForMigration, String assessmentTypeForCloudProvider, String assessmentTypeForCloudable,
			String createdBy, Date cteatedTime, String modifiedBy, Date modifiedTime) {
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
		this.createdBy = createdBy;
		this.cteatedTime = cteatedTime;
		this.modifiedBy = modifiedBy;
		this.modifiedTime = modifiedTime;
	}
	@Override
	public String toString() {
		return "AssessmentQuestions [questionId=" + questionId + ", questionText=" + questionText
				+ ", questionDescription=" + questionDescription + ", questionType=" + questionType
				+ ", questionDisplayOrder=" + questionDisplayOrder + ", numberOfOption=" + numberOfOption
				+ ", isActive=" + isActive + ", isDelete=" + isDelete + ", assessmentTypeForMigration="
				+ assessmentTypeForMigration + ", assessmentTypeForCloudProvider=" + assessmentTypeForCloudProvider
				+ ", assessmentTypeForCloudable=" + assessmentTypeForCloudable + ", createdBy=" + createdBy
				+ ", cteatedTime=" + cteatedTime + ", modifiedBy=" + modifiedBy + ", modifiedTime=" + modifiedTime
				+ "]";
	}
	
	
	
}
