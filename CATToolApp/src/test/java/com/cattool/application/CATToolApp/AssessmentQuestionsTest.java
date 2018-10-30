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
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class AssessmentQuestionsTest {
	


//	@Autowired
//	AssessmentQuestionsRepository assessmentQuestionsRepository;
//	
//	@Autowired
//	AssessmentQuestionsService assessmentQuestionsService;
//	
//	int questionId;
//	
//
//	AssessmentQuestions questions=new AssessmentQuestions(12,"text","description","questionType",1,3,true,true,"true","false","false",null,null,null,null);
//
//	List<AssessmentQuestions> list;
//	
//	@Test
//	public void getAllquestions()
//	{
//		list=new ArrayList<AssessmentQuestions>();
//		list=assessmentQuestionsRepository.findAll();
//		System.out.println("Assessment Questions list "+list);
//		assertNotNull(list);
//	}
//	
//	@Transactional
//	@Test
//	public void deleteQuestions()
//	{
//		assessmentQuestionsRepository.deleteByQuestionId(1);
//		//assertNotNull(queId.getQuestionId());
//	}
//	
// 	@Test
//	public void updateQuestions()
//	{
// 		//AssessmentQuestions que=assessmentQuestionsRepository.getByQuestionId(questions.getQuestionId());
// 		//assessmentQuestionsService.updateQuestions(que);
//
// 		assessmentQuestionsRepository.saveAndFlush(questions);
//
//	}
//	
//	@Test
//	public void saveQuestions()
//	{
//		assessmentQuestionsRepository.save(questions);
//		System.out.println("Data Saved with "+questions);
//		assertNotNull(questions);
//	}


}
