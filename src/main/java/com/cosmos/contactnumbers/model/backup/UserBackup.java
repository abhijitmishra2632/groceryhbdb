package com.cosmos.contactnumbers.model.backup;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usercontactsbackup")
public class UserBackup {
	@Id
	private Long mobileNumber;
	private String userName;
	private String location;
	private String userSource;
	private boolean gotWhatsapp;
	private boolean isUsefull;
	private LocalDate addedDate;
	
	public UserBackup() {
		super();
	}
	public UserBackup(Long mobileNumber, String userName, String location, String userSource, boolean gotWhatsapp,
			boolean isUsefull, LocalDate addedDate) {
		super();
		this.mobileNumber = mobileNumber;
		this.userName = userName;
		this.location = location;
		this.userSource = userSource;
		this.gotWhatsapp = gotWhatsapp;
		this.isUsefull = isUsefull;
		this.addedDate = addedDate;
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
	public boolean isGotWhatsapp() {
		return gotWhatsapp;
	}
	public void setGotWhatsapp(boolean gotWhatsapp) {
		this.gotWhatsapp = gotWhatsapp;
	}
	public boolean isUsefull() {
		return isUsefull;
	}
	public void setUsefull(boolean isUsefull) {
		this.isUsefull = isUsefull;
	}
	public LocalDate getAddedDate() {
		return addedDate;
	}
	public void setAddedDate(LocalDate addedDate) {
		this.addedDate = addedDate;
	}
	
}
