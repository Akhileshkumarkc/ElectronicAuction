package org.arrow.micro.emailtemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.arrow.micro.model.EmailModel;

public class EmailTemplateClass {
	
	Map<String,EmailModel> EmailTemplates;
	public static final String REGISTERATION_EMAIL = "Registration_email"; 
	
	public void init(){
		EmailTemplates = new HashMap<String,EmailModel>();
		
		// new email.
		EmailModel emnewuser = new EmailModel();
		emnewuser.messageBody = "Your Account is created with Electronics Auction";
		emnewuser.subject = "Electronics Auction:created";
		emnewuser.senderEmailAddress ="admin@ElectronicsAuction.com";
		
		EmailTemplates.put(REGISTERATION_EMAIL, emnewuser);
	}
	
	public EmailModel getTemplate(String name){
		return EmailTemplates.get(name);
		
	}
	 

}
