package org.arrow.micro.controller;

import org.arrow.micro.WebServiceCall.MicroWebServicesActions;
import org.arrow.micro.model.LoginModel;
import org.arrow.micro.model.PurchasedItemModel;
import org.arrow.micro.service.AuctionServiceImpl;
import org.arrow.micro.service.OrderServiceImpl;
import org.arrow.micro.simple.model.SimpleAuctionListResponseModel;
import org.arrow.micro.simple.model.UserRequestModel;
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
	private OrderServiceImpl orderDaoImpl;
	
	@RequestMapping(value=MicroWebServicesActions.myOrders,
			method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody SimpleAuctionListResponseModel order(@RequestBody UserRequestModel UserModel){
		SimpleAuctionListResponseModel salr = new SimpleAuctionListResponseModel();
		salr.setStatus(false);
		salr.setErrorMessage("unable get orders");
		return orderDaoImpl.getorders(UserModel,salr);
		
		
		
	}

}
