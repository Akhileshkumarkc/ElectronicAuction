package org.arrow.micro.model;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class BidModel {
	
	@Column(name="BidId")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "Bidids")
	@SequenceGenerator(name="Bidids",sequenceName="Bidids" ,allocationSize = 1,initialValue =2000)
	@Id
	private int bidid;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "PUBLISHED")
	private Date dateTime;
	private Double amount;
	@OneToOne  @JoinColumn(name= "userId")
	private LoginModel Login;//AuctionEvent.close();
	
	public BidModel(){
		
	}
	
	public BidModel(LoginModel Login) {
		//TODO: is to fetch the db object and display the bid model.
		//if it doesnot exist then create a new.
		this.Login = Login;
	}


	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}

	public Double getBid() {
		return amount;
	}

	public void setBid(Double amount) {
		this.amount = amount;
	}

	public int getUserId() {
		return Login.getUserId();
	}

	public void setUserId(int userId) {
		Login.setUserId(userId);
	}

	
}

