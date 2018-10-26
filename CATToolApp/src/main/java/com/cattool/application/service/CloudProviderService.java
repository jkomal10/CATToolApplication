package com.cattool.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cattool.application.entity.CloudProvider;
import com.cattool.application.repository.CloudProviderRepository;

@Service
@Transactional
public class CloudProviderService {
	
	@Autowired
	CloudProviderRepository cloudProviderRepository;
	
	public List<CloudProvider> getAllcloudProvider(){
		return cloudProviderRepository.findAll();
		
	}

	public void setEvaluationOrder(List<CloudProvider> cloudProvider) {
		
		cloudProviderRepository.saveAll(cloudProvider);
	}

	
}
