package org.arrow.micro.simple.model;


import org.arrow.micro.model.AddressModel;
import org.arrow.micro.model.LoginModel;
import org.arrow.micro.model.UserDetailsModel;


public class SimpleToDBModelConverter {
	
	
	public static UserDetailsModel ConvertToUserDetailsModel(SimpleUserModel sum){
		UserDetailsModel udm = new UserDetailsModel();
		udm.setUserId(sum.getUserId());
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

}
