package com.cattool.application.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class OptionDAO implements Serializable{

	private int optionId;
	private String questionId;
	private String optionText;

	
	public int getOptionId() {
		return optionId;
	}
	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}
	public String getOptionText() {
		return optionText;
	}
	public void setOptionText(String optionText) {

		this.optionText = optionText;
	}
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	
	@Override
	public String toString() {
		return "QuestionOption [optionId=" + optionId + ", questionId=" + questionId + ", optionText=" + optionText
				+ "]";
	}
}
