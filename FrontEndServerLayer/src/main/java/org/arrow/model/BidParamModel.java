package org.arrow.model;

public class BidParamModel {
	
	int auctionId;
	int userId;
	String userName;
	Double bidvalue;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAuctionId() {
		return auctionId;
	}
	public void setAuctionId(int auctionId) {
		this.auctionId = auctionId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Double getBidvalue() {
		return bidvalue;
	}
	public void setBidvalue(Double bidvalue) {
		this.bidvalue = bidvalue;
	}
	
	

}
