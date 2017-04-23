package org.arrow.micro.dao;

import java.util.List;

import org.arrow.micro.model.LoginModel;
import org.arrow.micro.model.UserDetailsModel;

public interface LoginDao {

	public List getAllLoginData();
	public LoginModel getLogin(String userName);
	public List<String> getAllUserName();
	public boolean save(UserDetailsModel UDM);

	
}
