package com.cattool.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cattool.application.entity.CloudableRule;
@Repository
public interface CloudableRuleRepository extends JpaRepository<CloudableRule, Long> {

}
