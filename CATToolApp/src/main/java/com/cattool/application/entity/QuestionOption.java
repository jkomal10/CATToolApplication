package com.cattool.application.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
//@Table(name="optionTable")
public class QuestionOption {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int optionId;
		
	@Column
	private String questionText;
	
	@Column
	private String optionText;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="questionId", referencedColumnName="questionId")
	private AssessmentQuestions assessmentQuestions;
	

	public AssessmentQuestions getAssessmentQuestions() {
		return assessmentQuestions;
	}

	public void setAssessmentQuestions(AssessmentQuestions assessmentQuestions) {
		this.assessmentQuestions = assessmentQuestions;
	}

	public int getOptionId() {
		return optionId;
	}

	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}

	/*public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}*/

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
	
	public QuestionOption() {
		super();
	}
	
//	public QuestionOption(int optionId, String questionText, String optionText,
//			AssessmentQuestions assessmentQuestions) {
//		super();
//		this.optionId = optionId;
//		this.questionText = questionText;
//		this.optionText = optionText;
//		this.assessmentQuestions = assessmentQuestions;
//	}

	public QuestionOption(int optionId2, String questionText2, String optionText2, AssessmentQuestions abc) {

		this.optionId = optionId2;
		this.questionText = questionText2;
		this.optionText = optionText2;
		this.assessmentQuestions = abc;
	}

	@Override
	public String toString() {
		return "Option [optionId=" + optionId + ", questionText=" + questionText + ", optionText=" + optionText
				+ ", assessmentQuestions=" + assessmentQuestions + "]";
	}

	
	/*@Override
	public String toString() {
		return "Option [optionId=" + optionId + ", questionId=" + questionId + ", questionText=" + questionText
				+ ", optionText=" + optionText + "]";
	}*/
	
	
}
