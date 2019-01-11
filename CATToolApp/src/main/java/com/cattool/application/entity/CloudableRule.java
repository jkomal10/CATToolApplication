package com.cattool.application.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name="cloudable_rule_definition")
public class CloudableRule {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cloudableRuleDefinitionId;
	private int questionId;
	private String cloudableRule;
	private int executionOrder;
	private String questionText;
	private int clientId;
	private int questionDisplayOrder;
	@CreatedBy
	private String createdBy;
	@CreatedDate
	private Date cteatedOn;
	@LastModifiedBy
	private String modifiedBy;
	@LastModifiedDate
	private Date modifiedOn;
	
	public int getQuestionDisplayOrder() {
		return questionDisplayOrder;
	}
	public void setQuestionDisplayOrder(int questionDisplayOrder) {
		this.questionDisplayOrder = questionDisplayOrder;
	}
	public int getCloudableRuleId() {
		return cloudableRuleDefinitionId;
	}
	public void setCloudableRuleId(int cloudableRuleId) {
		this.cloudableRuleDefinitionId = cloudableRuleId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getCloudableRule() {
		return cloudableRule;
	}
	public void setCloudableRule(String cloudableRule) {
		this.cloudableRule = cloudableRule;
	}
	public int getExecutionOrder() {
		return executionOrder;
	}
	public void setExecutionOrder(int executionOrder) {
		this.executionOrder = executionOrder;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCteatedOn() {
		return cteatedOn;
	}
	public void setCteatedOn(Date cteatedOn) {
		this.cteatedOn = cteatedOn;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	@Override
	public String toString() {
		return "CloudableRule [cloudableRuleDefinitionId=" + cloudableRuleDefinitionId + ", questionId=" + questionId
				+ ", cloudableRule=" + cloudableRule + ", executionOrder=" + executionOrder + ", questionText="
				+ questionText + ", clientId=" + clientId + ", questionDisplayOrder=" + questionDisplayOrder
				+ ", createdBy=" + createdBy + ", cteatedOn=" + cteatedOn + ", modifiedBy=" + modifiedBy
				+ ", modifiedOn=" + modifiedOn + "]";
	}
	
}
