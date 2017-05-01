package org.arrow.micro.simple.model;

import java.util.Date;

public class SimpleAuctionRequestModel {
	
	public String userName;
	public Date acutalEndDate;
	public String productName;
	public String productDescription;
	public Double startingBid;
	public String imageURL;
	
	
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
		this.acutalEndDate = acutalEndDate;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public Double getStartingBid() {
		return startingBid;
	}
	public void setStartingBid(Double startingBid) {
		this.startingBid = startingBid;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	
}
