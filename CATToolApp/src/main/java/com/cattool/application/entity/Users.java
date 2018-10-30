package com.cattool.application.entity;

import java.util.Date;
import javax.persistence.EntityListeners;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="users_table")
public class Users {
	
	@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String userName;
	private String firstName;
	private String lastName;
	private String password="Cg@123";
	private String ipAddress;
	private int lastLogin;
	private String company;
	private int isDeleted;
	private boolean isDeactivate;
	
	@CreatedDate
	private Date createdDateTime;
	@CreatedBy
	private String createdBy;
	@LastModifiedDate
	private Date modifiedDateTime;
	@LastModifiedBy
	private String modifiedBy;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public int getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(int lastLogin) {
		this.lastLogin = lastLogin;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDateTime() {
		return createdDateTime;
	}
	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getModifiedDateTime() {
		return modifiedDateTime;
	}
	public void setModifiedDateTime(Date modifiedDateTime) {
		this.modifiedDateTime = modifiedDateTime;
	}
	
	public boolean isDeactivate() {
		return isDeactivate;
	}
	public void setDeactivate(boolean isDeactivate) {
		this.isDeactivate = isDeactivate;
	}

	public Users() {
		super();
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", firstName=" + firstName + ", lastName="
				+ lastName + ", password=" + password + ", ipAddress=" + ipAddress + ", lastLogin=" + lastLogin
				+ ", company=" + company + ", isDeleted=" + isDeleted + ", isDeactivate=" + isDeactivate
				+ ", createdDateTime=" + createdDateTime + ", createdBy=" + createdBy + ", modifiedDateTime="
				+ modifiedDateTime + ", modifiedBy=" + modifiedBy + "]";
	}
	
	
	
	
	
	
}
