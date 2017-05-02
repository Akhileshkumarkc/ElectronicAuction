package org.arrow.webservicelayer.model;


public class EmailReqParamModel {
	
	public String getTemplateclass() {
		return Templateclass;
	}
	public void setTemplateclass(String templateclass) {
		Templateclass = templateclass;
	}
	public UserRequestModel getUser() {
		return user;
	}
	public void setUser(UserRequestModel user) {
		this.user = user;
	}
	String Templateclass;
	UserRequestModel user;

}
