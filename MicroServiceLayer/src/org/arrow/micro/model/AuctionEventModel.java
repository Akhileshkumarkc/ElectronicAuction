package org.arrow.micro.model;

import java.sql.Timestamp;

public class AuctionEventModel {

	private String name;
	private String description;
	private String status;
	private Double startingBid;
	private Timestamp startDateTime;
	private Timestamp scheduledEndDate;
	private Timestamp actualEndDate;
	private Double reserveAmount;
	private Double minBidIncrement;
	
	
	public AuctionEventModel(String name, String description, String status, Double startingBid, Timestamp startDateTime,
			Timestamp scheduledEndDate, Timestamp actualEndDate, Double reserveAmount, Double minBidIncrement) {
		super();
		this.name = name;
		this.description = description;
		this.status = status;
		this.startingBid = startingBid;
		this.startDateTime = startDateTime;
		this.scheduledEndDate = scheduledEndDate;
		this.actualEndDate = actualEndDate;
		this.reserveAmount = reserveAmount;
		this.minBidIncrement = minBidIncrement;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getStartingBid() {
		return startingBid;
	}
	public void setStartingBid(Double startingBid) {
		this.startingBid = startingBid;
	}
	public Timestamp getStartDateTime() {
		return startDateTime;
	}
	public void setStartDateTime(Timestamp startDateTime) {
		this.startDateTime = startDateTime;
	}
	public Timestamp getScheduledEndDate() {
		return scheduledEndDate;
	}
	public void setScheduledEndDate(Timestamp scheduledEndDate) {
		this.scheduledEndDate = scheduledEndDate;
	}
	public Timestamp getActualEndDate() {
		return actualEndDate;
	}
	public void setActualEndDate(Timestamp actualEndDate) {
		this.actualEndDate = actualEndDate;
	}
	public Double getReserveAmount() {
		return reserveAmount;
	}
	public void setReserveAmount(Double reserveAmount) {
		this.reserveAmount = reserveAmount;
	}
	public Double getMinBidIncrement() {
		return minBidIncrement;
	}
	public void setMinBidIncrement(Double minBidIncrement) {
		this.minBidIncrement = minBidIncrement;
	}
	
	
}
