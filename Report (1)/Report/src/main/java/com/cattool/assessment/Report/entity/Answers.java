package com.cattool.assessment.Report.entity;

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
	@Override
	public String toString() {
		return "Answers [answerId=" + answerId + ", applicationId=" + applicationId + ", questionId=" + questionId
				+ ", answerText=" + answerText + ", cloudAbility=" + cloudAbility + "]";
	}
	
}
