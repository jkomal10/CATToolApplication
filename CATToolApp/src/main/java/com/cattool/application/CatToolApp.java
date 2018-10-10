package com.cattool.application;


import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cattool.application.entity.AssessmentQuestions;
import com.cattool.application.entity.QuestionOption;
import com.cattool.application.service.OptionService;

@SpringBootApplication
public class CatToolApp {

	public static void main(String[] args) {
		SpringApplication.run(CatToolApp.class, args);
		System.out.println("***************************");
		FileSystem fileSystem = FileSystems.getDefault();
		Path path = fileSystem.getPath("C:\\Users\\priyanj\\Desktop\\priyanjali_sonarqube\\file.txt"); // Noncompliant
		System.out.println(path);
		path.toAbsolutePath();
		 Path p1 = Paths.get("C:\\Users\\priyanj\\Desktop\\priyanjali_sonarqube\\file.txt");
		 System.out.println(path.toAbsolutePath());
		 
	}
}
