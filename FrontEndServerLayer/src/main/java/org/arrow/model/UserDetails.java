package org.arrow.model;

public class UserDetails {

	private String firstName;
	private String lastName;
	private String company;
	private String phoneNumber;
	private String email;
	private String streetName;
	private String houseNumber;
	private String city;
	private String state;
	private String pinCode;
	
	
	public UserDetails(String firstName, String lastName, String company, String phoneNumber, String email,
			String streetName, String houseNumber, String city, String state, String pinCode) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.streetName = streetName;
		this.houseNumber = houseNumber;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
	}
	
	public UserDetails(){
		
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
