package com.cattool.assessment.Report.dao.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mockito.internal.stubbing.answers.AnswersWithDelay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cattool.assessment.Report.dao.AnswersDAO;
import com.cattool.assessment.Report.dao.ApplicationDAO;
import com.cattool.assessment.Report.dao.AssessmentQuestionsDAO;
import com.cattool.assessment.Report.dao.ReportPDFDAO;
import com.cattool.assessment.Report.entity.Answers;
import com.cattool.assessment.Report.entity.Application;
import com.cattool.assessment.Report.entity.AssessmentQuestions;
import com.cattool.assessment.Report.entity.ReportPDF;
import com.cattool.assessment.Report.repository.AnswersRepository;
import com.cattool.assessment.Report.repository.ApplicationRepository;
import com.cattool.assessment.Report.repository.AssessmentQuestionsRepository;
import com.cattool.assessment.Report.repository.ReportPDFRepository;

@Component
public class ReportDAOService {

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
	public List<AssessmentQuestionsDAO> getQuestions() {
		List<AssessmentQuestionsDAO> assessmentQuestionsDAOList = new ArrayList<AssessmentQuestionsDAO>();
		for (AssessmentQuestions assessmentQuestion : assessmentQuestionsRepository.findAll())
		{
			assessmentQuestionsDAOList.add(ToDAO(assessmentQuestion));
		}
			
		return assessmentQuestionsDAOList;
	}

	private AssessmentQuestionsDAO ToDAO(AssessmentQuestions assessmentQuestion) {

		AssessmentQuestionsDAO assessmentQuestionsDAO = new AssessmentQuestionsDAO();
		assessmentQuestionsDAO.setQuestionId(assessmentQuestion.getQuestionId());
		assessmentQuestionsDAO.setQuestionText(assessmentQuestion.getQuestionText());
		assessmentQuestionsDAO.setQuestionDescription(assessmentQuestion.getQuestionDescription());
		assessmentQuestionsDAO.setQuestionType(assessmentQuestion.getQuestionType());
		assessmentQuestionsDAO.setQuestionDisplayOrder(assessmentQuestion.getQuestionDisplayOrder());
		assessmentQuestionsDAO.setNumberOfOption(assessmentQuestion.getNumberOfOption());
		assessmentQuestionsDAO.setIsActive(assessmentQuestion.isActive());
		assessmentQuestionsDAO.setIsDelete(assessmentQuestion.isActive());
		assessmentQuestionsDAO.setAssessmentTypeForCloudable(assessmentQuestion.getAssessmentTypeForCloudable());
		assessmentQuestionsDAO.setAssessmentTypeForCloudProvider(assessmentQuestion.getAssessmentTypeForCloudProvider());
		assessmentQuestionsDAO.setAssessmentTypeForMigration(assessmentQuestion.getAssessmentTypeForMigration());
		assessmentQuestionsDAO.setCreatedBy(assessmentQuestion.getCreatedBy());
		assessmentQuestionsDAO.setCteatedTime(assessmentQuestion.getCteatedTime());
		assessmentQuestionsDAO.setModifiedBy(assessmentQuestion.getModifiedBy());
		assessmentQuestionsDAO.setModifiedTime(assessmentQuestion.getModifiedTime());
		assessmentQuestionsDAO.setClientId(assessmentQuestion.getClientId());
		return assessmentQuestionsDAO;
	}
	
	public List<ApplicationDAO> getApplications()
	{
		List<ApplicationDAO> applicationDAOList = new ArrayList<ApplicationDAO>();
		for(Application application: applicationRepository.findByIsFinalize(isFinalizeValue))
		{
			applicationDAOList.add(ToApplicationDAO(application));
		}
		
		return applicationDAOList;
	}

	private ApplicationDAO ToApplicationDAO(Application application) {

		ApplicationDAO applicationDAO = new ApplicationDAO();
		applicationDAO.setApplicationId(application.getApplicationId());
		applicationDAO.setApplicationName(application.getApplicationName());
		applicationDAO.setApplicationDescription(application.getApplicationDescription());
		applicationDAO.setIsCloudable(application.getIsCloudable());
		applicationDAO.setCloudProvider(application.getCloudProvider());
		applicationDAO.setMigrationPattern(application.getMigrationPattern());
		applicationDAO.setClientId(application.getClientId());
		applicationDAO.setCreatedBy(application.getCreatedBy());
		applicationDAO.setModifiedBy(application.getModifiedBy());
		applicationDAO.setUserId(application.getUserId());
		applicationDAO.setIsSaved(application.getIsSaved());
		applicationDAO.setAssessApplicationTime(application.getAssessApplicationTime());
		applicationDAO.setAssessment(application.isAssessment());
		applicationDAO.setCreatedDate(application.getCreatedDate());
		applicationDAO.setDeactivate(application.isDeactivate());
		applicationDAO.setDeleted(application.isDeleted());
		applicationDAO.setDeletedDateTime(application.getDeletedDateTime());
		applicationDAO.setIsFinalize(application.getIsFinalize());
		applicationDAO.setModifiedDateTime(application.getModifiedDateTime());
		applicationDAO.setVerified(application.isVerified());
		applicationDAO.setRecommendedCloudable(application.getRecommendedCloudable());
		applicationDAO.setRecommendedCloudProvider(application.getRecommendedCloudProvider());
		applicationDAO.setRecommendedMigrationPattern(application.getRecommendedMigrationPattern());
		return applicationDAO;
	}
	
