package com.cattool.application.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="migration_master")
@EntityListeners(AuditingEntityListener.class)
public class Migration {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int migrationId;
	private String migrationPattern;
	private int evaluationOrder;
	private int clientId;
	@Column(name="logical_operator")
	private String permission;
	@CreatedBy
	private String createdBy;
	@CreatedDate
	private Date cteatedOn;
	@LastModifiedBy
	private String modifiedBy;
	@LastModifiedDate
	private Date modifiedOn;
	
	public int getMigrationId() {
		return migrationId;
	}
	public void setMigrationId(int migrationId) {
		this.migrationId = migrationId;
	}
	public String getMigrationPattern() {
		return migrationPattern;
	}
	public void setMigrationPattern(String migrationPattern) {
		this.migrationPattern = migrationPattern;
	}
	public int getEvaluationOrder() {
		return evaluationOrder;
	}
	public void setEvaluationOrder(int evaluationOrder) {
		this.evaluationOrder = evaluationOrder;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCteatedOn() {
		return cteatedOn;
	}
	public void setCteatedOn(Date cteatedOn) {
		this.cteatedOn = cteatedOn;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	@Override
	public String toString() {
		return "Migration [migrationId=" + migrationId + ", migrationPattern=" + migrationPattern + ", evaluationOrder="
				+ evaluationOrder + ", clientId=" + clientId + ", permission=" + permission + ", createdBy=" + createdBy
				+ ", cteatedOn=" + cteatedOn + ", modifiedBy=" + modifiedBy + ", modifiedOn=" + modifiedOn + "]";
	}
	
}
