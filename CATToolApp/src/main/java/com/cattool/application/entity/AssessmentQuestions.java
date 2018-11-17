package com.cattool.application.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="assessmentQuestions")
public class AssessmentQuestions {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	private String clientName;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="questionId", referencedColumnName="questionId")
    private List<MigrationRule> migrationRule;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="questionId", referencedColumnName="questionId")
    private List<QuestionOption> questionOption;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="questionId", referencedColumnName="questionId")
    private List<CloudProviderRule> cloudProviderRules;

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

	public int isActive() {
		return isActive;
	}

	public void setActive(int isActive) {
		this.isActive = isActive;
	}

	public int isDelete() {
		return isDelete;
	}

	public void setDelete(int isDelete) {
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

	public List<MigrationRule> getMigrationRule() {
		return migrationRule;
	}

	public void setMigrationRule(List<MigrationRule> migrationRule) {
		this.migrationRule = migrationRule;
	}

	public List<QuestionOption> getQuestionOption() {
		return questionOption;
	}

	public void setQuestionOption(List<QuestionOption> questionOption) {
		this.questionOption = questionOption;
	}
	
	public List<CloudProviderRule> getCloudProviderRules() {
		return cloudProviderRules;
	}

	public void setCloudProviderRules(List<CloudProviderRule> cloudProviderRules) {
		this.cloudProviderRules = cloudProviderRules;
	}

	public AssessmentQuestions() {
		super();
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

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
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
				+ ", clientName=" + clientName + ", migrationRule=" + migrationRule + ", questionOption="
				+ questionOption + ", cloudProviderRules=" + cloudProviderRules + "]";
	}
	
}
