package org.arrow.webservicelayer.model;

/**
 * 
 * @author Akhilesh
 *
 */

public class LoginModel {
	
	private String userName;
	private String password;

	public String getUserName() {
		return userName;
	}
	public void setUserName(String name) {
		this.userName = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public LoginModel(){
		
	}
	public LoginModel(String name, String password) {
		super();
		this.userName = name;
		this.password = password;
	}
	public String toString(){
		return userName+password;
	}
	
	
}
