package com.cattool.application.dao;

import java.util.List;

public class MigrationDAO {

	private int migrationId;
	private String migrationPattern;
	private int clientId;
	private List<MigrationRuleDAO> migrationRule;
	public int getMigrationId() {
		return migrationId;
	}
	public void setMigrationId(int migrationId) {
		this.migrationId = migrationId;
	}
	public String getMigrationPattern() {
		return migrationPattern;
	}
	public void setMigrationPattern(String migrationPattern) {
		this.migrationPattern = migrationPattern;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public List<MigrationRuleDAO> getMigrationRule() {
		return migrationRule;
	}
	public void setMigrationRule(List<MigrationRuleDAO> migrationRule) {
		this.migrationRule = migrationRule;
	}
	@Override
	public String toString() {
		return "MigrationDAO [migrationId=" + migrationId + ", migrationPattern=" + migrationPattern + ", clientId="
				+ clientId + ", migrationRule=" + migrationRule + "]";
	}
	
	
	
}
