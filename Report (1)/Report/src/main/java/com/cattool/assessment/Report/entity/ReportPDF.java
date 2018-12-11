package com.cattool.assessment.Report.entity;
import java.util.Arrays;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;



@Entity
@EntityListeners(AuditingEntityListener.class)
public class ReportPDF {
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int reportPDFId;
	@Column
	private byte[] pdfFiles;
	
	@CreatedDate
	private Date generatedDateTime;
	@Column
	private String applicationName;
	
	
	
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


	public int getReportPDFId() {
		return reportPDFId;
	}


	public void setReportPDFId(int reportPDFId) {
		this.reportPDFId = reportPDFId;
	}

	public byte[] getPdfFiles() {
		return pdfFiles;
	}



	public void setPdfFiles(byte[] reportArray) {
		this.pdfFiles = reportArray;
	}


	@Override
	public String toString() {
		return "ReportPDF [reportPDFId=" + reportPDFId + ", pdfFiles=" + Arrays.toString(pdfFiles)
				+ ", generatedDateTime=" + generatedDateTime + ", applicationName=" + applicationName + "]";
	}



	
 
	
	
}
