package org.arrow.micro.login.controller;

import java.util.ArrayList;

import org.arrow.micro.login.model.LoginModel;
import org.arrow.micro.login.service.LoginService;
import org.arrow.micro.login.service.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javassist.expr.NewArray;

import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("loginservice")
public class LoginController {
	
	@Autowired
	private LoginService loginService;	
	
	@RequestMapping(value="/authenicate",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody boolean loginAuthenitcate(@RequestBody LoginModel model){
		LoginModel dbLoginModel =loginService.getLogin(model.getUserName());
		boolean authenicated = false;
		if(dbLoginModel != null){
			if(model.getPassword().equals(dbLoginModel.getPassword())){
				authenicated = true;
			}
		}
		return authenicated;
	}
	
	@RequestMapping(value="/time/1",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody LoginModel sample2(){
		System.out.println("entered");
		LoginModel lm = new LoginModel();
		lm.setUserId(1);
		lm.setUserName("akhilesh");
		return lm;
		
	}
	
}
