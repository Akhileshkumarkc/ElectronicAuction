package org.arrow.micro.controller;

import org.arrow.micro.model.AuctionEventModel;
import org.arrow.micro.service.AuctionServiceImpl;
import org.arrow.micro.simple.model.AuctionResponseModel;
import org.arrow.micro.simple.model.SimpleAuctionListResponseModel;
import org.arrow.micro.simple.model.SimpleAuctionParamModel;
import org.arrow.micro.simple.model.SimpleAuctionRequestModel;
import org.arrow.micro.simple.model.SimpleAuctionResponseModel;
import org.arrow.micro.simple.model.SimpleUserModel;
import org.arrow.micro.simple.model.UserRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.arrow.micro.WebServiceCall.MicroWebServicesActions;

@RestController
@RequestMapping(MicroWebServicesActions.AUCTIONSERVICE)
public class AuctionController {
	//Auction
	
	@Autowired
	private AuctionServiceImpl AuctionService;	
	
	@RequestMapping(value=MicroWebServicesActions.create,
			method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody AuctionResponseModel AuctionCreate(@RequestBody SimpleAuctionRequestModel model){
		
		AuctionResponseModel defaultArm = new AuctionResponseModel();
		AuctionService.createAuction(model,defaultArm);
		return defaultArm;   
		
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
	public  @ResponseBody SimpleAuctionListResponseModel AllAvaialbleAuctions(
			@RequestBody UserRequestModel UserModel){
		//TODO: 
		List<AuctionEventModel> aemlist = new ArrayList<AuctionEventModel>();
		
		aemlist = AuctionService.getAllAvailAuctions(UserModel);
		//def
		SimpleAuctionListResponseModel salrm = new SimpleAuctionListResponseModel();
		salrm.setErrorMessage("failed");
		salrm.setStatus(false);
		
		List<SimpleAuctionResponseModel> ARMList = new ArrayList<SimpleAuctionResponseModel>();
		if(aemlist == null){
			return salrm;
		}
		else{
			for(int i = 0;i < aemlist.size(); i++){
				AuctionEventModel aem = aemlist.get(i);
				SimpleAuctionResponseModel sarm = new SimpleAuctionResponseModel();
				sarm.setUserName(aem.getOwner().getUserName());
				sarm.setAcutalEndDate(aem.getScheduledEndDate());
				sarm.setProductName(aem.getName());
				sarm.setProductDescription(aem.getDescription());
				sarm.setStartingBid(aem.getStartingBid());
				sarm.setImageURL(aem.getImageURL());
				sarm.setCategory(aem.getCategory());
				
				ARMList.add(sarm);
			}
			salrm.setErrorMessage("successful");
			salrm.setStatus(true);
			salrm.setSARM(ARMList);
		}
		
		
		
		return salrm;
	}
	
	@RequestMapping(value=MicroWebServicesActions.AllMy,
			method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody SimpleAuctionListResponseModel AllMyAuctions(
			@RequestBody UserRequestModel UserModel){
		//TODO: 
		List<AuctionEventModel> aemlist = new ArrayList<AuctionEventModel>();
		
		aemlist = AuctionService.getAllMyAuctions(UserModel);
		//def
		SimpleAuctionListResponseModel salrm = new SimpleAuctionListResponseModel();
		salrm.setErrorMessage("failed");
		salrm.setStatus(false);
		
		List<SimpleAuctionResponseModel> ARMList = new ArrayList<SimpleAuctionResponseModel>();
		if(aemlist == null){
			return salrm;
		}
		else{
			for(int i = 0;i < aemlist.size(); i++){
				AuctionEventModel aem = aemlist.get(i);
				SimpleAuctionResponseModel sarm = new SimpleAuctionResponseModel();
				sarm.setUserName(aem.getOwner().getUserName());
				sarm.setAcutalEndDate(aem.getScheduledEndDate());
				sarm.setProductName(aem.getName());
				sarm.setProductDescription(aem.getDescription());
				sarm.setStartingBid(aem.getStartingBid());
				sarm.setImageURL(aem.getImageURL());
				sarm.setCategory(aem.getCategory());
				
				ARMList.add(sarm);
			}
			salrm.setErrorMessage("successful");
			salrm.setStatus(true);
			salrm.setSARM(ARMList);
		}
		
		
		
		return salrm;
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
			@RequestBody SimpleAuctionParamModel auctionParamModel
			){
		
			return AuctionService.closeAuction(auctionParamModel.getAuctionid());
		
	}
	

}
