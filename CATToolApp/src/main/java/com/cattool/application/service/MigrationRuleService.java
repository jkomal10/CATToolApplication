package com.cattool.application.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

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
	
	public void updateMigrationRule(List<MigrationRule> migrationRulelist)
	{
		MigrationRule migrationRuleObject=new MigrationRule();
		for(MigrationRule migrationRule:migrationRulelist) {
			migrationRuleObject=migrationRule;
			migrationRuleObject.setMigrationId(migrationRule.getMigrationId());
			migrationRuleRepository.save(migrationRuleObject);
		}
	}
	
}
