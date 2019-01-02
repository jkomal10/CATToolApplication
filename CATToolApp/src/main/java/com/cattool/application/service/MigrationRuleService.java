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
	
	
	public List<MigrationRule> getAllmigrationRule(int clientId)
	{
		return migrationRuleRepository.findByClientId(clientId);
	}
	
	public List<Migration> getAllMigrationPatterns(int clientId){
		List<Migration> migrationList=new ArrayList<Migration>();
		migrationList=migrationRepository.findByClientId(clientId);
		return migrationList;
	}
	
	public void updateMigrationRule(List<MigrationRule> migrationRulelist, int clientId)
	{
		migrationRuleRepository.deleteAll();
		migrationRuleRepository.saveAll(migrationRulelist);
//		List<MigrationRule> MigrationRuleList = new ArrayList<MigrationRule>(); 
//		MigrationRule migrationRuleObject=new MigrationRule();
//		System.out.println("***********************");
//		for(MigrationRule migrationRule:migrationRulelist) {
//			System.out.println(migrationRule);
//			migrationRuleObject.setMigrationRuleId(migrationRule.getMigrationRuleId());
//			migrationRuleObject.setQuestionId(migrationRule.getQuestionId());
//			migrationRuleObject.setMigrationId(migrationRule.getMigrationId());
//			migrationRuleObject.setMigrationRule(migrationRule.getMigrationRule());
//			migrationRuleObject.setExecutionOrder(migrationRule.getExecutionOrder());
//			migrationRuleObject.setQuestionText(migrationRule.getQuestionText());
//			migrationRuleObject.setClientId(clientId);
//			migrationRuleObject.setOptionId(migrationRule.getOptionId());
////			migrationRuleObject=migrationRule;
////			migrationRuleObject.setClientId(clientId);
////			migrationRuleObject.setMigrationId(migrationRule.getMigrationId());
////			System.out.println(migrationRuleObject);
//			migrationRuleRepository.save(migrationRuleObject);
		;
//		}
	}
	
}
