package com.cattool.application.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cattool.application.entity.Migration;

public interface MigrationRepository extends JpaRepository<Migration, Long> {

}
