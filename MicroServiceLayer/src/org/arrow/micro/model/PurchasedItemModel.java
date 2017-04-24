package org.arrow.micro.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class PurchasedItemModel {
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AUCTION_ID")
	AuctionEventModel auction;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
	UserDetailsModel user;
	
	Double price;
	
	
	public AuctionEventModel getAuction() {
		return auction;
	}
	public void setAuction(AuctionEventModel auction) {
		this.auction = auction;
	}
	public UserDetailsModel getUser() {
		return user;
	}
	public void setUser(UserDetailsModel user) {
		this.user = user;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	 
	
	
}
