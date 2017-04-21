package org.arrow.micro.service;
import java.util.List;

import org.arrow.micro.model.LoginModel;

public interface LoginService {
	
	public LoginModel getLogin(String  userName);
	public List getAllLogin();
	
}
