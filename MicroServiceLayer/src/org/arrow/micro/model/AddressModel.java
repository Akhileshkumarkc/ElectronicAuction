package org.arrow.micro.model;

import javax.persistence.Embeddable;

@Embeddable
public class AddressModel {

	private String streetName;
	private String houseNumber;
	private String city;
	private String state;
	private String pinCode;
	
	public AddressModel(){
		
	}
	public AddressModel(String streetName, String houseNumber, String city, String state, String pinCode) {
		super();
		this.streetName = streetName;
		this.houseNumber = houseNumber;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
	}
	
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
}
