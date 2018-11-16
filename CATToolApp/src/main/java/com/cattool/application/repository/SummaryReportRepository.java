package com.cattool.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cattool.application.entity.SummaryReport;

public interface SummaryReportRepository extends JpaRepository<SummaryReport, Long> {

}
