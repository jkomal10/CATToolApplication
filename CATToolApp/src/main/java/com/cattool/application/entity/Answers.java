package com.cattool.application.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Answers {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int answerId;
	@Column
	private int applicationId;
	@Column
	private int questionId;
	@Column
	private String answerText;
	@Column
	private boolean cloudAbility;
	@Column
	private String createdBy;
	@Column
	private Date cteatedTime;
	@Column
	private String modifiedBy;
	@Column
	private Date modifiedTime;

}