	public List<AnswersDAO> getAnswers()
	{
		List<AnswersDAO> answersDAOList = new ArrayList<AnswersDAO>();
		for(Answers answers: answerRepository.findAll())
		{
			answersDAOList.add(ToAnswerDAO(answers));
		}
		return answersDAOList;
	}

	private AnswersDAO ToAnswerDAO(Answers answers) {
		AnswersDAO answersDAO = new AnswersDAO();
		answersDAO.setAnswerId(answers.getAnswerId());
		answersDAO.setAnswerText(answers.getAnswerText());
		answersDAO.setCloudAbility(answers.getCloudAbility());
		answersDAO.setOptionId(answers.getOptionId());
		answersDAO.setApplicationId(answers.getApplicationId());
		answersDAO.setQuestionId(answers.getQuestionId());
	return answersDAO;
	}

	public List<ApplicationDAO> getfinalizedApplication(int clientId, Date fromDate, Date toDate) {

		List<Application> appliactions = applicationRepository.findByClientIdAndIsDeletedAndIsFinalizeAndAssessApplicationTimeBetween(clientId,
				isDelete, isFinalizeValue, fromDate, toDate);
		
		List<ApplicationDAO> applicationDAOList = new ArrayList<>();
		for(Application application: appliactions)
		{
			applicationDAOList.add(ToApplicationDAO(application));
		}
		return applicationDAOList;
	}
	
	public List<ReportPDFDAO> zipReortApplications(Date fromDate, Date toDate)
	{
		List<ReportPDFDAO> reportPDFDAOList = new ArrayList<ReportPDFDAO>();
		for(ReportPDF reportPDFs : reportPDFRepository.findAllByGeneratedDateTimeBetween(fromDate, toDate))
		{
			reportPDFDAOList.add(ToReportDAO(reportPDFs));
		}
		return reportPDFDAOList;
	}

	private ReportPDFDAO ToReportDAO(ReportPDF reportPDFs) {

		ReportPDFDAO reportPDF = new ReportPDFDAO();
		reportPDF.setApplicationName(reportPDFs.getApplicationName());
		reportPDF.setGeneratedDateTime(reportPDFs.getGeneratedDateTime());
		reportPDF.setPdfFiles(reportPDFs.getPdfFiles());
		reportPDF.setReportPDFId(reportPDFs.getReportPDFId());
		
		return reportPDF;
	}
	
	public List<ReportPDFDAO> viewReportInbrowser()
	{
		List<ReportPDFDAO> reportPDFDaoList = new ArrayList<ReportPDFDAO>();
		for(ReportPDF reportPDF : reportPDFRepository.findAll())
		{
			reportPDFDaoList.add(ToReportDAO(reportPDF));
		}
		return reportPDFDaoList;
	}
	
	public List<ReportPDFDAO> viewReport(Date fromDate, Date toDate){
		
		List<ReportPDFDAO> reportPDFDAO = new ArrayList<ReportPDFDAO>();
		for(ReportPDF reportPdf : reportPDFRepository.findAllByGeneratedDateTimeBetween(fromDate, toDate))
		{
			reportPDFDAO.add(ToReportDAO(reportPdf));
		}
		return reportPDFDAO;
	}
	

	public void saveByteArrayOfPdf(byte[] reportArray, String ApplicationName) {
		ReportPDF reportPdf = reportPDFRepository.findByApplicationName(ApplicationName);
		ReportPDF reportPDF= new ReportPDF();
		if(reportPDFRepository.findByApplicationName(ApplicationName)==null)
		{
		reportPDF.setPdfFiles(reportArray);
		reportPDF.setApplicationName(ApplicationName);
		reportPDFRepository.save(reportPDF);
		}
		else if(reportPDFRepository.findByApplicationName(ApplicationName)!=null)
		{
			reportPDF.setReportPDFId(reportPdf.getReportPDFId());
			reportPDF.setApplicationName(ApplicationName);
			reportPDF.setGeneratedDateTime(reportPdf.getGeneratedDateTime());
			reportPDFRepository.delete(reportPdf);
			reportPDF.setPdfFiles(reportArray);
			reportPDFRepository.save(reportPDF);
		}
	}

	

}
