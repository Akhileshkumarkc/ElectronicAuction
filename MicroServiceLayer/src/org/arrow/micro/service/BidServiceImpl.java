package org.arrow.micro.service;

import org.arrow.micro.dao.AuctionDaoImpl;
import org.arrow.micro.dao.BidDaoImpl;
import org.arrow.micro.dao.LoginDaoImpl;
import org.arrow.micro.model.AuctionEventModel;
import org.arrow.micro.model.LoginModel;
import org.arrow.micro.simple.model.BidParamModel;
import org.arrow.micro.simple.model.BidResponseModel;
import org.springframework.beans.factory.annotation.Autowired;

public class BidServiceImpl {
	@Autowired
	private BidDaoImpl bidDao;
	@Autowired
	private AuctionDaoImpl auctionDao;
	@Autowired
	private LoginDaoImpl loginDao;

	public void bid(BidParamModel model, BidResponseModel brm) {
		//get the auctionid.
		
		AuctionEventModel aem = auctionDao.getAuctionById(model.getAuctionId());
	//	LoginModel lm = loginDao.getLogin(model.getAuctionId());
	//	aem.addBidModel(bm);
		//aem.
		//LoginModel lm = loginDao.getLogin(loginName)
		//create a new bid.with userid
		//add ito the auction.
		int auctionId;
		int userId;
		Double bidvalue;
		
	}

}
