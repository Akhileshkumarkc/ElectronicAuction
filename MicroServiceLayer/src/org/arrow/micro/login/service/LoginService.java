package org.arrow.micro.login.service;
import java.util.List;

import org.arrow.micro.login.model.LoginModel;

public interface LoginService {
	
	public void add(LoginModel login);
	public void edit(LoginModel login);
	public void delete(String userName);
	public LoginModel getLogin(String  userName);
	public List getAllLogin();
	
}
