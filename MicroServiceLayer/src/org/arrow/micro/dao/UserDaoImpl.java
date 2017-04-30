package org.arrow.micro.dao;

import java.util.List;

import org.arrow.micro.model.LoginModel;
import org.arrow.micro.model.UserDetailsModel;
import org.arrow.micro.simple.model.LoginResponseModel;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class UserDaoImpl extends AbsHibernateSession {

	public UserDetailsModel getUserDetails(int userid) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from UserDetailsModel where userId ="+userid);
		UserDetailsModel udm =  (UserDetailsModel) query.list().get(0);
		session.getTransaction().commit();
		return udm;
	
		
	}

	public LoginResponseModel update(UserDetailsModel udm, LoginResponseModel lr) {
		try{
			lr.setUserid(udm.getUserId());
			lr.setUsername(udm.getLoginInfo().getUserName());
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(udm);
			session.getTransaction().commit();
		}
		catch(Exception e){
				System.out.println(e);
				lr.setErrorMessage("Unable to change the profile");
				lr.status = false;
				throw e;
		}
		lr.status = true;
		lr.ErrorMessage = "Succesful Update of the Profile";
		return lr;	
	}
		
		
}
	


