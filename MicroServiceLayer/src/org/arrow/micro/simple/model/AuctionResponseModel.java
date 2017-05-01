package org.arrow.micro.simple.model;

public class AuctionResponseModel {
	
	int auctionid;
	int userid;
	int auctionStatus;
	boolean responseStatus;
	String auctionName;
	String errorMessage;
	
	public AuctionResponseModel(){
		
	}
	
	public int getAuctionid() {
		return auctionid;
	}
	public void setAuctionid(int auctionid) {
		this.auctionid = auctionid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getAuctionStatus() {
		return auctionStatus;
	}
	public void setAuctionStatus(int auctionStatus) {
		this.auctionStatus = auctionStatus;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public boolean getResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(boolean responseStatus) {
		this.responseStatus = responseStatus;
	}

	public void setAuctionName(String auctionName) {
		this.auctionName = auctionName;
	}



	public String getAuctionName() {
		return auctionName;
	}



}
