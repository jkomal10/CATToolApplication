package com.cattool.application.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String userName;
	private String firstName;
	private String lastName;
	private String password;
	private String ipAddress;
	private int lastLogin;
	private String company;
	private Date createdOn;
	private int isDeleted;
	private int languageId;
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
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public int getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	public int getLanguageId() {
		return languageId;
	}
	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}
	public Users() {
		super();
	}
	public Users(int userId, String userName, String firstName, String lastName, String password, String ipAddress,
			int lastLogin, String company, Date createdOn, int isDeleted, int languageId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.ipAddress = ipAddress;
		this.lastLogin = lastLogin;
		this.company = company;
		this.createdOn = createdOn;
		this.isDeleted = isDeleted;
		this.languageId = languageId;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", firstName=" + firstName + ", lastName="
				+ lastName + ", password=" + password + ", ipAddress=" + ipAddress + ", lastLogin=" + lastLogin
				+ ", company=" + company + ", createdOn=" + createdOn + ", isDeleted=" + isDeleted + ", languageId="
				+ languageId + "]";
	}
	
	
	
}
