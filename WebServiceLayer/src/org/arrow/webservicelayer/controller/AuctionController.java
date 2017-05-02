package org.arrow.webservicelayer.controller;


import java.io.IOException;


import org.arrow.webservicelayer.MicroServiceCall.MicroServiceCallWrapper;
import org.arrow.webservicelayer.MicroServiceCall.MicroServiceWebServiceActions;
import org.arrow.webservicelayer.WebServiceCall.WebServicesActions;
import org.arrow.webservicelayer.model.AuctionResponseModel;
import org.arrow.webservicelayer.model.SimpleAuctionListResponseModel;
import org.arrow.webservicelayer.model.SimpleAuctionParamModel;
import org.arrow.webservicelayer.model.SimpleAuctionRequestModel;
import org.arrow.webservicelayer.model.UserRequestModel;
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
@RequestMapping(WebServicesActions.AUCTIONSERVICE)
public class AuctionController {
	
	@RequestMapping(value=WebServicesActions.create,
			method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody AuctionResponseModel AuctionCreate(@RequestBody SimpleAuctionRequestModel model){
		
		
		//
		ObjectMapper mapper = new ObjectMapper();
		String jString = null;
		try {
			jString = mapper.writeValueAsString(model);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Make a webservice call to check user validity with login information.			
		String actionUrl = MicroServiceWebServiceActions.createAuction;
		// Make a webservice call to check user validity with login
		// informationre.
		MicroServiceCallWrapper MSC = new MicroServiceCallWrapper();
		ResponseEntity<String> userResponse = MSC.call(actionUrl, jString);

		// default response model.
		AuctionResponseModel armd = new AuctionResponseModel();

		if (userResponse.getStatusCode() == HttpStatus.OK) {
			String jstring = userResponse.getBody();
			try {
				AuctionResponseModel arm = mapper.readValue(jstring, AuctionResponseModel.class);
				System.out.println("succesful");
				armd = arm;

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Json cast Problem");
			}

		}
		return armd;
		
	}
	
	@RequestMapping(value=WebServicesActions.AllAvial,
			method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody SimpleAuctionListResponseModel AllAvaialbleAuctions(
			@RequestBody UserRequestModel model){
		
		ObjectMapper mapper = new ObjectMapper();
		String jString = null;
		try {
			jString = mapper.writeValueAsString(model);
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
	@RequestMapping(value=WebServicesActions.AllMyActive,
			method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody SimpleAuctionListResponseModel AllMyAuctions(
			@RequestBody UserRequestModel model){
		
		ObjectMapper mapper = new ObjectMapper();
		String jString = null;
		try {
			jString = mapper.writeValueAsString(model);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Make a webservice call to check user validity with login information.			
		String actionUrl = MicroServiceWebServiceActions.AllMyActiveAuctions;
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
	
	@RequestMapping(value=WebServicesActions.All,
			method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody SimpleAuctionListResponseModel AllAuctions(
			@RequestBody UserRequestModel model){
		
		ObjectMapper mapper = new ObjectMapper();
		String jString = null;
		try {
			jString = mapper.writeValueAsString(model);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Make a webservice call to check user validity with login information.			
		String actionUrl = MicroServiceWebServiceActions.AllAuctions;
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

	@RequestMapping(value=WebServicesActions.Close,
			method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody boolean closeAuction(
			@RequestBody SimpleAuctionParamModel auctionParamModel
			){
		boolean status = false;
		ObjectMapper mapper = new ObjectMapper();
		String jString = null;
		try {
			jString = mapper.writeValueAsString(auctionParamModel);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Make a webservice call to check user validity with login information.			
		String actionUrl = MicroServiceWebServiceActions.CloseMyAuction;
		// Make a webservice call to check user validity with login
		// informationre.
		MicroServiceCallWrapper MSC = new MicroServiceCallWrapper();
		ResponseEntity<String> userResponse = MSC.call(actionUrl, jString);
		
	
		return true;
		
	}

}
