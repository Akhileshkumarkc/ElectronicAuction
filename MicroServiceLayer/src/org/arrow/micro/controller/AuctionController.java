package org.arrow.micro.controller;

import org.arrow.micro.model.LoginModel;
import org.arrow.micro.model.UserDetailsModel;
import org.arrow.micro.service.AuctionServiceImpl;
import org.arrow.micro.service.LoginServiceImpl;
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
	public  @ResponseBody boolean loginAuthenitcate(@RequestBody LoginModel model){
		//TODO:mapping
		return true;
//		LoginModel dbLoginModel =loginService.getLogin(model.getUserName());
//		boolean authenicated = false;
//		
//		if(dbLoginModel != null){
//		
//			if(model.getPassword().equals(dbLoginModel.getPassword())){
//				authenicated = true;
//			}
//		}
//		return authenicated;
		
	}
	
	@RequestMapping(value=MicroWebServicesActions.update,
			method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody boolean register(
			@RequestBody LoginModel model){
		
		//TODO:mapping
		return true;
	}
	
	@RequestMapping(value=MicroWebServicesActions.AllAvial,
			method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody boolean register1(
			@RequestBody LoginModel model){
		
		//TODO:mapping
		return true;
	}
	
	@RequestMapping(value=MicroWebServicesActions.AllMy,
			method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody boolean register2(
			@RequestBody LoginModel model){
		
		//TODO:mapping
		return true;
	}
	
	@RequestMapping(value=MicroWebServicesActions.All,
			method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody boolean register3(
		//	@RequestBody UserDetailsModel userDetails 
			@RequestBody SimpleUserModel userModel
			){
		
		//TODO:mapping
				return true;
	}
	
	@RequestMapping(value=MicroWebServicesActions.Close,
			method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody boolean register4(
		//	@RequestBody UserDetailsModel userDetails 
			@RequestBody SimpleUserModel userModel
			){
		
		//TODO:mapping
				return true;
	}
	

}
