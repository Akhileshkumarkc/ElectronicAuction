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
		
		LoginModel dbLoginModel =loginService.getLogin(model.getUserName());

		lr.status = false;
		lr.userid = 0;
		lr.username = "";
		lr.ErrorMessage = "Error reterving the message";
		
		if(dbLoginModel != null){
		
			if(model.getPassword().equals(dbLoginModel.getPassword())){
				lr.status = true;
				lr.setUserid(dbLoginModel.getUserId());
				lr.setUsername(dbLoginModel.getUserName());
				lr.ErrorMessage = "";
				lr.status = true;
			}
		}
		return lr;
		
	}
	
	@RequestMapping(value=MicroWebServicesActions.Register,
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody boolean register(
			@RequestBody SimpleUserModel userModel
			){
		
		System.out.println("enteredregister");
		UserDetailsModel userDetailModel = SimpleToDBModelConverter.ConvertToUserDetailsModel(userModel);
		boolean status;
		try {
			status = loginService.register(userDetailModel);
		} catch (Exception e) {
			ApplicationException ae = new ApplicationException(
					ErrorMessageConstants.UserAlreadyExists,
					ErrorMessageConstants.UserAlreadyExists_code);
			e.printStackTrace();
			return false;
		}
		
		
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
