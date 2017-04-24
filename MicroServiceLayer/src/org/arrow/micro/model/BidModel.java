package org.arrow.micro.model;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
@Entity
public class BidModel {
	
	@Column(name="BidId")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "Bidids")
	@SequenceGenerator(name="Bidids",sequenceName="Bidids" ,allocationSize = 1,initialValue =2000)
	@Id
	private int bidid;
	
	private Date dateTime;
	private Double amount;
	private String transactionId;
	private int userId;//AuctionEvent.close();
	
	
	
	public BidModel(int userid) {
		//TODO: is to fetch the db object and display the bid model.
		//if it doesnot exist then create a new.
		this.userId = userid;
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

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		userId = userId;
	}

	
}

