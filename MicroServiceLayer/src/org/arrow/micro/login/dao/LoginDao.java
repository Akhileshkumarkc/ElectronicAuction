package org.arrow.micro.login.dao;

import java.util.List;

import org.arrow.micro.login.model.LoginModel;

public interface LoginDao {

	public void add(LoginModel login);
	public void delete(String userName);
	public void edit(LoginModel login);
	public List getAllLoginData();
	public LoginModel getLogin(String userName);

	
}
