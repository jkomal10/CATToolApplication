package com.cattool.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cattool.application.entity.MigrationRule;

public interface MigrationRuleRepository extends JpaRepository<MigrationRule, Long> {

	
	List<MigrationRule> findByClientId(int clientId);
}
