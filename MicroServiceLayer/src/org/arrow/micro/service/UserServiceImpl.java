package org.arrow.micro.service;

import org.arrow.micro.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl {
	@Autowired
	private UserDaoImpl userDao;
}
