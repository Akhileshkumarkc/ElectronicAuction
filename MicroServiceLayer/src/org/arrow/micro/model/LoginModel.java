package org.arrow.micro.model;

import java.io.File;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	

	@Column(name="userId")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "loginids")
	@SequenceGenerator(name="loginids",sequenceName="userids" ,allocationSize = 1)
	@Id
	private int userId;
	@Column(name="username", unique =true,nullable = false, updatable = false)
	private String userName;
	@Column(name="password", nullable = false, updatable = false)
	private String password;
	
	//@Temporal(TemporalType.DATE)
	private Date lastLogin;
	@Column
	private String Location;
		
	public int getLoginId() {
		return userId;
	}
	public void setLoginId(int id) {
		userId = id;
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	
	public static void main(String args[]){
		LoginModel user = new LoginModel();
		user.setUserName("Akhilesh");
		user.setPassword("password");
		Configuration configuration = new Configuration();
	    configuration.configure(new File("./WebContent/WEB-INF/hibernate.cfg.xml") );
	    
	    
	    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).build();
	    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    configuration.addAnnotatedClass(LoginModel.class);
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try{
			user.setUserName("Akhilesh");
			user.setPassword("password");
			user.setLastLogin(new Date());
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
