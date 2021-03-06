package org.arrow.micro.controller;



import org.arrow.micro.WebServiceCall.MicroWebServicesActions;
import org.arrow.micro.exception.ApplicationException;
import org.arrow.micro.exception.ErrorMessageConstants;
import org.arrow.micro.model.LoginModel;
import org.arrow.micro.model.UserDetailsModel;
import org.arrow.micro.service.LoginServiceImpl;
import org.arrow.micro.simple.model.LoginResponseModel;
import org.arrow.micro.simple.model.SimpleToDBModelConverter;
import org.arrow.micro.simple.model.SimpleUserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(MicroWebServicesActions.LOGINSERVICE)
public class LoginController {
	
	@Autowired
	private LoginServiceImpl loginService;	
	
	@RequestMapping(value=MicroWebServicesActions.authenicate,
			method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody LoginResponseModel loginAuthenitcate(@RequestBody LoginModel model){
		System.out.println("entered");
		
		LoginResponseModel lr = new LoginResponseModel();
		lr.status = false;
		lr.userid = 0;
		lr.username = "";
		lr.ErrorMessage = "Error reterving the message";

		LoginModel dbLoginModel =loginService.getLogin(model.getUserName());
		if(dbLoginModel != null){
		
			if(model.getPassword().equals(dbLoginModel.getPassword())){
				lr.status = true;
				lr.setUserid(dbLoginModel.getUserId());
				lr.setUsername(dbLoginModel.getUserName());
				lr.ErrorMessage = "";
				lr.status = true;
				//save the time()
				loginService.updateLastLogin(dbLoginModel);
			}
		}
		return lr;
		
	}
	
	@RequestMapping(value=MicroWebServicesActions.Register,
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody LoginResponseModel register(
			@RequestBody SimpleUserModel userModel
			){
		
		LoginResponseModel lr = new LoginResponseModel();
		lr.status = false;
		lr.userid = 0;
		lr.username = "";
		lr.ErrorMessage = "Error reterving the message";
		
		System.out.println("enteredregister");
		
		UserDetailsModel userDetailModel = SimpleToDBModelConverter.ConvertToUserDetailsModel(userModel);
		
		try {
			lr = loginService.register(userDetailModel,lr);
		} catch (Exception e) {
			lr.ErrorMessage = "Problem with registration try again!";
			return lr;
		}
		
		
		return lr;
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
