package org.arrow.micro.model;
import java.sql.Timestamp;

public class BidModel {

	private Timestamp dateTime;
	private Double amount;
	private String transactionId;
	
	public BidModel(Timestamp dateTime, Double amount, String transactionId) {
		super();
		this.dateTime = dateTime;
		this.amount = amount;
		this.transactionId = transactionId;
	}

	public Timestamp getDateTime() {
		return dateTime;
	}

	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	
	
}

