package org.arrow.micro.service;

import org.arrow.micro.dao.BidDaoImpl;
import org.arrow.micro.simple.model.SimpleAuctionListResponseModel;
import org.arrow.micro.simple.model.UserRequestModel;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderServiceImpl {
	
	@Autowired
	private BidDaoImpl bidDao;

	public SimpleAuctionListResponseModel getorders(UserRequestModel model, SimpleAuctionListResponseModel sALR) {
		// TODO Auto-generated method stub
		
		return  bidDao.getorders(model, sALR);

	}

	public SimpleAuctionListResponseModel getCarts(UserRequestModel userModel, SimpleAuctionListResponseModel salr) {
		// TODO Auto-generated method stub
		return bidDao.getCarts(userModel, salr);
	}
}
