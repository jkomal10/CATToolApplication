package com.cattool.application.dao.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cattool.application.dao.MigrationDAO;
import com.cattool.application.dao.MigrationRuleDAO;
import com.cattool.application.entity.Migration;
import com.cattool.application.entity.MigrationRule;
import com.cattool.application.repository.MigrationRepository;
import com.cattool.application.repository.MigrationRuleRepository;

@Component
public class MigrationPatternDAOService {
	
	@Autowired
	MigrationRepository migrationRepository;
	
	@Autowired
	MigrationRuleRepository migrationRuleRepository;
	
	public List<MigrationDAO> findMigrationRules(int clientId){
		
		List<MigrationDAO> MigrationDAOs = new ArrayList<MigrationDAO>();
		for (Migration migration : migrationRepository.findByClientId(clientId)) {
			
			List<MigrationRuleDAO> migrationRuleDAO = new ArrayList<MigrationRuleDAO>();
			for (MigrationRule migrationRule : migrationRuleRepository.findByMigrationId(migration.getMigrationId())) {
				migrationRuleDAO.add(ToDAO(migrationRule));
			}
			MigrationDAOs.add(ToDAOMigrationPattern(migration,migrationRuleDAO));
		}
		return MigrationDAOs;
		
	}

	private MigrationDAO ToDAOMigrationPattern(Migration migration, List<MigrationRuleDAO> migrationRuleDAO) {
		
		MigrationDAO migrationDAO = new MigrationDAO();
		
		migrationDAO.setClientId(migration.getClientId());
		migrationDAO.setMigrationId(migration.getMigrationId());
		migrationDAO.setMigrationPattern(migration.getMigrationPattern());
		migrationDAO.setMigrationRule(migrationRuleDAO);
		migrationDAO.setPermission(migration.getPermission());
		
		return migrationDAO;
	}

	private MigrationRuleDAO ToDAO(MigrationRule migrationRule) {
		
		MigrationRuleDAO migrationRuleDAO = new MigrationRuleDAO();
		
		migrationRuleDAO.setClientId(migrationRule.getClientId());
		migrationRuleDAO.setMigrationId(migrationRule.getMigrationId());
		migrationRuleDAO.setMigrationRule(migrationRule.getMigrationRule());
		migrationRuleDAO.setMigrationRuleId(migrationRule.getMigrationRuleId());
		migrationRuleDAO.setQuestionId(migrationRule.getQuestionId());
		
		return migrationRuleDAO;
	}

}
