package org.arrow.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.arrow.WebServiceCall.WebServiceCallWrapper;
import org.arrow.WebServiceCall.WebServicesActions;
import org.arrow.authenticate.SessionManagement;
import org.arrow.beans.UserRequestModel;
import org.arrow.model.SimpleUserModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class UserController {

//	@RequestMapping(value = "/createnewauction", method = RequestMethod.GET)
//	public String createnewauction(ModelMap model) {
//		System.out.println("entered new auction page");
//		return "newauction";
//	}
	
	
	@RequestMapping(value = "/profileview", method = RequestMethod.GET)
	public String profileview(HttpServletRequest req, ModelMap model) {
		System.out.println("entered profile view page");
		//get user request name.
		UserRequestModel urm = new UserRequestModel();
		urm.setUserName((String)req.getSession().getAttribute(SessionManagement.SessionUSER));
		urm.setUserid((Integer)req.getSession().getAttribute(SessionManagement.SessionUserId));

		SimpleUserModel sum = new SimpleUserModel();
		//TODO: copy the value of the form in html
		//to sum.
		
		// web service call
		try {

			// convert it to jString.
			ObjectMapper mapper = new ObjectMapper();
			String jString = mapper.writeValueAsString(urm);

					// Make a webservice call to check user validity with login
					// information.
					String actionUrl = WebServicesActions.userprofileview;
					WebServiceCallWrapper WSC = new WebServiceCallWrapper();
					
					
					
					ResponseEntity<String> loginResponse = WSC.call(actionUrl, jString);
					if (loginResponse.getStatusCode() == HttpStatus.OK) {
						String jstring = loginResponse.getBody();
						try {
							 sum = mapper.readValue(jstring, SimpleUserModel.class);
							 model.addObject("userDetails", sum);
							}
						 catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							System.out.println("Json cast Problem");
						}

					}
				} catch (Exception e) {
					e.printStackTrace();
				}

		return "userinfo";
	}
	
}
