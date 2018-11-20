package com.cattool.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cattool.application.entity.ReportIssue;


@Repository
public interface ReportIssueRepository extends JpaRepository<ReportIssue,Long>{

//	ReportIssue save(String issue);

}
