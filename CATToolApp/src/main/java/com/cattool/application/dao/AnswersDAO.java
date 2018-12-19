package com.cattool.application.dao;

import javax.persistence.Column;

public class AnswersDAO {
	
	private int answerId;
	private int applicationId;
	private int questionId;
	private String answerText;
//	private int cloudAbility;
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
//	public int getCloudAbility() {
//		return cloudAbility;
//	}
//	public void setCloudAbility(int cloudAbility) {
//		this.cloudAbility = cloudAbility;
//	}
	@Override
	public String toString() {
		return "AnswersDAO [answerId=" + answerId + ", applicationId=" + applicationId + ", questionId=" + questionId
				+ ", answerText=" + answerText + "]";
	}
	

}
