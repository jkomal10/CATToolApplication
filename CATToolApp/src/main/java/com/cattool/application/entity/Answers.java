package com.cattool.application.entity;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Answers {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int answerId;
	@Column
	private int applicationId;
	@Column
	private int questionId;
	@Column
	private String answerText;
	@Column
	private int cloudAbility;
	@Column
	private String createdBy;
	@Column
	private Date cteatedTime;
	@Column
	private String modifiedBy;
	@Column
	private Date modifiedTime;
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public int getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getAnswerText() {
		return answerText;
	}
	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}
	public int isCloudAbility() {
		return cloudAbility;
	}
	public void setCloudAbility(int cloudAbility) {
		this.cloudAbility = cloudAbility;
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
	@Override
	public String toString() {
		return "Answers [answerId=" + answerId + ", applicationId=" + applicationId + ", questionId=" + questionId
				+ ", answerText=" + answerText + ", cloudAbility=" + cloudAbility + ", createdBy=" + createdBy
				+ ", cteatedTime=" + cteatedTime + ", modifiedBy=" + modifiedBy + ", modifiedTime=" + modifiedTime
				+ "]";
	}	

}
