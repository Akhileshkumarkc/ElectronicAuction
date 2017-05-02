package org.arrow.micro.email;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmailTemplateClass {
	
	public static Map<String,EmailModel> EmailTemplates;
	public static final String REGISTERATION_EMAIL = "Registration_email";
	public static final String LOGIN_EMAIL = "Login_email";
	public static final String BID_PURCHASED = "Bid_purchased";
	
	public  static void init(){
		EmailTemplates = new HashMap<String,EmailModel>();
		
		// new email.
		EmailModel emnewuser = new EmailModel();
		emnewuser.messageBody = "Your Account is created with Electronics Auction";
		emnewuser.subject = "Electronics Auction:created";
		emnewuser.senderEmailAddress ="admin@ElectronicsAuction.com";
		
		EmailTemplates.put(REGISTERATION_EMAIL, emnewuser);
		
		// login email
		// new email.
		EmailModel email2 = new EmailModel();
		emnewuser.messageBody = "Some tried to login with your account with Electronics Auction";
		emnewuser.subject = "Electronics Auction:login";
		emnewuser.senderEmailAddress ="admin@ElectronicsAuction.com";
		EmailTemplates.put(LOGIN_EMAIL, email2);
		
		EmailModel email3 = new EmailModel();
		emnewuser.messageBody = "Your got the Highest Bid and the item is Purchased";
		emnewuser.subject = "Electronics Auction:Item";
		emnewuser.senderEmailAddress ="admin@ElectronicsAuction.com";
		EmailTemplates.put(BID_PURCHASED, email3);
		
		
		
	}
	
	public static EmailModel  getTemplate(String name){
		return EmailTemplates.get(name);
		
	}
	 

}
