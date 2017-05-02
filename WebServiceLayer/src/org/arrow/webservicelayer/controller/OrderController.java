package org.arrow.webservicelayer.controller;

import java.io.IOException;

import org.arrow.webservicelayer.MicroServiceCall.MicroServiceCallWrapper;
import org.arrow.webservicelayer.MicroServiceCall.MicroServiceWebServiceActions;
import org.arrow.webservicelayer.WebServiceCall.WebServicesActions;
import org.arrow.webservicelayer.model.AuctionResponseModel;
import org.arrow.webservicelayer.model.SimpleAuctionListResponseModel;
import org.arrow.webservicelayer.model.UserRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping(WebServicesActions.ORDERSERVICE)
public class OrderController {
	
	
	
	@RequestMapping(value=WebServicesActions.myOrders,
			method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody SimpleAuctionListResponseModel order(@RequestBody UserRequestModel UserModel){
		
		ObjectMapper mapper = new ObjectMapper();
		String jString = null;
		try {
			jString = mapper.writeValueAsString(UserModel);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Make a webservice call to check user validity with login information.			
		String actionUrl = MicroServiceWebServiceActions.AllAvialAuctions;
		// Make a webservice call to check user validity with login
		// informationre.
		MicroServiceCallWrapper MSC = new MicroServiceCallWrapper();
		ResponseEntity<String> userResponse = MSC.call(actionUrl, jString);
		
		SimpleAuctionListResponseModel salrmdef = new SimpleAuctionListResponseModel();
		salrmdef.setErrorMessage("failed");
		salrmdef.setStatus(false);
		// default response model.
		

		if (userResponse.getStatusCode() == HttpStatus.OK) {
			String jstring = userResponse.getBody();
			try {
				SimpleAuctionListResponseModel salrm = mapper.readValue(jstring, SimpleAuctionListResponseModel.class);
				System.out.println("succesful");
				salrmdef = salrm;

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Json cast Problem");
			}

		}
		return salrmdef;
	}
		
		
}

