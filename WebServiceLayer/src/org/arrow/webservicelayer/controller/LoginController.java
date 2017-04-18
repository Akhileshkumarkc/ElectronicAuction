package org.arrow.webservicelayer.controller;


import org.arrow.webservicelayer.MicroServiceCall.MicroServiceCallWrapper;
import org.arrow.webservicelayer.MicroServiceCall.MicroServiceWebServiceActions;
import org.arrow.webservicelayer.model.LoginModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/loginservices")
public class LoginController {
	
	
	
	@RequestMapping(value="/checkuservalidity",method = RequestMethod.POST,consumes="application/json",produces = "application/json")
	public  @ResponseBody boolean loginAuthenitcate(@RequestBody LoginModel model){
		ObjectMapper mapper = new ObjectMapper();
		String jString = null;
		try {
			jString = mapper.writeValueAsString(model);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		//Make a webservice call to check user validity with login information.			
		String actionUrl = MicroServiceWebServiceActions.loginService;
		MicroServiceCallWrapper MSC = new MicroServiceCallWrapper();
		ResponseEntity<String> loginResponse = MSC.call(actionUrl, jString);
		boolean status = false;
		if(loginResponse.getStatusCode() == HttpStatus.OK){
			if(loginResponse.getBody().equalsIgnoreCase("true")){
				status = true;
			}
		}
		return status;
		
	}

//	@RequestMapping(value="/checkuservalidity",method = RequestMethod.POST,consumes="application/json",produces = "application/json")
//	public  @ResponseBody LoginModel loginAuthenitcate(@RequestBody LoginModel model){
//		System.out.println(model.toString());
//		return model;
//		
//	}

}
