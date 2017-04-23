package org.arrow.micro.test;

import java.io.File;

import org.arrow.micro.model.LoginModel;
import org.arrow.micro.model.UserDetailsModel;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateTest {
	
	public static void main(String args[]){
		LoginModel user = new LoginModel();
		user.setUserName("Akhilesh");
		user.setPassword("password");
		
		Configuration configuration = new Configuration();
	    configuration.configure(new File("./WebContent/WEB-INF/hibernate.cfg.xml") );
	    configuration.addAnnotatedClass(LoginModel.class);
	    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).build();
	    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try{
			user.setUserName("Akhilesh");
			user.setPassword("password");
			session.save(user);
			session.getTransaction().commit();
					}
		catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	    	 session.close();
	      }
		
		//getting the information.
		session = sessionFactory.openSession();
		//proxy class get.
		UserDetailsModel user1 =(UserDetailsModel) session.get(UserDetailsModel.class, 1);
		user1.getShippingAddress();

	}
	
}


