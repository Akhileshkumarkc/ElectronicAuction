package org.arrow.webservicelayer.controller;

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

import java.io.IOException;

import org.arrow.webservicelayer.MicroServiceCall.MicroServiceCallWrapper;
import org.arrow.webservicelayer.MicroServiceCall.MicroServiceWebServiceActions;
import org.arrow.webservicelayer.WebServiceCall.WebServicesActions;
import org.arrow.webservicelayer.model.AuctionResponseModel;
import org.arrow.webservicelayer.model.BidParamModel;
import org.arrow.webservicelayer.model.LoginResponseModel;

@RestController
@RequestMapping(WebServicesActions.BIDSERVICE)
public class BidController {
	
	@RequestMapping(value=WebServicesActions.Allbids,
			method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody boolean fetchAllBidsForItem(@RequestBody BidParamModel model){
		
		return true;
	}
	
	@RequestMapping(value=WebServicesActions.mybids,
			method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody boolean fetchAllMyBids(
			@RequestBody  BidParamModel model){
		return true;
	}
	
		
	@RequestMapping(value=WebServicesActions.foritem,
			method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody AuctionResponseModel bid(
			@RequestBody BidParamModel model){
		
		ObjectMapper mapper = new ObjectMapper();
		String jString = null;
		try {
			jString = mapper.writeValueAsString(model);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		//Make a webservice call to check user validity with login informationre.			
		String actionUrl = MicroServiceWebServiceActions.bidforitem;
		MicroServiceCallWrapper MSC = new MicroServiceCallWrapper();
		ResponseEntity<String> loginResponse = MSC.call(actionUrl, jString);
		AuctionResponseModel armdef = new AuctionResponseModel();
        ////
		//default response model.
		String jstring;
		if(loginResponse.getStatusCode() == HttpStatus.OK){
			jstring = loginResponse.getBody();
		try {
			AuctionResponseModel arm = mapper.readValue(jstring, AuctionResponseModel.class);
			if(arm.getResponseStatus() == true){
			 System.out.println("succesful"); 
			 armdef = arm;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Json cast Problem");
			}
		}
		return armdef;

	}
	
	@RequestMapping(value=WebServicesActions.delete,
			method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody boolean deleteBid(
			@RequestBody BidParamModel BidParam
			){
		
		//TODO:mapping
				return true;
	}
	
}
