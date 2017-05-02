package org.arrow.micro.service;

import org.arrow.micro.dao.AuctionDaoImpl;
import org.arrow.micro.dao.BidDao;
import org.arrow.micro.dao.BidDaoImpl;
import org.arrow.micro.dao.LoginDaoImpl;
import org.arrow.micro.model.AuctionEventModel;
import org.arrow.micro.model.BidModel;
import org.arrow.micro.model.LoginModel;
import org.arrow.micro.simple.model.AuctionResponseModel;
import org.arrow.micro.simple.model.BidParamModel;
import org.arrow.micro.simple.model.BidResponseModel;
import org.arrow.micro.simple.model.SimpleAuctionListResponseModel;
import org.arrow.micro.simple.model.UserRequestModel;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

public class BidServiceImpl {
	@Autowired
	private BidDaoImpl bidDao;
	@Autowired
	private AuctionDaoImpl auctionDao;
	@Autowired
	private LoginDaoImpl loginDao;

	public void bid(BidParamModel model, AuctionResponseModel arm) {
		//get the auctionid.
				bidDao.update(model,arm);
	}

	public SimpleAuctionListResponseModel getbids(UserRequestModel model,SimpleAuctionListResponseModel SALR) {
			return bidDao.getbids(model,SALR);
		
	}

}
