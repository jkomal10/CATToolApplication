package com.cattool.assessment.Report.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cattool.assessment.Report.entity.ReportPDF;
import com.mysql.cj.jdbc.Blob;

public interface ReportPDFRepository extends JpaRepository<ReportPDF, Long>{

	String save(String string);

}
