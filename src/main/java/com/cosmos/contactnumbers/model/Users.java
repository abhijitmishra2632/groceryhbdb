package com.cosmos.contactnumbers.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usercontacts")
public class Users {
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
	

}
