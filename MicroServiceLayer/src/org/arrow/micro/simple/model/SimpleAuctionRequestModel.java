package org.arrow.micro.simple.model;

import java.util.Date;

public class SimpleAuctionRequestModel {
	
	String userName;
	Date acutalEndDate;
	String productName;
	String productDescription;
	Double startingBid;
	String imageURL;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName ) {
		this.userName = userName;
	}
	public Date getAcutalEndDate() {
		return acutalEndDate;
	}
	public void setAcutalEndDate(Date acutalEndDate) {
		acutalEndDate = acutalEndDate;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		productDescription = productDescription;
	}
	public Double getStartingBid() {
		return startingBid;
	}
	public void setStartingBid(Double startingBid) {
		startingBid = startingBid;
	}
	public String getImageUrl() {
		return imageURL;
	}
	public void setImageUrl(String imageUrl) {
		this.imageURL = imageURL;
	}

}
