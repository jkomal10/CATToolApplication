package com.cattool.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cattool.application.entity.MigrationRule;

public interface MigrationRuleRepository extends JpaRepository<MigrationRule, Long> {

}
