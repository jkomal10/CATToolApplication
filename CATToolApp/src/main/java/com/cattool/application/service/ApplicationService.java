package com.cattool.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cattool.application.entity.Application;
import com.cattool.application.repository.ApplicationRepository;

@Service
@Transactional
public class ApplicationService {

	@Autowired
	ApplicationRepository applicationRepository;
	
	public List<Application> getAllApplication()
	{
		return applicationRepository.findAll();
	}
	
	public Application saveApplication(Application application)
	{
		return applicationRepository.save(application);
	}
	
	public Application findbyApplicationName(String applicationName)
	{
		return applicationRepository.findByApplicationName(applicationName);
	}

	public void deleteApplicationById(int id) {
		
		applicationRepository.deleteByApplicationId(id);
	}

	public Application GetSingleApplication(int applicationId) {
		return applicationRepository.findByApplicationId(applicationId);
	}
}
