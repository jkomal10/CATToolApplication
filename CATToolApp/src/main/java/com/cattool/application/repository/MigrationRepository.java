package com.cattool.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cattool.application.entity.Migration;

public interface MigrationRepository extends JpaRepository<Migration, Long> {
   List<Migration> findByClientId(int clientId);

}
