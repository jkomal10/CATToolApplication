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

import com.cattool.assessment.Report.dao.AnswersDAO;
import com.cattool.assessment.Report.dao.ApplicationDAO;
import com.cattool.assessment.Report.dao.AssessmentQuestionsDAO;
import com.cattool.assessment.Report.dao.ReportPDFDAO;
import com.cattool.assessment.Report.dao.SummaryReportDAO;
import com.cattool.assessment.Report.dao.service.ReportDAOService;
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
	
	@Autowired
	ReportDAOService reportDAOService;

	int isFinalizeValue = 1;
	Boolean isDelete = false;

	public String[] summaryReport(String apps) throws FileNotFoundException {
		String arr[] = apps.split(",");

		byte[] reportArray = null;

		for (int i = 0; i < arr.length; i++) {
			int summaryReportCount = 1;
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			List<SummaryReportDAO> summaryReportList = new ArrayList<SummaryReportDAO>();
			List<AssessmentQuestionsDAO> assessmentQuestionsList = new ArrayList<AssessmentQuestionsDAO>();
			for (AssessmentQuestionsDAO assessmentQuestions : reportDAOService.getQuestions()) {
				if ("true".equals(assessmentQuestions.getAssessmentTypeForCloudable())) {
					assessmentQuestionsList.add(assessmentQuestions);
				}
			}
          
			for (ApplicationDAO application : reportDAOService.getApplications()) {
				List<AnswersDAO> answerList = new ArrayList<AnswersDAO>();
				if (application.getApplicationName().equals(arr[i])) {
					for (AssessmentQuestionsDAO assessmentQuestions : assessmentQuestionsList) {

						for (AnswersDAO answer : reportDAOService.getAnswers()) {
							if (answer.getApplicationId() == application.getApplicationId()) {
								if (answer.getQuestionId() == assessmentQuestions.getQuestionId()) {
									answerList.add(answer);
								}
							}
						}
					}

					List<String> answerTextList = new ArrayList<String>();
					for (AnswersDAO answer : answerList) {
						answerTextList.add(answer.getAnswerText());
					}
					for (AssessmentQuestionsDAO assessmentQuestions : assessmentQuestionsList) {

						SummaryReportDAO summaryReport = new SummaryReportDAO();
						summaryReport.setApplicationName(application.getApplicationName());
						summaryReport.setApplicationDescription(application.getApplicationDescription());
						for (AnswersDAO answer : answerList) {
							if (answer.getQuestionId() == assessmentQuestions.getQuestionId()) {
								summaryReport.setAnswerText(answer.getAnswerText());
								if (answer.getCloudAbility() == 1) {
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
						report = JasperCompileManager.compileReport(reportStream);
						ByteArrayOutputStream array = new ByteArrayOutputStream();
						JasperPrint jasperPrint = JasperFillManager.fillReport(report, parametres, jds);
						JasperExportManager.exportReportToPdfFile(jasperPrint, "/report/" + arr[i] + ".pdf");
						JasperExportManager.exportReportToPdfStream(jasperPrint, bos);
						reportArray = bos.toByteArray();
						ReportPDF reportPDF = new ReportPDF();
						
						reportDAOService.saveByteArrayOfPdf(reportArray,arr[i]);
						summaryReportCount++;
					} catch (JRException e) {
						e.printStackTrace();
					}
				}
				summaryReportList.clear();
			}
		}
		return arr;
	}

	public List<ReportPDFDAO> viewReport(Date fromDate, Date toDate) {
		List<ReportPDFDAO> viewAllReports = reportDAOService.viewReport(fromDate,toDate);
		return viewAllReports;
	}

	public byte[] viewReportInBrowser(String appName) {
		for (ReportPDFDAO reports : reportDAOService.viewReportInbrowser()) {
			if (reports.getApplicationName().equals(appName))
				return reports.getPdfFiles();
		}
		return null;
	}

	public void zipExport(Date fromDate, Date toDate) throws IOException {

		for (ReportPDFDAO viewAllReports : reportDAOService.zipReortApplications(fromDate, toDate)) {
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

	public List<ApplicationDAO> getAllFinalizeAplication(int clientId, Date fromDate, Date toDate) {

		List<ApplicationDAO> applicationDAOList = reportDAOService.getfinalizedApplication(clientId, fromDate,  toDate);
		return applicationDAOList;
	}

}
