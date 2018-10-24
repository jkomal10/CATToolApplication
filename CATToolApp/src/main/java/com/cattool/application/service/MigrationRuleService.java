package com.cattool.application.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cattool.application.entity.Migration;
import com.cattool.application.entity.MigrationRule;
import com.cattool.application.repository.MigrationRuleRepository;

@Service
@Transactional
public class MigrationRuleService {
	
	@Autowired
	MigrationRuleRepository migrationRuleRepository;
	
	@Autowired
	MigrationRepository migrationRepository;
	
	public List<MigrationRule> getAllmigrationRule()
	{
		return migrationRuleRepository.findAll();
	}
	
	public List<Migration> getAllMigrationPatterns(){
		return migrationRepository.findAll();
	}
	
}
