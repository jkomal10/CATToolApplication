package com.cattool.application.dao;

import java.io.Serializable;
import java.util.Date;


public class ApplicationDAO implements Serializable {

	private int applicationId;
	
	private String applicationName;
	
	private String applicationDescription;
	
	private String isCloudable;
	
	private String MigrationPattern;
	
	private String cloudProvider;
	
	private boolean isAssessment;
	
	private int isFinalize;
	
	private boolean isDeleted;
	
	private boolean isDeactivate;
	
	private Date deletedDateTime;
	
	private boolean isVerified;
	
	private Date createdDate;
	
	private Date modifiedDateTime;
	
	private String createdBy;
	
	private String modifiedBy;
	
	private int userId;
	
	private int isSaved;
	
	private int clientId;
	
	private Date assessApplicationTime;
	
	
}
