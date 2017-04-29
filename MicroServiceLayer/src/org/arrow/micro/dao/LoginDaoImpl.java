package org.arrow.micro.dao;
import org.arrow.micro.model.LoginModel;
import org.arrow.micro.model.UserDetailsModel;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.Date;
import java.util.List;


public class LoginDaoImpl extends AbsHibernateSession implements LoginDao  {
	

	@Override
	public LoginModel getLogin(String loginName) {
		LoginModel newLogin = new LoginModel();
		
		try{
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("reached");
		Query query = session.createQuery("from LoginModel where userName='"
				+ loginName +"'");
		System.out.println(query);
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
	public List<LoginModel> getAllLoginData() {
		
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from LoginModel");
		List<LoginModel> querylist =  query.list();
		session.getTransaction().commit();
		
		return querylist;
	}
	
	@Override
	public List getAllUserName(){
		 return getAllLoginData();
	}
	
	public boolean save(UserDetailsModel UDM) throws HibernateException{
		try{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(UDM);
		session.getTransaction().commit();
		}
		catch(Exception e){
			System.out.println(e);
			throw e;
		}
		return true;
		
	}
	
	public static void main(String args[]){
		Configuration configuration = new Configuration();
	    configuration.configure(new File("./WebContent/WEB-INF/hibernate.cfg.xml") );
	    configuration.addAnnotatedClass(LoginModel.class);
	    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).build();
	    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try{

			Query query = session.createQuery("from LoginModel");
			List<LoginModel> querylist =  (List<LoginModel>) query.list();
			session.getTransaction().commit();
			System.out.println();
			
					}
		catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	    	 session.close();
	      }

	}
}





