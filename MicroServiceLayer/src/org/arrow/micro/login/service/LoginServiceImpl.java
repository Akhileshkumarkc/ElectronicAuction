package org.arrow.micro.login.service;

import java.util.List;

import javax.transaction.Transactional;

import org.arrow.micro.login.dao.LoginDao;
import org.arrow.micro.login.model.LoginModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("loginService")
@Transactional
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDao loginDao;
	
	@Override
	public void add(LoginModel login) {
		loginDao.add(login);
		
	}

	@Override
	public void edit(LoginModel login) {
		loginDao.edit(login);
		
	}

	@Override
	public void delete(String userName) {
		loginDao.delete(userName);
		
	}

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
	

}
