package com.cattool.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cattool.application.entity.ClientUser;

public interface ClientUserRepository extends JpaRepository<ClientUser, Long>{

}
