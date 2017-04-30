package org.arrow.micro.dao;

import java.util.List;

import org.arrow.micro.model.LoginModel;
import org.arrow.micro.model.UserDetailsModel;
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
	

}
