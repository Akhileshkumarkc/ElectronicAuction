package org.arrow.model;


public class LoginResponseModel {
	
	public boolean status;
	public int userid;
	public String username;
	public String ErrorMessage;
	boolean userAlreadyExists;
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getErrorMessage() {
		return ErrorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}
	public boolean isUserAlreadyExists() {
		return userAlreadyExists;
	}
	public void setUserAlreadyExists(boolean userAlreadyExists) {
		this.userAlreadyExists = userAlreadyExists;
	}

}
