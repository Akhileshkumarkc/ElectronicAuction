package org.arrow.webservicelayer.model;


public class EmailReqParamModel {
	
	
	String userName;
	String Templateclass;
	String emailAddress;
	
	public String getTemplateclass() {
		return Templateclass;
	}
	public void setTemplateclass(String templateclass) {
		Templateclass = templateclass;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	

}
