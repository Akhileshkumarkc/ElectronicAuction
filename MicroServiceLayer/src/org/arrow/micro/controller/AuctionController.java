package org.arrow.micro.controller;

import org.arrow.micro.model.AuctionEventModel;
import org.arrow.micro.model.LoginModel;
import org.arrow.micro.model.UserDetailsModel;
import org.arrow.micro.service.AuctionServiceImpl;
import org.arrow.micro.service.LoginServiceImpl;
import org.arrow.micro.simple.model.SimpleAuctionParamModel;
import org.arrow.micro.simple.model.SimpleToDBModelConverter;
import org.arrow.micro.simple.model.SimpleUserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.arrow.micro.WebServiceCall.MicroWebServicesActions;
@RestController
@RequestMapping(MicroWebServicesActions.AUCTIONSERVICE)
public class AuctionController {
	//Auction
	
	@Autowired
	private AuctionServiceImpl AuctionService;	
	
	@RequestMapping(value=MicroWebServicesActions.create,
			method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody boolean AuctionCreate(@RequestBody AuctionEventModel model){
		//TODO:mapping
		return true;
		
	}
	
	@RequestMapping(value=MicroWebServicesActions.update,
			method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody boolean update(
			@RequestBody AuctionEventModel model){
		
		//TODO:mapping
		return true;
	}
	
	@RequestMapping(value=MicroWebServicesActions.AllAvial,
			method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody boolean AllAvaialbleAuctions(
			@RequestBody SimpleAuctionParamModel auctionParammodel){
		
		//TODO:mapping
		return true;
	}
	
	@RequestMapping(value=MicroWebServicesActions.AllMy,
			method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody boolean AllMyAuctions(
			@RequestBody SimpleAuctionParamModel auctionParamModel){
		
		//TODO:mapping
		return true;
	}
	
	@RequestMapping(value=MicroWebServicesActions.All,
			method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody boolean AllAuctions(
		//	@RequestBody UserDetailsModel userDetails 
			@RequestBody SimpleAuctionParamModel auctionParamModel
			){
		
		//TODO:mapping
				return true;
	}
	
	@RequestMapping(value=MicroWebServicesActions.Close,
			method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody boolean closeAuction(
		//	@RequestBody UserDetailsModel userDetails 
			@RequestBody SimpleAuctionParamModel auctionParamModel
			){
		
		//TODO:mapping
				return true;
	}
	

}
