package org.arrow.micro.service;

import org.arrow.micro.dao.BidDaoImpl;
import org.arrow.micro.simple.model.BidParamModel;
import org.arrow.micro.simple.model.BidResponseModel;
import org.springframework.beans.factory.annotation.Autowired;

public class BidServiceImpl {
	@Autowired
	private BidDaoImpl BidDao;

	public void bid(BidParamModel model, BidResponseModel brm) {
		
		//model.
		
	}

}
