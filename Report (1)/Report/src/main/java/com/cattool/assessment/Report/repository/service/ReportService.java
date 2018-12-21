package com.cattool.assessment.Report.repository.service;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cattool.assessment.Report.entity.Answers;
import com.cattool.assessment.Report.entity.Application;
import com.cattool.assessment.Report.entity.AssessmentQuestions;
import com.cattool.assessment.Report.entity.ReportPDF;
import com.cattool.assessment.Report.entity.SummaryReport;
import com.cattool.assessment.Report.repository.AnswersRepository;
import com.cattool.assessment.Report.repository.ApplicationRepository;
import com.cattool.assessment.Report.repository.AssessmentQuestionsRepository;
import com.cattool.assessment.Report.repository.ReportPDFRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
@Transactional
public class ReportService {

	@Autowired
	ApplicationRepository applicationRepository;

	@Autowired
	AssessmentQuestionsRepository assessmentQuestionsRepository;

	@Autowired
	AnswersRepository answerRepository;

	@Autowired
	ReportPDFRepository reportPDFRepository;

	int isFinalizeValue = 1;
	Boolean isDelete = false;

	public String[] summaryReport(String apps) throws FileNotFoundException {
		String arr[] = apps.split(",");

		byte[] reportArray = null;
		byte[] reports = null;

		for (int i = 0; i < arr.length; i++) {
			int summaryReportCount = 1;
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			List<SummaryReport> summaryReportList = new ArrayList<SummaryReport>();
			List<Application> appList = new ArrayList<Application>();
			List<AssessmentQuestions> assessmentQuestionsList = new ArrayList<AssessmentQuestions>();
			for (AssessmentQuestions assessmentQuestions : assessmentQuestionsRepository.findAll()) {
				if ("true".equals(assessmentQuestions.getAssessmentTypeForCloudable())) {
					assessmentQuestionsList.add(assessmentQuestions);
				}
			}
          
			System.out.println("****************************");
			System.out.println(applicationRepository.findAll()); 
			
			for (Application application : applicationRepository.findAll()) {
				List<Answers> answerList = new ArrayList<Answers>();
				// if(application.getIsFinalize()==1)
				// {
				// appList.add(application);
				if (application.getApplicationName().equals(arr[i])) {
					for (AssessmentQuestions assessmentQuestions : assessmentQuestionsList) {

						for (Answers answer : answerRepository.findAll()) {
							if (answer.getApplicationId() == application.getApplicationId()) {
								if (answer.getQuestionId() == assessmentQuestions.getQuestionId()) {
									answerList.add(answer);
								}
							}
						}
					}

					List<String> answerTextList = new ArrayList<String>();
					for (Answers answer : answerList) {
						answerTextList.add(answer.getAnswerText());
					}
					for (AssessmentQuestions assessmentQuestions : assessmentQuestionsList) {

						SummaryReport summaryReport = new SummaryReport();
						summaryReport.setApplicationName(application.getApplicationName());
						summaryReport.setApplicationDescription(application.getApplicationDescription());
						for (Answers answer : answerList) {
							if (answer.getQuestionId() == assessmentQuestions.getQuestionId()) {
								summaryReport.setAnswerText(answer.getAnswerText());
								if (answer.isCloudAbility() == 1) {
									summaryReport.setCloudability("1");
								} else {
									summaryReport.setCloudability("0");
								}

							}

						}
						summaryReport.setQuestionText(assessmentQuestions.getQuestionText());
						summaryReport.setAssessment_type("Yes");
						summaryReportList.add(summaryReport);
					}

					JRBeanCollectionDataSource jds = new JRBeanCollectionDataSource(summaryReportList);
					Map<String, Object> parametres = new HashMap<String, Object>();
					parametres.put("ItemDataSource", jds);
					InputStream reportStream = new FileInputStream(
							"\\Users\\suvsahoo\\Volkswagen\\jasperTemplate\\template.jrxml");
					JasperReport report;
					try {
						ReportPDF pdf = new ReportPDF();

						report = JasperCompileManager.compileReport(reportStream);
						ByteArrayOutputStream array = new ByteArrayOutputStream();
						JasperPrint jasperPrint = JasperFillManager.fillReport(report, parametres, jds);
						JasperExportManager.exportReportToPdfFile(jasperPrint, "/report/" + arr[i] + ".pdf");
						JasperExportManager.exportReportToPdfStream(jasperPrint, bos);
						reportArray = bos.toByteArray();
						ReportPDF reportPDF = new ReportPDF();
						if (reportPDFRepository.findByApplicationName(arr[i]) == null) {
							reportPDF.setPdfFiles(reportArray);
							reportPDF.setApplicationName(arr[i]);
							reportPDFRepository.save(reportPDF);
						}
						summaryReportCount++;
					} catch (JRException e) {
						e.printStackTrace();
					}
				}
				summaryReportList.clear();
			}

		}
		for (int c = 0; c < arr.length; c++) {
			System.out.println(arr[c]);
		}
		return arr;
	}

	public List<ReportPDF> viewReport(Date fromDate, Date toDate) {

		List<ReportPDF> viewAllReports = reportPDFRepository.findAllByGeneratedDateTimeBetween(fromDate, toDate);

		return viewAllReports;
	}

	public byte[] viewReportInBrowser(String appName) {
		for (ReportPDF reports : reportPDFRepository.findAll()) {
			if (reports.getApplicationName().equals(appName))
				return reports.getPdfFiles();
		}
		return null;
	}

	public void zipExport(Date fromDate, Date toDate) throws IOException {

		for (ReportPDF viewAllReports : reportPDFRepository.findAllByGeneratedDateTimeBetween(fromDate, toDate)) {
			FileOutputStream fos = new FileOutputStream("/report/" + viewAllReports.getApplicationName() + ".zip");
			ZipOutputStream zipOS = new ZipOutputStream(fos);

			ZipEntry zipEntry = new ZipEntry(viewAllReports.getApplicationName() + ".pdf");
			zipEntry.setSize(viewAllReports.getPdfFiles().length);
			zipOS.putNextEntry(zipEntry);
			zipOS.write(viewAllReports.getPdfFiles());
			zipOS.closeEntry();
			zipOS.close();
		}

	}

	public List<Application> getAllFinalizeAplication(int clientId, Date fromDate, Date toDate) {

		return applicationRepository.findByClientIdAndIsDeletedAndIsFinalizeAndAssessApplicationTimeBetween(clientId,
				isDelete, isFinalizeValue, fromDate, toDate);
	}

}
