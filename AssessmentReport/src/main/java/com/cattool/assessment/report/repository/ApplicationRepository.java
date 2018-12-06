package com.cattool.assessment.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cattool.assessment.report.entity.Application;


public interface ApplicationRepository extends JpaRepository<Application, Long>{

}
