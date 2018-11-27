package com.cattool.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cattool.application.entity.ClientMaster;

public interface ClientUserRepository extends JpaRepository<ClientMaster, Long>{

}
