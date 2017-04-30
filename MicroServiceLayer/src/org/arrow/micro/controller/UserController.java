package org.arrow.micro.controller;

import org.arrow.micro.model.LoginModel;
import org.arrow.micro.model.UserDetailsModel;
import org.arrow.micro.service.LoginServiceImpl;
import org.arrow.micro.service.UserServiceImpl;
import org.arrow.micro.simple.model.LoginResponseModel;
import org.arrow.micro.simple.model.SimpleToDBModelConverter;
import org.arrow.micro.simple.model.SimpleUserModel;
import org.arrow.micro.simple.model.UserRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.arrow.micro.WebServiceCall.MicroWebServicesActions;

@RestController
@RequestMapping(MicroWebServicesActions.USERSERVICE)
public class UserController {
	@Autowired
	private UserServiceImpl userService;	
	
	@RequestMapping(value=MicroWebServicesActions.profileview,
			method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody SimpleUserModel viewProfile(@RequestBody UserRequestModel model){
		  
		SimpleUserModel   sum =  userService.getUserDetails(model.getUserid());
		return sum;

		
	}
	
	@RequestMapping(value=MicroWebServicesActions.profiledit,
			method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody LoginResponseModel UpdateProfile(
			@RequestBody SimpleUserModel userModel
			){
			
		LoginResponseModel lr = new LoginResponseModel();
		lr.status = false;
		lr.userid = 0;
		lr.username = "";
		lr.ErrorMessage = "Error reterving the message";
			
		return userService.updateUserDetails(userModel,lr);
		
	}

	@RequestMapping(value="/time/1",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody LoginModel sample2(){
		
		System.out.println("entered");
		LoginModel lm = new LoginModel();
		lm.setUserName("akhilesh");
		return lm;
		
	}
	
	public static void main(String args[]){
		test();
	}
	
	public static void test(){
		System.out.println("hi");
		
		
	}

}
