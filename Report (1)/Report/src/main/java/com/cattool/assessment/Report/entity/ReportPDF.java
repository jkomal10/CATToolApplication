package com.cattool.assessment.Report.entity;

import java.io.FileOutputStream;
import java.sql.Blob;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import net.sf.jasperreports.engine.JasperPrint;


@Entity
public class ReportPDF {
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int reportPDFId;
	@Column
	private Blob pdfFiles;
	
	public int getReportPDFId() {
		return reportPDFId;
	}


	public void setReportPDFId(int reportPDFId) {
		this.reportPDFId = reportPDFId;
	}

	public Blob getPdfFiles() {
		return pdfFiles;
	}



	public void setPdfFiles(Blob pdfFiles) {
		this.pdfFiles = pdfFiles;
	}



	@Override
	public String toString() {
		return "ReportPDF [reportPDFId=" + reportPDFId + ", pdfFiles=" + pdfFiles + "]";
	}
 
	
	
}
