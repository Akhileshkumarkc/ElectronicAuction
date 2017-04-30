package org.arrow.micro.service;

import org.arrow.micro.dao.AuctionDaoImpl;
import org.arrow.micro.dao.LoginDaoImpl;
import org.arrow.micro.model.AuctionEventModel;
import org.arrow.micro.model.LoginModel;
import org.arrow.micro.simple.model.AuctionResponseModel;
import org.arrow.micro.simple.model.SimpleAuctionRequestModel;
import org.arrow.micro.simple.model.SimpleToDBModelConverter;
import org.springframework.beans.factory.annotation.Autowired;

public class AuctionServiceImpl {
	@Autowired
	private AuctionDaoImpl auctionDao;
	@Autowired
	private LoginDaoImpl loginDao;

	public void createAuction(SimpleAuctionRequestModel model,AuctionResponseModel defaultArm) {
		AuctionEventModel aem = new AuctionEventModel();
		aem = SimpleToDBModelConverter.ConvertToAuctionModel(model);
		// add User id 
		LoginModel lm = loginDao.getLogin(model.getUserName());
		aem.setOwner(lm);
		auctionDao.create(aem,defaultArm);
	}
	
	public void closeAuction(int Auctionid){
		
	//	auctionDao.getAuction(Auctionid);
	}
	
	public void getAllAuctions(){
		
	}

}
