package com.cattool.assessment.Report.dao;

import java.util.Arrays;
import java.util.Date;

public class ReportPDFDAO {

	private int reportPDFId;
	private byte[] pdfFiles;
	private Date generatedDateTime;
	private String applicationName;
	public int getReportPDFId() {
		return reportPDFId;
	}
	public void setReportPDFId(int reportPDFId) {
		this.reportPDFId = reportPDFId;
	}
	public byte[] getPdfFiles() {
		return pdfFiles;
	}
	public void setPdfFiles(byte[] pdfFiles) {
		this.pdfFiles = pdfFiles;
	}
	public Date getGeneratedDateTime() {
		return generatedDateTime;
	}
	public void setGeneratedDateTime(Date generatedDateTime) {
		this.generatedDateTime = generatedDateTime;
	}
	public String getApplicationName() {
		return applicationName;
	}
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	@Override
	public String toString() {
		return "AuditingEntityListenerDAO [reportPDFId=" + reportPDFId + ", pdfFiles=" + Arrays.toString(pdfFiles)
				+ ", generatedDateTime=" + generatedDateTime + ", applicationName=" + applicationName + "]";
	}
	
	
}
