package com.cattool.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cattool.application.entity.CloudProvider;
import com.cattool.application.entity.CloudProviderRule;


public interface CloudProviderRepository extends JpaRepository<CloudProvider,Long>{

  List<CloudProvider> findByClientId(int clientId);


}
