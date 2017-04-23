package org.arrow.micro.controller;



import org.arrow.micro.model.LoginModel;
import org.arrow.micro.model.UserDetailsModel;
import org.arrow.micro.service.LoginServiceImpl;
import org.arrow.micro.simple.model.SimpleUserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("loginservice")
public class LoginController {
	
	@Autowired
	private LoginServiceImpl loginService;	
	
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
	
	@RequestMapping(value="/register",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody boolean register(
		//	@RequestBody UserDetailsModel userDetails 
			@RequestBody SimpleUserModel userModel
			){
		
		System.out.println("enteredregister");
		boolean status = true;
		//boolean status = loginService.Register(userDetails);
		return status;
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
