package org.arrow.micro.login.dao;
import org.arrow.micro.login.model.LoginModel;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class LoginDaoImpl implements LoginDao  {
	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(LoginModel login) {
		session.getCurrentSession().save(login);
		
	}

	@Override
	public void delete(String loginName) {
		session.getCurrentSession().delete(this.getLogin(loginName));
	}

	@Override
	public void edit(LoginModel login) {
		session.getCurrentSession().update(login);
		
	}

	@Override
	public LoginModel getLogin(String loginName) {
		return (LoginModel)session.getCurrentSession().get(LoginModel.class, loginName);
	}

	@Override
	public List getAllLoginData() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from loginTable").list();
	}

	

	
}





