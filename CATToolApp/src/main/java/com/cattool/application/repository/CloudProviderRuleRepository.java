package com.cattool.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cattool.application.entity.CloudProviderRule;

public interface CloudProviderRuleRepository extends JpaRepository<CloudProviderRule, Long>{

}
