package org.arrow.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.arrow.WebServiceCall.WebServiceCallWrapper;
import org.arrow.WebServiceCall.WebServicesActions;
import org.arrow.authenticate.SessionManagement;
import org.arrow.model.AuctionResponseModel;
import org.arrow.model.LoginResponseModel;
import org.arrow.model.SimpleAuctionRequestModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class AuctionController {

	@RequestMapping(value = "/newauction", method = RequestMethod.POST)
	public String newauction(HttpServletRequest req, ModelMap model) throws ParseException {
		System.out.println("new auction posted");
		
		SimpleAuctionRequestModel sarm = new SimpleAuctionRequestModel();
		sarm.setUserName((String)req.getSession().getAttribute(SessionManagement.SessionUSER));
		String date = req.getParameter("actualEndDate");
		DateFormat dt = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
		Date date1 = dt.parse(date);
		sarm.setAcutalEndDate(date1);
		sarm.setProductName(req.getParameter("productName"));
		sarm.setProductDescription(req.getParameter("productDescription"));
		sarm.setStartingBid(Double.parseDouble(req.getParameter("startingBid")));
		sarm.setImageURL(req.getParameter("imageURL"));
		sarm.setCategory(req.getParameter("category"));
		
		
		AuctionResponseModel logRespdef = new AuctionResponseModel();
		logRespdef.setErrorMessage("not succesful");
		logRespdef.setResponseStatus(false);
		logRespdef.setUserid(0);
	
		try {

			// convert it to jString.
			ObjectMapper mapper = new ObjectMapper();
			//hack : set dummy username and password.
			String jString = mapper.writeValueAsString(sarm);

			// Make a webservice call to check user validity with login
			// information.
			String actionUrl = WebServicesActions.createAuction;
			WebServiceCallWrapper WSC = new WebServiceCallWrapper();
			
			ResponseEntity<String> loginResponse = WSC.call(actionUrl, jString);
			if (loginResponse.getStatusCode() == HttpStatus.OK) {
				String jstring = loginResponse.getBody();
				try {
					 AuctionResponseModel AucResp = mapper.readValue(jstring, AuctionResponseModel.class);
					if(AucResp.getResponseStatus()==true ){
					 System.out.println("successful"); 
					 logRespdef = AucResp;
					 
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
		
		if (logRespdef.getResponseStatus() == true) {
			model.addAttribute("ERR_MSG", "Item Created");
			return "homepage";
		}
		else{	
			model.addAttribute("ERR_MSG", logRespdef.getErrorMessage());	
			System.out.println("error registering");
		}
		return "registration_error";
	}
	
	
	
	@RequestMapping(value = "/availablebids", method = RequestMethod.GET)
	public String availablebids(ModelMap model) {
		System.out.println("entered Registration page");
		return "products";
	}
}
