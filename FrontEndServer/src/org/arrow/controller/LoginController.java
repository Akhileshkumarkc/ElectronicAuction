package org.arrow.controller;

import javax.servlet.http.HttpServletRequest;

import org.arrow.WebServiceCall.WebServiceCallWrapper;
import org.arrow.WebServiceCall.WebServicesActions;
import org.arrow.beans.LoginBean;
import org.json.JSONObject;
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
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, ModelMap model) {

		LoginBean bean = new LoginBean();
		bean.setuserName(request.getParameter("name"));
		bean.setPassword(request.getParameter("password"));
		request.setAttribute("bean", bean);

		Boolean status = false;
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
				if (loginResponse.getBody().equalsIgnoreCase("true")) {
					status = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (status == true) {
			return "welcome-page.jsp";
		}
		return "login-error.jsp";
	}
	
	public static void main(String args[]) throws JsonProcessingException{
		LoginBean bean=new LoginBean();
		bean.setuserName("Akhilesh");
		bean.setPassword("kumar");
		
		Boolean status = true;
			ObjectMapper mapper = new ObjectMapper();
			String jString = mapper.writeValueAsString(bean);
			System.out.println(jString);
			JSONObject jobj = new JSONObject(jString);
	
	}
}