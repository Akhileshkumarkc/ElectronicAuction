package org.arrow.micro.dao;
import org.arrow.micro.model.LoginModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class LoginDaoImpl extends AbsHibernateSession implements LoginDao  {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public LoginModel getLogin(String loginName) {
		LoginModel newLogin = new LoginModel();
		
		try{
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from LoginModel where userName='"
				+ loginName +"'");
		newLogin = (LoginModel) query.list().get(0);
		session.getTransaction().commit();
		}
		catch(Exception e){
			System.out.println("Error while applying the state");
			newLogin = null;
		}
		return newLogin;
	}

	@Override
	public List getAllLoginData() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from LoginModel");
		List querylist =  query.list();
		session.getTransaction().commit();
		
		return querylist;
	}



}





