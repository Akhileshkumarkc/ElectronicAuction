package org.arrow.micro.service;

import org.arrow.micro.dao.AuctionDaoImpl;
import org.arrow.micro.dao.LoginDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class AuctionServiceImpl {
	@Autowired
	private AuctionDaoImpl auctionDao;

}
