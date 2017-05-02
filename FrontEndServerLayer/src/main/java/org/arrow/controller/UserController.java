package org.arrow.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.arrow.WebServiceCall.WebServiceCallWrapper;
import org.arrow.WebServiceCall.WebServicesActions;
import org.arrow.authenticate.SessionManagement;
import org.arrow.beans.UserRequestModel;
import org.arrow.model.LoginResponseModel;
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

	@RequestMapping(value = "/createnewauction", method = RequestMethod.GET)
	public String createnewauction(ModelMap model) {
		System.out.println("entered new auction page");
		return "newauction";
	}
	
	@RequestMapping(value = "/profileview", method = RequestMethod.GET)
	public String profileview(HttpServletRequest req, ModelMap model) {
		System.out.println("entered profile view page");
		//get user request name.
		UserRequestModel urm = new UserRequestModel();
		urm.setUserName((String)req.getSession().getAttribute(SessionManagement.SessionUSER));
		urm.setUserid((Integer)req.getSession().getAttribute(SessionManagement.SessionUserId));

		SimpleUserModel sum = new SimpleUserModel();
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
							 SessionManagement.createSessionLastlogin(req, sum);
							 System.out.println("last login  : "+req.getSession().getAttribute(SessionManagement.Lastlogin));
							 model.addAttribute("lastLogin", req.getSession().getAttribute(SessionManagement.Lastlogin));
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
	
	@RequestMapping(value = "/profileedit", method = RequestMethod.POST)
	public String profileedit(HttpServletRequest request, ModelMap model) {
		System.out.println("entered new auction page");
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
		simpleusermodel.setUserId((Integer)request.getSession().getAttribute(SessionManagement.SessionUserId));
		
		LoginResponseModel logRespdef = new LoginResponseModel();
		logRespdef.setErrorMessage("not succesful");
		logRespdef.setStatus(false);
		logRespdef.setUserid((Integer)request.getSession().getAttribute(SessionManagement.SessionUserId));
		logRespdef.setUsername((String)request.getSession().getAttribute(SessionManagement.SessionUSER));
	
		try {

			// convert it to jString.
			ObjectMapper mapper = new ObjectMapper();
			//hack : set dummy username and password.
			String jString = mapper.writeValueAsString(simpleusermodel);

			// Make a webservice call to check user validity with login
			// information.
			String actionUrl = WebServicesActions.userprofiledit;
			WebServiceCallWrapper WSC = new WebServiceCallWrapper();
			
			ResponseEntity<String> loginResponse = WSC.call(actionUrl, jString);
			if (loginResponse.getStatusCode() == HttpStatus.OK) {
				String jstring = loginResponse.getBody();
				try {
					 LoginResponseModel logResp = mapper.readValue(jstring, LoginResponseModel.class);
					if(logResp.status= true){
					 System.out.println("successful"); 
					 logRespdef = logResp;
					 model.addAttribute("userDetails", simpleusermodel);
					 model.addAttribute("ERR_MSG", "Updated Profile Details");
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
		
		return "userinfo";
	}
	
	@RequestMapping(value = "/editdetails", method = RequestMethod.GET)
	public String detailsforprofileedit(HttpServletRequest req, ModelMap model) {
		System.out.println("entered edit deatils controller");
		UserRequestModel urm = new UserRequestModel();
		urm.setUserName((String)req.getSession().getAttribute(SessionManagement.SessionUSER));
		urm.setUserid((Integer)req.getSession().getAttribute(SessionManagement.SessionUserId));
		SimpleUserModel sum = new SimpleUserModel();
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
							 model.addAttribute("userDetails", sum);
							 System.out.println(sum.getFirstName());
							 return "profileedit";
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

		return "profileedit";
	}
	

}
