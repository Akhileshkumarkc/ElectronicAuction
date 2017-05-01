package org.arrow.micro.test;

import java.io.File;

import org.arrow.micro.model.AddressModel;
import org.arrow.micro.model.AuctionEventModel;
import org.arrow.micro.model.BidModel;
import org.arrow.micro.model.LoginModel;
import org.arrow.micro.model.PurchasedItemModel;
import org.arrow.micro.model.UserDetailsModel;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class TestLogin {

	
	public static void main(String args[]){

		UserDetailsModel akhileshUser = new UserDetailsModel();
		LoginModel lma = new LoginModel();
		lma.setUserName("akhilesh");
		lma.setPassword("password");
		
		akhileshUser.setLoginInfo(lma);
		// 2b.  fill in normal details.
		akhileshUser.setFirstName("Akhilesh");
		akhileshUser.setLastName("kumar");
		akhileshUser.setPhoneNumber("4696644745");
		akhileshUser.setCompany("utdallas");
		akhileshUser.setEmail("akhi.x319@gmail.com");
		akhileshUser.setUseraddress( new AddressModel("7815", "16101", "Richardson", "Texas", "75252"));
		akhileshUser.setShippingAddress( new AddressModel("7815", "16101", "Richardson", "Texas", "75252"));

		Configuration configuration = new Configuration();
	    configuration.configure(new File("./WebContent/WEB-INF/hibernate.cfg.xml") );
	    configuration.addAnnotatedClass(LoginModel.class);
	    configuration.addAnnotatedClass(UserDetailsModel.class);
	    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).build();
	    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try{
			
			session.save(akhileshUser);
			session.save(lma);
			
			session.getTransaction().commit();
					}
		catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	    	 session.close();
	      }
	}
}
		
		
