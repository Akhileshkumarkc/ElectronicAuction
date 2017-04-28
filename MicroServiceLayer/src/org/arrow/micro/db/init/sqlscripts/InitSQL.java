package org.arrow.micro.db.init.sqlscripts;

import org.arrow.micro.model.LoginModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InitSQL {

	public static void main(String args[]){
		LoginModel user = new LoginModel();
		user.setUserName("Akhilesh");
		user.setPassword("password");
		user.setLocation("Dallas");
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		System.out.println("done");
	}
}
