package com.cattool.application.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cattool.application.entity.Migration;
import com.cattool.application.entity.MigrationRule;
import com.cattool.application.repository.MigrationRepository;
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
	
	public List<Migration> getAllMigrationPatterns(int clientId){
		List<Migration> migrationList=new ArrayList<Migration>();
		for(Migration migration:migrationRepository.findAll()) {
			if(clientId==migration.getClientId()) {
				migrationList.add(migration);
			}
		}
		return migrationList;
	}
	
	public void updateMigrationRule(List<MigrationRule> migrationRulelist, int clientId)
	{
		MigrationRule migrationRuleObject=new MigrationRule();
		for(MigrationRule migrationRule:migrationRulelist) {
			migrationRuleObject=migrationRule;
			migrationRuleObject.setClientId(clientId);
			migrationRuleObject.setMigrationId(migrationRule.getMigrationId());
			migrationRuleRepository.save(migrationRuleObject);
		}
	}
	
}
