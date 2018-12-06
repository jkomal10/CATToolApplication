package com.cattool.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cattool.application.entity.CloudableRule;
@Repository
public interface CloudableRuleRepository extends JpaRepository<CloudableRule, Long> {

	public void deleteBycloudableRuleId(int cloudableRuleId);
	CloudableRule findByQuestionId(int questionId);
	List<CloudableRule> findByClientId(int clientId);
	public void deleteByQuestionId(int questionId);
	
}
