package org.arrow.micro.email;

import org.arrow.micro.model.UserDetailsModel;

public class EmailReqParamModel {
	
	public String getTemplateclass() {
		return Templateclass;
	}
	public void setTemplateclass(String templateclass) {
		Templateclass = templateclass;
	}
	public UserDetailsModel getUser() {
		return user;
	}
	public void setUser(UserDetailsModel user) {
		this.user = user;
	}
	String Templateclass;
	UserDetailsModel user;

}
