package com.cattool.application.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cattool.application.entity.Application;
import com.cattool.application.repository.ApplicationRepository;

@Service
@Transactional
public class Newclass {
	
	@Autowired
	ApplicationRepository applicationRepository;
	
	public void newMethod()
	{
		int applicationId = 51;
		Application application=new Application();
		application = applicationRepository.findByApplicationId(applicationId);
		System.out.println(applicationId);
		System.out.println(application);
	}

}
