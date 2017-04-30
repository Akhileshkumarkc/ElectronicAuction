package org.arrow.micro.simple.model;


import java.util.Date;

import org.arrow.micro.model.AddressModel;
import org.arrow.micro.model.AuctionEventModel;
import org.arrow.micro.model.AuctionStatusModel;
import org.arrow.micro.model.ItemModel;
import org.arrow.micro.model.LoginModel;
import org.arrow.micro.model.UserDetailsModel;


public class SimpleToDBModelConverter {
	
	
	public static UserDetailsModel ConvertToUserDetailsModel(SimpleUserModel sum){
		UserDetailsModel udm = new UserDetailsModel();
		//dont set user id.
		//udm.setUserId(sum.getUserId());
		udm.setFirstName(sum.getFirstName());
		udm.setLastName(sum.getLastName());
		udm.setCompany(sum.getCompany());
		udm.setPhoneNumber(sum.getPhoneNumber());
		udm.setEmail(sum.getEmail());
		udm.setUseraddress(new AddressModel(sum.getUser_streetName(),
				sum.getUser_houseNumber(), sum.getUser_city(),
				sum.getUser_state(), sum.getUser_pinCode()));
		udm.setShippingAddress(new AddressModel(sum.getShipping_streetName(),
				sum.getShipping_houseNumber(), sum.getShipping_city(),
				sum.getShipping_state(), sum.getShipping_pinCode()));
		LoginModel lm = new LoginModel();
		lm.setUserName(sum.getUsername());
		lm.setPassword(sum.getPassword());
		udm.setLoginInfo(lm);
		
		return udm;
		
	}
	public static SimpleUserModel ConvertToSimpleUserModel(UserDetailsModel udm){
		
		SimpleUserModel sum = new SimpleUserModel();
		sum.setCompany(udm.getCompany());
		sum.setEmail(udm.getEmail());
		sum.setFirstName(udm.getFirstName());
		sum.setLastName(udm.getLastName());
		sum.setPassword("");
		sum.setPhoneNumber(udm.getPhoneNumber());
		sum.setShipping_city(udm.getShippingAddress().getCity());
		sum.setShipping_houseNumber(udm.getShippingAddress().getHouseNumber());
		sum.setShipping_pinCode(udm.getShippingAddress().getHouseNumber());
		sum.setShipping_state(udm.getShippingAddress().getState());
		sum.setShipping_streetName(udm.getShippingAddress().getStreetName());
		sum.setUser_city(udm.getUseraddress().getCity());
		sum.setUser_houseNumber(udm.getUseraddress().getHouseNumber());
		sum.setUser_pinCode(udm.getUseraddress().getPinCode());
		sum.setUser_state(udm.getUseraddress().getState());
		sum.setUser_streetName(udm.getUseraddress().getStreetName());
		sum.setUserId(udm.getUserId());
		sum.setUsername(udm.getLoginInfo().getUserName());
		
		return sum;
		
	}
	public static AuctionEventModel ConvertToAuctionModel(SimpleAuctionRequestModel srm){
		
		AuctionEventModel AM = new AuctionEventModel();
		
		AM.setStatus(AuctionStatusModel.OPEN);
		AM.setStartingBid(srm.getStartingBid());
		AM.setStartDateTime(new Date(System.currentTimeMillis()));
		AM.setScheduledEndDate(srm.getAcutalEndDate());
		
		ItemModel im = new ItemModel();
		
		im.setCategory("");
		im.setDescription("description");
		im.setImageURL(srm.getImageUrl());
		im.setDescription(srm.getProductDescription());
		im.setName(srm.getProductName());
		
		//TO DO: userid.
		
		return AM;
		
	}

}
