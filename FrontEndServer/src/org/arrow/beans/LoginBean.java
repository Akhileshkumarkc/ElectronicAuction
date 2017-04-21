package org.arrow.beans;

public class LoginBean {

	private String userName;
	private String password;
    /**
     * Default constructor. 
     */
    public LoginBean() {
    	userName = "";
    	password = "";
    }
	
	public String getuserName() {
		return userName;
	}
	
	public void setuserName(String name) {
		this.userName = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
