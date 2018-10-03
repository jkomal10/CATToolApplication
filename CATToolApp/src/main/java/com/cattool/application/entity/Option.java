package com.cattool.application.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Option {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int optionId;
	
	@Column
	private int questionId;
	
	@Column
	private String questionText;
	
	@Column
	private String optionText;

	public int getOptionId() {
		return optionId;
	}

	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}

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

	public String getOptionText() {
		return optionText;
	}

	public void setOptionText(String optionText) {
		this.optionText = optionText;
	}
	
	public Option() {
		super();
	}

	@Override
	public String toString() {
		return "Option [optionId=" + optionId + ", questionId=" + questionId + ", questionText=" + questionText
				+ ", optionText=" + optionText + "]";
	}
	
	
}
