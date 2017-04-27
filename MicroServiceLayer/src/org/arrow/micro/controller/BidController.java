package org.arrow.micro.controller;

import org.arrow.micro.WebServiceCall.MicroWebServicesActions;
import org.arrow.micro.model.LoginModel;
import org.arrow.micro.service.BidServiceImpl;
import org.arrow.micro.simple.model.SimpleUserModel;
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
	
	@RequestMapping(value=MicroWebServicesActions.mybids,
			method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody boolean register4(
			@RequestBody LoginModel model){
		
		//TODO:mapping
		return true;
	}
	
		
	@RequestMapping(value=MicroWebServicesActions.foritem,
			method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody boolean register2(
			@RequestBody LoginModel model){
		
		//TODO:mapping
		return true;
	}
	
	@RequestMapping(value=MicroWebServicesActions.delete,
			method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody boolean register3(
		//	@RequestBody UserDetailsModel userDetails 
			@RequestBody SimpleUserModel userModel
			){
		
		//TODO:mapping
				return true;
	}
	
}
