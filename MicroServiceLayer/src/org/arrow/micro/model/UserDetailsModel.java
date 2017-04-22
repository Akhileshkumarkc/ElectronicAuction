package org.arrow.micro.model;

import java.util.ArrayList;
import java.util.List;

public class UserDetailsModel {

	private String firstName;
	private String lastName;
	private AddressModel Shippingaddress;
	private String company;
	private String phoneNumber;
	private List<UserLoginHistoryModel> userHistory = new ArrayList<UserLoginHistoryModel>();
	
	
	public UserDetailsModel(String firstName, String lastName, AddressModel address, String company, String phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.Shippingaddress = address;
		this.company = company;
		this.phoneNumber = phoneNumber;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public AddressModel getShippingAddress() {
		return Shippingaddress;
	}
	public void setShippingAddress(AddressModel address) {
		this.Shippingaddress = address;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}