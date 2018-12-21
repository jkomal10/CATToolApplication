package com.cattool.assessment.Report.dao;

import java.util.Date;

import javax.persistence.Column;

public class SummaryReportDAO {

private int summaryReportId;
	
	private String applicationName;
	
	private String applicationDescription;
	
	private String cloudability;
	
	private String assessment_type;
	
	private String questionText;
	
	private String answerText;
	
	private Date assesstTime;

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

	public Date getAssesstTime() {
		return assesstTime;
	}

	public void setAssesstTime(Date assesstTime) {
		this.assesstTime = assesstTime;
	}

	@Override
	public String toString() {
		return "SummaryReportDAO [summaryReportId=" + summaryReportId + ", applicationName=" + applicationName
				+ ", applicationDescription=" + applicationDescription + ", cloudability=" + cloudability
				+ ", assessment_type=" + assessment_type + ", questionText=" + questionText + ", answerText="
				+ answerText + ", assesstTime=" + assesstTime + "]";
	}
	
	
	
}
