package org.arrow.webservicelayer.controller;

import java.io.IOException;


import org.arrow.webservicelayer.MicroServiceCall.MicroServiceCallWrapper;
import org.arrow.webservicelayer.MicroServiceCall.MicroServiceWebServiceActions;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.arrow.webservicelayer.model.UserRequestModel;
import org.arrow.webservicelayer.model.LoginResponseModel;
import org.arrow.webservicelayer.model.SimpleUserModel;

@RestController
@RequestMapping("/loginservices")
public class UserController {
	
	@RequestMapping(value=MicroServiceWebServiceActions.profileview,
			method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody SimpleUserModel viewProfile(@RequestBody UserRequestModel model){
		
		//
		ObjectMapper mapper = new ObjectMapper();
		String jString = null;
		try {
			jString = mapper.writeValueAsString(model);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		//Make a webservice call to check user validity with login informationre.			
		String actionUrl = MicroServiceWebServiceActions.profileview;
		MicroServiceCallWrapper MSC = new MicroServiceCallWrapper();
		ResponseEntity<String> userResponse = MSC.call(actionUrl, jString);
		
		//default response model.
		SimpleUserModel sumd = new SimpleUserModel();
		
		
		if(userResponse.getStatusCode() == HttpStatus.OK){
			String jstring = userResponse.getBody();
			try {
				SimpleUserModel sum = mapper.readValue(jstring, SimpleUserModel.class);
				 System.out.println("succesful"); 
				 sumd = sum;
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Json cast Problem");
			}
			
			
		}
		return sumd;
		
	}
		
		//

	
	@RequestMapping(value = MicroServiceWebServiceActions.profiledit,
			method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody boolean register(
			@RequestBody SimpleUserModel userModel
			){
		//TODO:
		return true;
//		System.out.println("enteredregister");
//		UserDetailsModel userDetailModel = SimpleToDBModelConverter.ConvertToUserDetailsModel(userModel);
//		loginService.Register(userDetailModel);
//		boolean status = true;
//		return status;
	}


}

//