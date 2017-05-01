package org.arrow.webservicelayer.controller;

import java.io.IOException;

import org.arrow.webservicelayer.MicroServiceCall.MicroServiceCallWrapper;
import org.arrow.webservicelayer.MicroServiceCall.MicroServiceWebServiceActions;
import org.arrow.webservicelayer.WebServiceCall.WebServicesActions;
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
@RequestMapping(WebServicesActions.USERSERVICE)
public class UserController {

	@RequestMapping(value = WebServicesActions.profileview, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody SimpleUserModel viewProfile(@RequestBody UserRequestModel model) {

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
		String actionUrl = MicroServiceWebServiceActions.userprofileview;
		// Make a webservice call to check user validity with login
		// informationre.
		MicroServiceCallWrapper MSC = new MicroServiceCallWrapper();
		ResponseEntity<String> userResponse = MSC.call(actionUrl, jString);

		// default response model.
		SimpleUserModel sumd = new SimpleUserModel();

		if (userResponse.getStatusCode() == HttpStatus.OK) {
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

	@RequestMapping(value = WebServicesActions.profiledit, method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody LoginResponseModel editProfile(@RequestBody SimpleUserModel userModel) {
		ObjectMapper mapper = new ObjectMapper();
		String jString = null;
		try {
			jString = mapper.writeValueAsString(userModel);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Make a webservice call to check user validity with login
		// informationre.
		String actionUrl = MicroServiceWebServiceActions.userprofiledit;
		MicroServiceCallWrapper MSC = new MicroServiceCallWrapper();
		ResponseEntity<String> loginResponse = MSC.call(actionUrl, jString);

		// default response model.
		LoginResponseModel logRespdef = new LoginResponseModel();
		logRespdef.ErrorMessage = "not succesful";
		logRespdef.status = false;
		logRespdef.userid = 0;
		logRespdef.username = "";

		if (loginResponse.getStatusCode() == HttpStatus.OK) {
			String jstring = loginResponse.getBody();
			try {
				LoginResponseModel logResp = mapper.readValue(jstring, LoginResponseModel.class);
				if (logResp.status = true) {
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

//