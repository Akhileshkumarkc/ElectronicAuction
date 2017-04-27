package org.arrow.micro.controller;

import org.arrow.micro.WebServiceCall.MicroWebServicesActions;
import org.arrow.micro.model.LoginModel;
import org.arrow.micro.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(MicroWebServicesActions.ORDERSERVICE)
public class OrderController {
	
	@Autowired
	private OrderServiceImpl userService;
	
	@RequestMapping(value=MicroWebServicesActions.myOrders,
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

}
