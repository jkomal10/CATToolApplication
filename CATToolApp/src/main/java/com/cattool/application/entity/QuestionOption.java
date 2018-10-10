package com.cattool.application.entity;

import java.util.Arrays;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
//@Table(name="optionTable")
public class QuestionOption {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int optionId;
		
	@Column
	private String questionText;
	
//	@Column
//	private String optionText;
	
	@Column
	private String[] optionText;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="questionId", referencedColumnName="questionId")
	private AssessmentQuestions assessmentQuestions;

	public int getOptionId() {
		return optionId;
	}

	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String[] getOptionText() {
		return optionText;
	}

	public void setOptionText(String[] optionText) {
		this.optionText = optionText;
	}

	public AssessmentQuestions getAssessmentQuestions() {
		return assessmentQuestions;
	}

	public void setAssessmentQuestions(AssessmentQuestions assessmentQuestions) {
		this.assessmentQuestions = assessmentQuestions;
	}
	
	

	public QuestionOption() {
		super();
	}

	public QuestionOption(int optionId, String questionText, String[] optionText,
			AssessmentQuestions assessmentQuestions) {
		super();
		this.optionId = optionId;
		this.questionText = questionText;
		this.optionText = optionText;
		this.assessmentQuestions = assessmentQuestions;
	}

	@Override
	public String toString() {
		return "QuestionOption [optionId=" + optionId + ", questionText=" + questionText + ", optionText="
				+ Arrays.toString(optionText) + ", assessmentQuestions=" + assessmentQuestions + "]";
	}	
	
}
