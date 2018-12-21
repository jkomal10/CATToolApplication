package com.cattool.assessment.Report.dao.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cattool.assessment.Report.dao.AssessmentQuestionsDAO;
import com.cattool.assessment.Report.entity.AssessmentQuestions;
import com.cattool.assessment.Report.repository.AnswersRepository;
import com.cattool.assessment.Report.repository.ApplicationRepository;
import com.cattool.assessment.Report.repository.AssessmentQuestionsRepository;
import com.cattool.assessment.Report.repository.ReportPDFRepository;

public class ReportServiceDAOService {

	@Autowired
	ApplicationRepository applicationRepository;

	@Autowired
	AssessmentQuestionsRepository assessmentQuestionsRepository;

	@Autowired
	AnswersRepository answerRepository;

	@Autowired
	ReportPDFRepository reportPDFRepository;

	public List<AssessmentQuestionsDAO> getQuestions() {
		List<AssessmentQuestionsDAO> assessmentQuestionsDAO = new ArrayList<AssessmentQuestionsDAO>();
		for (AssessmentQuestions assessmentQuestion : assessmentQuestionsRepository.findAll())
		{
			assessmentQuestionsDAO.add(ToDAO(assessmentQuestion));
		}
			
		return null;
	}

	private AssessmentQuestionsDAO ToDAO(AssessmentQuestions assessmentQuestion) {

		return null;
	}

}
