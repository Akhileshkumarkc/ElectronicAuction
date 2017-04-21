package org.arrow.micro.model;

import java.io.File;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

@Entity
@Table(name="login")
public class LoginModel {
	

	@Column(name="Id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "userids")
	@SequenceGenerator(name="userids",sequenceName="userids" ,allocationSize = 1)
	
	private int Id;
	@Id
	@Column(name="userId")
	private int userId;
	@Column(name="username")
	private String userName;
	@Column(name="password")
	private String password;
		
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static void main(String args[]){
		LoginModel user = new LoginModel();
		user.setUserName("Akhilesh");
		user.setPassword("password");
		user.setUserId(3);
		user.setId(3);
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
			user.setId(2);
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
