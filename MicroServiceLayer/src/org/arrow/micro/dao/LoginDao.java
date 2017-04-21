package org.arrow.micro.dao;

import java.util.List;

import org.arrow.micro.model.LoginModel;

public interface LoginDao {

	public List getAllLoginData();
	public LoginModel getLogin(String userName);

	
}
