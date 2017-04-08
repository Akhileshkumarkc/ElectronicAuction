package org.arrow.micro.db.init.sqlscripts;

import org.arrow.micro.db.login.LoginDb;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InitSQL {

	public static void main(String args[]){
		LoginDb user = new LoginDb();
		user.setUserId(1);
		user.setUserName("First Name");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		System.out.println("done");
	}
}
