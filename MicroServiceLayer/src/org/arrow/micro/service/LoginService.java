package org.arrow.micro.service;
import java.util.List;

import org.arrow.micro.exception.ApplicationException;
import org.arrow.micro.model.LoginModel;
import org.arrow.micro.model.UserDetailsModel;
import org.arrow.micro.simple.model.LoginResponseModel;

public interface LoginService {
	
	public LoginModel getLogin(String  userName);
	public List getAllLogin();
	public LoginResponseModel register(UserDetailsModel userDetails, LoginResponseModel lr) throws ApplicationException;
}
