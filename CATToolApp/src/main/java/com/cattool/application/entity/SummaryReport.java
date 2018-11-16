package com.cattool.application.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SummaryReport {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int summaryReportId;
	
	@Column
	private String applicationName;
	
	@Column
	private String applicationDescription;
	
	@Column 
	private String cloudability;
	
	@Column
	private String assessment_type;
	
	@Column
	private String questionText;
	
	@Column
	private String answerText;

	public int getSummaryReportId() {
		return summaryReportId;
	}

	public void setSummaryReportId(int summaryReportId) {
		this.summaryReportId = summaryReportId;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getApplicationDescription() {
		return applicationDescription;
	}

	public void setApplicationDescription(String applicationDescription) {
		this.applicationDescription = applicationDescription;
	}

	public String getCloudability() {
		return cloudability;
	}

	public void setCloudability(String cloudability) {
		this.cloudability = cloudability;
	}

	public String getAssessment_type() {
		return assessment_type;
	}

	public void setAssessment_type(String assessment_type) {
		this.assessment_type = assessment_type;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}

	@Override
	public String toString() {
		return "SummaryReport [summaryReportId=" + summaryReportId + ", applicationName=" + applicationName
				+ ", applicationDescription=" + applicationDescription + ", cloudability=" + cloudability
				+ ", assessment_type=" + assessment_type + ", questionText=" + questionText + ", answerText="
				+ answerText + "]";
	}
	
}
