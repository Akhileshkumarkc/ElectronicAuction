package org.arrow.micro.simple.model;

public class UserRequestModel {
	
	int userid;
	String UserName;

	public int getUserid() {
		return userid;
	}
	public UserRequestModel() {
		super();
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	
	
	
}
