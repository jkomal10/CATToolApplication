package com.cattool.application.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import com.cattool.application.entity.CloudProviderRule;
import com.cattool.application.entity.MigrationRule;
import com.cattool.application.entity.QuestionOption;

public class AssessmentQuestionsDAO implements Serializable{

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
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="questionId", referencedColumnName="questionId")
    private List<MigrationRuleDAO> migrationRule;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="questionId", referencedColumnName="questionId")
    private List<OptionDAO> questionOption;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="questionId", referencedColumnName="questionId")
    private List<CloudProviderRuleDAO> cloudProviderRules;
	
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
	public List<MigrationRuleDAO> getMigrationRule() {
		return migrationRule;
	}
	public void setMigrationRule(List<MigrationRuleDAO> migrationRule) {
		this.migrationRule = migrationRule;
	}
	public List<OptionDAO> getQuestionOption() {
		return questionOption;
	}
	public void setQuestionOption(List<OptionDAO> questionOption) {
		this.questionOption = questionOption;
	}
	public List<CloudProviderRuleDAO> getCloudProviderRules() {
		return cloudProviderRules;
	}
	public void setCloudProviderRules(List<CloudProviderRuleDAO> cloudProviderRules) {
		this.cloudProviderRules = cloudProviderRules;
	}
	public AssessmentQuestionsDAO() {
		this.questionOption = new ArrayList<OptionDAO>();
		
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
				+ ", clientId=" + clientId + ", migrationRule=" + migrationRule + ", questionOption=" + questionOption
				+ ", cloudProviderRules=" + cloudProviderRules + "]";
	}
	
}
