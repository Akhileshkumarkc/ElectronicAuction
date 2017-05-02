package org.arrow.micro.simple.model;

import java.util.Date;

public class SimpleAuctionRequestModel {
	
	public String userName;
	public Date acutalEndDate;
	public String productName;
	public String productDescription;
	public Double startingBid;
	public String imageURL;
	public String category;
	public int auctionid;
	
	
	public int getAuctionid() {
		return auctionid;
	}
	public void setAuctionid(int auctionid) {
		this.auctionid = auctionid;
	}
	public String getUserName() {
		return userName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
