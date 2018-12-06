package com.cattool.assessment.Report.repository.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.buf.ByteChunk.ByteOutputChannel;
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
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;


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
	
public void summaryReport() throws FileNotFoundException{
		
		int summaryReportCount=1;
		List<SummaryReport> summaryReportList=new ArrayList<SummaryReport>();
		List<Application> appList=new ArrayList<Application>();
		List<AssessmentQuestions> assessmentQuestionsList=new ArrayList<AssessmentQuestions>();
		for(AssessmentQuestions assessmentQuestions:assessmentQuestionsRepository.findAll())
		{
			if("true".equals(assessmentQuestions.getAssessmentTypeForCloudable()))
			{
				assessmentQuestionsList.add(assessmentQuestions);
			}
		}
		
		for(Application application:applicationRepository.findAll()) {
			List<Answers> answerList=new ArrayList<Answers>();
			if(application.getIsFinalize()==1)
			{
				appList.add(application);
				for(AssessmentQuestions assessmentQuestions:assessmentQuestionsList) 
				{
						
						for(Answers answer:answerRepository.findAll())
						{
							if(answer.getApplicationId()==application.getApplicationId())
							{
								if(answer.getQuestionId()==assessmentQuestions.getQuestionId())
									{
										answerList.add(answer);
									}
							}
						}
				}
				
				List<String> answerTextList=new ArrayList<String>();
				for(Answers answer:answerList)
				{
					answerTextList.add(answer.getAnswerText());
				}
				for(AssessmentQuestions assessmentQuestions:assessmentQuestionsList)
				{
					
					SummaryReport summaryReport=new SummaryReport();
					summaryReport.setApplicationName(application.getApplicationName());
					summaryReport.setApplicationDescription(application.getApplicationDescription());
					for(Answers answer:answerList)
					{
						if(answer.getQuestionId()==assessmentQuestions.getQuestionId())
						{
							summaryReport.setAnswerText(answer.getAnswerText());
							if(answer.isCloudAbility()==1)
							{
								summaryReport.setCloudability("1");
							}
							else
							{
								summaryReport.setCloudability("0");
							}
							
						}
						
					}
					summaryReport.setQuestionText(assessmentQuestions.getQuestionText());
					summaryReport.setAssessment_type("Yes");
					summaryReportList.add(summaryReport);
				}
				
				JRBeanCollectionDataSource jds=new JRBeanCollectionDataSource(summaryReportList);
				Map<String,Object> parametres=new HashMap<String,Object>();
				parametres.put("ItemDataSource", jds);
				InputStream reportStream = new FileInputStream("\\Users\\priyanj\\Volkswagen\\jasperTemplate\\template.jrxml");
				JasperReport report;
				try {
					ReportPDF pdf=new ReportPDF();
					
					report = JasperCompileManager.compileReport(reportStream);
					ByteArrayOutputStream array=new ByteArrayOutputStream();
					 JasperPrint jasperPrint = JasperFillManager.fillReport(report,parametres, jds);
					 JasperExportManager.exportReportToPdfFile(jasperPrint, "/hsjd/CloudRreport"+summaryReportCount+".pdf"); 
					 
//					 ByteArrayOutputStream out = new ByteArrayOutputStream();
//					 JRXlsExporter exporterXLS = new JRXlsExporter();
//					 exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
//					 exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, out);
//					 exporterXLS.exportReport();
//					 
//					 ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
//					 Blob b1=(Blob) in;					 
//					 ByteArrayDataSource bads = new ByteArrayDataSource(in,mimeType);
			 summaryReportCount++;
				} catch (JRException e) {
					e.printStackTrace();
				}
		}
			summaryReportList.clear();
		}	
	}

}
