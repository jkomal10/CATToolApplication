package com.cattool.assessment.Report.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cattool.assessment.Report.entity.ReportPDF;
import com.mysql.cj.jdbc.Blob;

public interface ReportPDFRepository extends JpaRepository<ReportPDF, Long>{

	 void save(byte[] reportArray);

	List<ReportPDF> findAllByGeneratedDateTimeBetween(Date fromDate, Date toDate);

	byte[] findPdfFilesByApplicationName(String appName);

	Object findByApplicationName(String string);

//	boolean findByApplicationName(String string);

}
