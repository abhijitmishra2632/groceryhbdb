package com.cosmos.contactnumbers.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usercontacts")
public class Users implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5511025153830068925L;
	@Id
	private Long mobileNumber;
	private String userName;
	private String location;
	private String userSource;
	private boolean gotWhatsapp;
	private boolean usefull;
	private LocalDate addedDate;
	
	
	public boolean isUsefull() {
		return usefull;
	}
	public void setUsefull(boolean usefull) {
		this.usefull = usefull;
	}
	public boolean isGotWhatsapp() {
		return gotWhatsapp;
	}
	public void setGotWhatsapp(boolean gotWhatsapp) {
		this.gotWhatsapp = gotWhatsapp;
	}
	public Users() {
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getUserSource() {
		return userSource;
	}
	public void setUserSource(String userSource) {
		this.userSource = userSource;
	}
	public LocalDate getAddedDate() {
		return addedDate;
	}
	public void setAddedDate() {
		this.addedDate = LocalDate.now();
	}
	@Override
	public String toString() {
		return "Users [mobileNumber=" + mobileNumber + ", userName=" + userName + ", location=" + location
				+ ", userSource=" + userSource + ", gotWhatsapp=" + gotWhatsapp + ", usefull=" + usefull
				+ ", addedDate=" + addedDate + "]";
	}	
	

}
