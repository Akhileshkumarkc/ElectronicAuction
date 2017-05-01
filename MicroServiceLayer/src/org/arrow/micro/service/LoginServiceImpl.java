package org.arrow.micro.service;

import java.util.Date;
import java.util.List;
import org.arrow.micro.dao.LoginDaoImpl;
import org.arrow.micro.exception.ErrorMessageConstants;
import org.arrow.micro.model.LoginModel;
import org.arrow.micro.model.UserDetailsModel;
import org.arrow.micro.simple.model.LoginResponseModel;
import org.arrow.micro.exception.ApplicationException;
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
	public  LoginResponseModel register(UserDetailsModel userDetails,LoginResponseModel lr) throws ApplicationException {
		if (checkIfUserExists(userDetails)) {
			lr.ErrorMessage = "login User Exists";
			return lr;
		}
		return loginDao.save(userDetails,lr);
	}

	private boolean checkIfUserExists(UserDetailsModel userDetails) throws ApplicationException {
		boolean exists = false;
		List<LoginModel> loginList = loginDao.getAllLoginData();

		for (LoginModel item : loginList) {
			if (item != null && item.getUserName()!=null 
					&& item.getUserName().equalsIgnoreCase(
							userDetails.getLoginInfo().getUserName())) {
				return true;
			}
		
		}
		return exists;
	}

	public void updateLastLogin(LoginModel dbLoginModel) {
		dbLoginModel.setLastLogin(new Date(System.currentTimeMillis()));
		loginDao.update(dbLoginModel);		
	}

	

	
}
