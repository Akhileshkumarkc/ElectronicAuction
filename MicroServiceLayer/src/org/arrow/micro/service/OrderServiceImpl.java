package org.arrow.micro.service;

import org.arrow.micro.dao.OrderDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderServiceImpl {
	@Autowired
	private OrderDaoImpl auctionDao;
}
