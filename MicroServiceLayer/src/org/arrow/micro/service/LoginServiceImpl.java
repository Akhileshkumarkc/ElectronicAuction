package org.arrow.micro.service;

import java.util.List;
import org.arrow.micro.dao.LoginDaoImpl;
import org.arrow.micro.model.LoginModel;
import org.arrow.micro.model.UserDetailsModel;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDaoImpl loginDao;
	
	
	@Override
	public LoginModel getLogin(String login) {
		// TODO Auto-generated method stub
		return loginDao.getLogin(login);
	}

	@Override
	public List getAllLogin() {
		// TODO Auto-generated method stub
		return loginDao.getAllLoginData();
	}

	@Override
	public boolean Register(UserDetailsModel userDetails) {
		return loginDao.save(userDetails);
	}

	private String checkIfUserExists(UserDetailsModel userDetails) throws Exception {
		// TODO:  
		return "yes";
			
		
	}
	

}
