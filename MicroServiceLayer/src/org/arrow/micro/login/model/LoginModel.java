package org.arrow.micro.login.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@Entity
@Table(name="login")
public class LoginModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;

	private int userId;
	@Column(name="username")
	private String userName;
	
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
		user.setId(1);
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try{
			
			session.save(user);
			tx.commit();
			System.out.println("done");
		}
		catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	    	 session.flush();
	         session.close();
	      }
	}

}
