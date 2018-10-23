package com.cattool.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CatToolApp {

	public static void main(String[] args) {
		SpringApplication.run(CatToolApp.class, args);
	}
}
