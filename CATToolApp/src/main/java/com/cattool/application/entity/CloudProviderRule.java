package com.cattool.application.entity;

import java.util.Date;

import javax.persistence.Column;
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
@Table(name="cloud_provider_rule_Definition")
public class CloudProviderRule {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="cloud_provider_rule_Definition_id")
	private int cloudProviderRuleId;
	private String questionId;
	private int cloudProviderId;
	private String cloudProviderRule;
	private int executionOrder;
	@Column(name="question_text_english")
	private String questionText;
	private int clientId;
	@CreatedBy
	private String createdBy;
	@CreatedDate
	private Date cteatedOn;
	@LastModifiedBy
	private String modifiedBy;
	@LastModifiedDate
	private Date modifiedOn;
	
	public int getCloudProviderRuleId() {
		return cloudProviderRuleId;
	}
	public void setCloudProviderRuleId(int cloudProviderRuleId) {
		this.cloudProviderRuleId = cloudProviderRuleId;
	}
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public int getCloudProviderId() {
		return cloudProviderId;
	}
	public void setCloudProviderId(int cloudProviderId) {
		this.cloudProviderId = cloudProviderId;
	}
	public String getCloudProviderRule() {
		return cloudProviderRule;
	}
	public void setCloudProviderRule(String cloudProviderRule) {
		this.cloudProviderRule = cloudProviderRule;
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
		return "CloudProviderRule [cloudProviderRuleId=" + cloudProviderRuleId + ", questionId=" + questionId
				+ ", cloudProviderId=" + cloudProviderId + ", cloudProviderRule=" + cloudProviderRule
				+ ", executionOrder=" + executionOrder + ", questionText=" + questionText + ", clientId=" + clientId
				+ ", createdBy=" + createdBy + ", cteatedOn=" + cteatedOn + ", modifiedBy=" + modifiedBy
				+ ", modifiedOn=" + modifiedOn + "]";
	}
}
