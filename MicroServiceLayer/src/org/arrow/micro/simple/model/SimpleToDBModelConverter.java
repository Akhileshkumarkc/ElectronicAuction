package org.arrow.micro.simple.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.arrow.micro.model.AddressModel;
import org.arrow.micro.model.LoginModel;
import org.arrow.micro.model.UserDetailsModel;
import org.arrow.micro.model.UserLoginHistoryModel;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

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
