package org.arrow.micro.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;


@Entity
public class UserDetailsModel {
	
	//*******************************************
	//Members
	//*****************************
	@Column(name="userId")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "userids")
	@SequenceGenerator(name="userids",sequenceName="userids" ,allocationSize = 1)
	@Id
	private int userId;
	private String firstName;
	private String lastName;
	@Embedded
	@AttributeOverrides({
	@AttributeOverride(name="streetName", column=@Column(name="ship_street_name")),	
	@AttributeOverride(name="houseNumber", column=@Column(name="ship_house_no")),
	@AttributeOverride(name="city", column=@Column(name="ship_city")),
	@AttributeOverride(name="state", column=@Column(name="ship_state")),
	@AttributeOverride(name="pinCode", column=@Column(name="ship_pincode"))
	})
	private AddressModel shippingaddress;
	@Embedded
	@AttributeOverrides({
	@AttributeOverride(name="streetName", column=@Column(name="user_street_name")),	
	@AttributeOverride(name="houseNumber", column=@Column(name="user_house_no")),
	@AttributeOverride(name="city", column=@Column(name="user_city")),
	@AttributeOverride(name="state", column=@Column(name="user_state")),
	@AttributeOverride(name="pinCode", column=@Column(name="user_pincode"))
	})
	private AddressModel useraddress;
	private String company;
	@Column(unique=true)
	private String phoneNumber;
	@Column(unique=true)
	private String email;
	@Column(unique=true)
	private String username;
	
	//*******************************************
	//LoginInfo
	//*****************************
		
	@OneToOne @MapsId
	private LoginModel loginInfo;
	
	public UserDetailsModel() {
		super();
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
		return shippingaddress;
	}
	public void setShippingAddress(AddressModel address) {
		this.shippingaddress = address;
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

	public AddressModel getUseraddress() {
		return useraddress;
	}

	public void setUseraddress(AddressModel useraddress) {
		this.useraddress = useraddress;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getUserId() {
		return userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LoginModel getLoginInfo() {
		return loginInfo;
	}

	public void setLoginInfo(LoginModel loginInfo) {
		this.loginInfo = loginInfo;
	}

	
	
}