package org.arrow.micro.controller;

import org.arrow.micro.WebServiceCall.MicroWebServicesActions;
import org.arrow.micro.model.LoginModel;
import org.arrow.micro.service.BidServiceImpl;
import org.arrow.micro.simple.model.AuctionResponseModel;
import org.arrow.micro.simple.model.BidParamModel;
import org.arrow.micro.simple.model.BidResponseModel;
import org.arrow.micro.simple.model.SimpleAuctionListResponseModel;
import org.arrow.micro.simple.model.SimpleUserModel;
import org.arrow.micro.simple.model.UserRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(MicroWebServicesActions.BIDSERVICE)
public class BidController {
	@Autowired
	private BidServiceImpl BidService;	
	
	@RequestMapping(value=MicroWebServicesActions.Allbids,
			method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
		public  @ResponseBody SimpleAuctionListResponseModel fetchAllBidsForItem(
				@RequestBody UserRequestModel model){
			//BidService.bid(model, arm);
		//TODO:
		return new SimpleAuctionListResponseModel();
			
		
	}
	
	@RequestMapping(value=MicroWebServicesActions.mybids,
			method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody boolean fetchAllMyBids(
			@RequestBody  BidParamModel model){
		
		//TODO:mapping
		return true;
	}
	
		
	@RequestMapping(value=MicroWebServicesActions.foritem,
			method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody AuctionResponseModel bid(
			@RequestBody BidParamModel model){
		
		AuctionResponseModel arm = new AuctionResponseModel();
		BidService.bid(model,arm);
		
		return arm;
	}
	
	@RequestMapping(value=MicroWebServicesActions.delete,
			method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody boolean deleteBid(
		//	@RequestBody UserDetailsModel userDetails 
			@RequestBody BidParamModel BidParam
			){
		
		//TODO:mapping
				return true;
	}
	
}
