package org.arrow.webservicelayer.controller;


import java.io.IOException;

import org.arrow.webservicelayer.MicroServiceCall.MicroServiceCallWrapper;
import org.arrow.webservicelayer.MicroServiceCall.MicroServiceWebServiceActions;
import org.arrow.webservicelayer.model.EmailReqParamModel;
import org.arrow.webservicelayer.model.LoginModel;
import org.arrow.webservicelayer.model.LoginResponseModel;
import org.arrow.webservicelayer.model.SimpleUserModel;
import org.arrow.webservicelayer.service.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 
 * @author Akhilesh
 *
 */
		
@RestController
@RequestMapping("/loginservices")
public class LoginController {
	
	@RequestMapping(value="/checkuservalidity",method = RequestMethod.POST,consumes="application/json",produces = "application/json")
	public  @ResponseBody LoginResponseModel  loginAuthenitcate(@RequestBody LoginModel model){
		ObjectMapper mapper = new ObjectMapper();
		String jString = null;
		try {
			jString = mapper.writeValueAsString(model);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		//Make a webservice call to check user validity with login informationre.			
		String actionUrl = MicroServiceWebServiceActions.loginService_authenicate;
		MicroServiceCallWrapper MSC = new MicroServiceCallWrapper();
		ResponseEntity<String> loginResponse = MSC.call(actionUrl, jString);
		
		//default response model.
		LoginResponseModel logRespdef = new LoginResponseModel();
		logRespdef.ErrorMessage ="not succesful";
		logRespdef.status = false;
		logRespdef.userid = 0;
		logRespdef.username ="";
		
		if(loginResponse.getStatusCode() == HttpStatus.OK){
			String jstring = loginResponse.getBody();
			try {
				 LoginResponseModel logResp = mapper.readValue(jstring, LoginResponseModel.class);
				if(logResp.status= true){
				 System.out.println("succesful"); 
				 logRespdef = logResp;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Json cast Problem");
			}
			
			
		}
		
		//Email controller.
		EmailReqParamModel email = new EmailReqParamModel();
		email.setTemplateclass("Registration_email");
		ObjectMapper mapper1 = new ObjectMapper();
		String jString1 = null;
		try {
			jString1 = mapper1.writeValueAsString(model);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		//Make a webservice call to check user validity with login informationre.			
		String actionUrl2 = MicroServiceWebServiceActions.EmailService_SendEmail;
		MicroServiceCallWrapper MSC2 = new MicroServiceCallWrapper();
		ResponseEntity<String> loginResponse1 = MSC2.call(actionUrl2, jString1);
		
		
		
		return logRespdef;
		
	}
	
	@RequestMapping(value="/register",method = RequestMethod.POST,consumes="application/json",produces = "application/json")
	public  @ResponseBody LoginResponseModel  loginAuthenitcate2(@RequestBody SimpleUserModel model){
		
		ObjectMapper mapper = new ObjectMapper();
		String jString = null;
		try {
			jString = mapper.writeValueAsString(model);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		//Make a webservice call to check user validity with login informationre.			
		String actionUrl = MicroServiceWebServiceActions.loginService_register;
		MicroServiceCallWrapper MSC = new MicroServiceCallWrapper();
		ResponseEntity<String> loginResponse = MSC.call(actionUrl, jString);
		
		//default response model.
		LoginResponseModel logRespdef = new LoginResponseModel();
		logRespdef.ErrorMessage ="not succesful";
		logRespdef.status = false;
		logRespdef.userid = 0;
		logRespdef.username ="";
		
		if(loginResponse.getStatusCode() == HttpStatus.OK){
			String jstring = loginResponse.getBody();
			try {
				 LoginResponseModel logResp = mapper.readValue(jstring, LoginResponseModel.class);
				if(logResp.status= true){
				 System.out.println("succesful"); 
				 logRespdef = logResp;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Json cast Problem");
			}
			
			
		}
		return logRespdef;
	}

}
