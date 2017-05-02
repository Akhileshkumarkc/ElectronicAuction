package org.arrow.micro.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class PurchasedItemModel {
	
	@Column(name="orderId")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "orderids")
	@SequenceGenerator(name="orderids",sequenceName="userids" ,allocationSize = 1)
	@Id
	private int orderId;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AUCTION_ID")
	AuctionEventModel auction;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Login_ID")
	LoginModel user;
	
	Double price;
	
	
	public AuctionEventModel getAuction() {
		return auction;
	}
	public void setAuction(AuctionEventModel auction) {
		this.auction = auction;
	}
	public LoginModel getUser() {
		return user;
	}
	public void setUser(LoginModel user) {
		this.user = user;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	 
	
	
}
