package org.arrow.micro.dao;

import java.util.List;

import org.arrow.micro.model.LoginModel;
import org.arrow.micro.model.UserDetailsModel;
import org.arrow.micro.simple.model.LoginResponseModel;
import org.hibernate.HibernateException;

public interface LoginDao {

	public List getAllLoginData();
	public LoginModel getLogin(String userName);
	public List<String> getAllUserName();
	public LoginResponseModel save(UserDetailsModel UDM, LoginResponseModel lr) throws HibernateException;

	
}
