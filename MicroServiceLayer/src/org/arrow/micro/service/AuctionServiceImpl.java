package org.arrow.micro.service;

import java.util.List;

import org.arrow.micro.dao.AuctionDaoImpl;
import org.arrow.micro.dao.LoginDaoImpl;
import org.arrow.micro.model.AuctionEventModel;
import org.arrow.micro.model.LoginModel;
import org.arrow.micro.simple.model.AuctionResponseModel;
import org.arrow.micro.simple.model.SimpleAuctionRequestModel;
import org.arrow.micro.simple.model.SimpleToDBModelConverter;
import org.arrow.micro.simple.model.UserRequestModel;
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
	
	public boolean closeAuction(int auctionid){
		AuctionEventModel aem = auctionDao.getAuctionById(auctionid);
		return false;
	}
	
	public List<AuctionEventModel> getAllMyAuctions(UserRequestModel userModel){
		 
		 List<AuctionEventModel> sarm = auctionDao.getAllMyAuctions(userModel);

		 return sarm;
	}
//	public List<UserRequestModel> getMyAuctions(UserRequestModel userModel){
//		
//	}
	
	public List<AuctionEventModel> getAllAvailAuctions(UserRequestModel userModel){
		 
		 List<AuctionEventModel> sarm = auctionDao.getAvailableAuctions(userModel);

		 return sarm;
		 
		
		
	}

	public List<AuctionEventModel> getAllAuctions(UserRequestModel userModel) {
		
		List<AuctionEventModel> sarm = auctionDao.getAllMyAuctions(userModel);

		 return sarm;

	
	}

}
