package com.cattool.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cattool.application.entity.ClientMaster;

public interface ClientMasterRepository extends JpaRepository<ClientMaster, Long>{
	
	ClientMaster findByClientId(int clientId);

}
