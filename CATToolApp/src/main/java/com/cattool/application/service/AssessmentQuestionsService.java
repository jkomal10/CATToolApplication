package com.cattool.application.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cattool.application.entity.AssessmentQuestions;
import com.cattool.application.repository.AssessmentQuestionsRepository;
@Transactional
@Service
public class AssessmentQuestionsService {
	
	@Autowired
	AssessmentQuestionsRepository assessmentQuestionsRepository;
	
	public List<AssessmentQuestions> getAllquestions()
	{
		return assessmentQuestionsRepository.findAll();
	}
	
	public AssessmentQuestions saveQuestions(AssessmentQuestions assessmentQuestions)
	{
		System.out.println(assessmentQuestions);
		//this.assessmentQuestionsRepository.saveAndFlush(assessmentQuestions);
		return assessmentQuestionsRepository.save(assessmentQuestions);
	}
	
	public void deleteQuestions(int questionId)
	{
		assessmentQuestionsRepository.deleteByQuestionId(questionId);
	}
	
	public void updateQuestions(AssessmentQuestions assessmentQuestions)
	{
		AssessmentQuestions assessmentQuestion=new AssessmentQuestions();
		assessmentQuestion=assessmentQuestionsRepository.getByQuestionId(assessmentQuestions.getQuestionId());
		assessmentQuestion.setQuestionId(assessmentQuestions.getQuestionId());
		assessmentQuestion.setQuestionText(assessmentQuestions.getQuestionText());
		assessmentQuestion.setQuestionDescription(assessmentQuestions.getQuestionDescription());
		assessmentQuestion.setQuestionType(assessmentQuestions.getQuestionType());
		assessmentQuestion.setQuestionDisplayOrder(assessmentQuestions.getQuestionDisplayOrder());
		assessmentQuestion.setNumberOfOption(assessmentQuestions.getNumberOfOption());
		assessmentQuestion.setActive(assessmentQuestions.isActive());
		assessmentQuestion.setDelete(assessmentQuestions.isDelete());
		assessmentQuestion.setAssessmentTypeForMigration(assessmentQuestions.getAssessmentTypeForMigration());
		assessmentQuestion.setAssessmentTypeForCloudProvider(assessmentQuestions.getAssessmentTypeForCloudProvider());
		assessmentQuestion.setAssessmentTypeForCloudable(assessmentQuestions.getAssessmentTypeForCloudProvider());
		assessmentQuestionsRepository.save(assessmentQuestion);
	}
	

}
