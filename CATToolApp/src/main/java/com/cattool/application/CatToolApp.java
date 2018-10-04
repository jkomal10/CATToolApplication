package com.cattool.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cattool.application.entity.AssessmentQuestions;
import com.cattool.application.entity.QuestionOption;
import com.cattool.application.service.OptionService;

@SpringBootApplication
public class CatToolApp {

	public static void main(String[] args) {
		SpringApplication.run(CatToolApp.class, args);
		/*OptionService service=new OptionService();
		System.out.println("mainnnnnnnnnnnnnnnnn");
		AssessmentQuestions abc=new AssessmentQuestions(1,"text","description","questionType",1,3,true,true,"true","false","false",null,null,null,null);
		System.out.println("service questionnnnnnnnnnnnnnnnnnnnnnnn");
		QuestionOption que=new QuestionOption(1,"s","s",abc);
		System.out.println("optionnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
		System.out.println(que);
		service.saveQuestionOption(que);
		System.out.println("endddddddddddddddddddddddddddddddddd");*/
	}
}
