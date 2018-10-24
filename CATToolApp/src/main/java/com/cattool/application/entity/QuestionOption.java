package com.cattool.application.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class QuestionOption {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int optionId;
	
   @Column()
   private String questionId;
	
	@Column
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
	
	public QuestionOption() {
		super();
	}

	public QuestionOption(int optionId, String questionId, String optionText) {

		super();
		this.optionId = optionId;
		this.questionId = questionId;
		this.optionText = optionText;
	}
	@Override
	public String toString() {

		return "QuestionOption [optionId=" + optionId + ", questionId=" + questionId + ", optionText=" + optionText
				+ "]";
	}
	
	
	
	
	
}
