package com.cattool.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cattool.application.entity.CloudProviderRule;

public interface CloudProviderRuleRepository extends JpaRepository<CloudProviderRule, Long>{

	void deleteByQuestionId(String string);

//	SList<CloudProviderRule> findAllByCloudProviderId();

	List<CloudProviderRule> findByCloudProviderId(int cloudProviderId);

//	Object findAllByCloudProviderId();

//	Object findByCloudProviderId();

}
