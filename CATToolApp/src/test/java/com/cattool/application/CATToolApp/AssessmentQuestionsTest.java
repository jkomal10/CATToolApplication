package com.cattool.application.CATToolApp;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.cattool.application.entity.AssessmentQuestions;
import com.cattool.application.repository.AssessmentQuestionsRepository;
import com.cattool.application.service.AssessmentQuestionsService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AssessmentQuestionsTest {
	
	@Autowired
	AssessmentQuestionsRepository assessmentQuestionsRepository;
	
	@Autowired
	AssessmentQuestionsService assessmentQuestionsService;
	
	int questionId=101;
	
	AssessmentQuestions questions=new AssessmentQuestions(1,"text","description","questionType",1,3,true,true,"true","false","false");
	List<AssessmentQuestions> list;
	
	@Test
	public void getAllquestions()
	{
		list=new ArrayList<AssessmentQuestions>();
		list=assessmentQuestionsRepository.findAll();
		System.out.println("Assessment Questions list "+list);
		assertNotNull(list);
	}
	
	@Test
	public void deleteQuestions()
	{
		AssessmentQuestions queId=assessmentQuestionsRepository.getByQuestionId(101);
		System.out.println("*************************"+queId+"********************************");
		System.out.println("##############################"+queId.getQuestionId()+"######################");
		//assessmentQuestionsRepository.deleteByQuestionId(102);
		assertNotNull(queId.getQuestionId());
	}
	
 	@Test
	public void updateQuestions()
	{
 		AssessmentQuestions que=assessmentQuestionsRepository.getByQuestionId(questions.getQuestionId());
 		//assessmentQuestionsService.updateQuestions(que);
	}
	
	/*@Test
	public void saveQuestions()
	{
		assessmentQuestionsRepository.save(questions);
		System.out.println("Data Saved with "+questions);
		assertNotNull(questions);
	}*/

}
