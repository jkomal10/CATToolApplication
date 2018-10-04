package com.cattool.application.CATToolApp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.cattool.application.repository.AssessmentQuestionsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CatToolAppApplicationTests {
	@Autowired
	AssessmentQuestionsRepository assessmentQuestionsRepository;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void deleteQuestions()
	{
		assessmentQuestionsRepository.deleteByQuestionId(1);
	}

}
