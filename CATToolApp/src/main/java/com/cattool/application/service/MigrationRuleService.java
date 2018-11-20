package com.cattool.application.service;

import java.util.ArrayList;
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
	
	public List<Migration> getAllMigrationPatterns(String clientName){
		List<Migration> migrationList=new ArrayList<Migration>();
		for(Migration migration:migrationRepository.findAll()) {
			System.out.println(clientName+"=="+migration.getClientName());
			if(clientName.equals(migration.getClientName())) {
				migrationList.add(migration);
			}
		}
		System.out.println(migrationList);
		return migrationList;
	}
	
	public void updateMigrationRule(List<MigrationRule> migrationRulelist, String clientName)
	{
		MigrationRule migrationRuleObject=new MigrationRule();
		for(MigrationRule migrationRule:migrationRulelist) {
			migrationRuleObject=migrationRule;
			migrationRuleObject.setClientName(clientName);
			migrationRuleObject.setMigrationId(migrationRule.getMigrationId());
			migrationRuleRepository.save(migrationRuleObject);
		}
	}
	
}
