package org.arrow.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.arrow.WebServiceCall.WebServiceCallWrapper;
import org.arrow.WebServiceCall.WebServicesActions;
import org.arrow.authenticate.SessionManagement;
import org.arrow.beans.LoginBean;
import org.arrow.beans.UserRequestModel;
import org.arrow.model.LoginResponseModel;
import org.arrow.model.SimpleUserModel;
import org.arrow.model.UserDetails;
//import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class LoginController {


	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String landingPage(ModelMap model) {
		System.out.println("entered login page");
		return "loginpage";
	}
	
	
	@RequestMapping(value = "/newuserlogin", method = RequestMethod.GET)
	public String newuserloginPage(ModelMap model) {
		System.out.println("new user login page");
		return "loginpage";
	}
	
	@RequestMapping(value = "/newuserregistration", method = RequestMethod.GET)
	public String newuserregistrationPage(ModelMap model) {
		System.out.println("new user registration page");
		return "registration";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, ModelMap model) {

		LoginBean bean = new LoginBean();
		bean.setuserName(request.getParameter("name"));
		bean.setPassword(request.getParameter("password"));
		request.setAttribute("bean", bean);
		
		//response model
		
		LoginResponseModel logRespdef = new LoginResponseModel();
		logRespdef.ErrorMessage ="not succesful";
		logRespdef.status = false;
		logRespdef.userid = 0;
		logRespdef.username ="";
	
		try {

			// convert it to jString.
			ObjectMapper mapper = new ObjectMapper();
			String jString = mapper.writeValueAsString(bean);

			// Make a webservice call to check user validity with login
			// information.
			String actionUrl = WebServicesActions.CheckUserValidity;
			WebServiceCallWrapper WSC = new WebServiceCallWrapper();
			
			
			
			ResponseEntity<String> loginResponse = WSC.call(actionUrl, jString);
			if (loginResponse.getStatusCode() == HttpStatus.OK) {
				String jstring = loginResponse.getBody();
				try {
					 LoginResponseModel logResp = mapper.readValue(jstring, LoginResponseModel.class);
					if(logResp.status= true){
					 System.out.println("succesful"); 
					 logRespdef = logResp;
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Json cast Problem");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		if (logRespdef.status == true) {
			if(logRespdef.username.equalsIgnoreCase(bean.getuserName())){
				SessionManagement.createSessionUser(request, bean,logRespdef.userid);	
				return "homepage";
			}
		}
		else{
			
			String message = "Couldnot find the user,Please register";
			//TODO: return this to the user.
		}
		return "/registration";
	}
	
	
	
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registerPage(ModelMap model) {
		System.out.println("entered Registration page");
		return "registration";
	}
	
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(HttpServletRequest request,ModelMap model){
		
		System.out.println("entered");
		SimpleUserModel simpleusermodel = new SimpleUserModel();
		simpleusermodel.setFirstName(request.getParameter("firstName"));
		simpleusermodel.setLastName(request.getParameter("lastName"));
		simpleusermodel.setCompany(request.getParameter("company"));
		simpleusermodel.setUsername(request.getParameter("username"));
		simpleusermodel.setPassword(request.getParameter("password"));
		simpleusermodel.setEmail(request.getParameter("email"));
		simpleusermodel.setPhoneNumber(request.getParameter("phoneNumber"));
		simpleusermodel.setUser_houseNumber(request.getParameter("user_houseNumber"));
		simpleusermodel.setUser_streetName(request.getParameter("user_streetName"));
		simpleusermodel.setUser_city(request.getParameter("user_city"));
		simpleusermodel.setUser_state(request.getParameter("user_state"));
		simpleusermodel.setUser_pinCode(request.getParameter("user_pinCode"));
		simpleusermodel.setShipping_houseNumber(request.getParameter("shipping_houseNumber"));
		simpleusermodel.setShipping_streetName(request.getParameter("shipping_streetName"));
		simpleusermodel.setShipping_city(request.getParameter("shipping_city"));
		simpleusermodel.setShipping_state(request.getParameter("shipping_state"));
		simpleusermodel.setShipping_pinCode(request.getParameter("shipping_pinCode"));
		
		if(simpleusermodel.getFirstName() == null || 
			simpleusermodel.getLastName() == null || 
			simpleusermodel.getUsername() == null ||
			simpleusermodel.getPassword() == null ||
			simpleusermodel.getEmail() == null || 
			simpleusermodel.getPhoneNumber() == null || 
			simpleusermodel.getUser_houseNumber() == null || 
			simpleusermodel.getUser_streetName() == null || 
			simpleusermodel.getUser_city() == null || 
			simpleusermodel.getUser_state() == null || 
			simpleusermodel.getUser_pinCode() == null){
			model.addAttribute("ERR_MSG", "Enter all fields correctly");
			return "registration_error";
		}
		System.out.println(simpleusermodel.getEmail()+"------"+simpleusermodel.getPhoneNumber()+"----");
		
		//webservice call if successful.
		LoginResponseModel logRespdef = new LoginResponseModel();
		logRespdef.ErrorMessage ="not succesful";
		logRespdef.status = false;
		logRespdef.userid = 0;
		logRespdef.username ="";
	
		try {

			// convert it to jString.
			ObjectMapper mapper = new ObjectMapper();
			//hack : set dummy username and password.
			String jString = mapper.writeValueAsString(simpleusermodel);

			// Make a webservice call to check user validity with login
			// information.
			String actionUrl = WebServicesActions.Register;
			WebServiceCallWrapper WSC = new WebServiceCallWrapper();
			
			ResponseEntity<String> loginResponse = WSC.call(actionUrl, jString);
			if (loginResponse.getStatusCode() == HttpStatus.OK) {
				String jstring = loginResponse.getBody();
				try {
					 LoginResponseModel logResp = mapper.readValue(jstring, LoginResponseModel.class);
					if(logResp.status= true){
					 System.out.println("successful"); 
					 logRespdef = logResp;
					 
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Json cast Problem");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// registration is succesful then redirect to loginpage.
		
		if (logRespdef.status == true) {
			return "loginpage";
		}
		else{	
			model.addAttribute("ERR_MSG", logRespdef.ErrorMessage);	
			System.out.println("error registering");
		}
		return "registration_error";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request,ModelMap model){
		SessionManagement sm = new SessionManagement();
		sm.logoutSessionUser(request.getSession());
		return "loginpage";
	}
	
	public static void main(String args[]) throws JsonProcessingException{
		LoginBean bean=new LoginBean();
		bean.setuserName("Akhilesh");
		bean.setPassword("kumar");
		
		Boolean status = true;
			ObjectMapper mapper = new ObjectMapper();
			String jString = mapper.writeValueAsString(bean);
			System.out.println(jString);
			//JSONObject jobj = new JSONObject(jString);
	
	}
}