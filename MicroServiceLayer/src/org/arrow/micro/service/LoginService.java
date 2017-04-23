package org.arrow.micro.service;
import java.util.List;

import org.arrow.micro.model.LoginModel;
import org.arrow.micro.model.UserDetailsModel;

public interface LoginService {
	
	public LoginModel getLogin(String  userName);
	public List getAllLogin();
	public boolean Register(UserDetailsModel userDetails);
}
