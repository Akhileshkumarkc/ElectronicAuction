package org.arrow.micro.model;

import java.io.File;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/*
 * User class to hold the date of the user.
 * @author Akhilesh
 */
@Entity
@Table(name="user1")
public class User {
	@Id
	private String name;
	@Column
	private String password;
	
	public User(){
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static void main(String args[]){
		
		User user = new User();
		user.setName("Akhilesh");
		user.setPassword("password");
		
		Configuration configuration = new Configuration();
	    configuration.configure(new File("./WebContent/WEB-INF/hibernate.cfg.xml") );
	    configuration.addAnnotatedClass(User.class);
	    
	    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).build();
	    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		try{
			session.save(user);
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
