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
import org.arrow.beans.UserRequestModel;
import org.arrow.model.AuctionResponseModel;
import org.arrow.model.BidParamModel;
import org.arrow.model.SimpleAuctionListResponseModel;
import org.arrow.model.SimpleAuctionParamModel;
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
	
	@RequestMapping(value = "/productauction", method = RequestMethod.POST)
	public String profileedit(HttpServletRequest request, ModelMap model) {
		System.out.println("entered bid price page");
		model.addAttribute("auctionid", request.getParameter("auctionid"));
		model.addAttribute("bidprice1", request.getParameter("bidprice"));
		System.out.println("auction id productauction"+request.getParameter("auctionid"));
		System.out.println("bidprice productauction"+request.getParameter("bidprice"));

	return "bidprice";
	}
	
	@RequestMapping(value = "/sendprice", method = RequestMethod.POST)
	public String sendprice(HttpServletRequest request, ModelMap model) {
		System.out.println("entered new auction page");
		BidParamModel bpm = new BidParamModel();
		Double newprice = Double.parseDouble(request.getParameter("newprice"));
		Double oldprice = Double.parseDouble(request.getParameter("oldprice"));
		System.out.println("newprice : "+newprice);
		System.out.println("oldprice : "+oldprice);
		System.out.println("auction 2 :"+request.getParameter("auctionid"));
		System.out.println("session user:"+request.getSession().getAttribute(SessionManagement.SessionUSER));
		System.out.println("session user"+request.getSession().getAttribute(SessionManagement.SessionUserId));
		model.addAttribute("username", request.getSession().getAttribute(SessionManagement.SessionUSER));
		model.addAttribute("userId", request.getSession().getAttribute(SessionManagement.SessionUserId));
		model.addAttribute("auctionid", request.getParameter("auctionid"));
		if(newprice>oldprice){
			bpm.setUserName((String)request.getSession().getAttribute(SessionManagement.SessionUSER));
			bpm.setUserId((Integer)request.getSession().getAttribute(SessionManagement.SessionUserId));
			bpm.setAuctionId(Integer.parseInt(request.getParameter("auctionid")));
			bpm.setBidvalue(Double.parseDouble(request.getParameter("newprice")));
			
			AuctionResponseModel logRespdef = new AuctionResponseModel();
			logRespdef.setErrorMessage("not succesful");
			logRespdef.setResponseStatus(false);
			logRespdef.setUserid(0);
		
			try {
				ObjectMapper mapper = new ObjectMapper();
				String jString = mapper.writeValueAsString(bpm);
				String actionUrl = WebServicesActions.bidforitem;
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
						e.printStackTrace();
						System.out.println("Json cast Problem");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (logRespdef.getResponseStatus() == true) {
				model.addAttribute("ERR_MSG", "Item Successfully Bidded. Check in Items Cart");
				return "homepage";
			}
		}
		else{
			model.addAttribute("ERR_MSG", "Error in bidding item");	
	}
		return"error";
	}
	
	
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
			model.addAttribute("ERR_MSG", "Error in creating item");	
			System.out.println("error creating");
		}
		return "error";
	}
	
	
	
	@RequestMapping(value = "/availableauctions", method = RequestMethod.GET)
	public String availableauctions(HttpServletRequest req, ModelMap model) {
		System.out.println("entered All Auctions page");
		UserRequestModel urm = new UserRequestModel();
		urm.setUserName((String)req.getSession().getAttribute(SessionManagement.SessionUSER));
		urm.setUserid((Integer)req.getSession().getAttribute(SessionManagement.SessionUserId));
		
		SimpleAuctionListResponseModel salrm = new SimpleAuctionListResponseModel();
		try {
			// convert it to jString.
			ObjectMapper mapper = new ObjectMapper();
			String jString = mapper.writeValueAsString(urm);
					// Make a webservice call to check user validity with login
					// information.
					String actionUrl = WebServicesActions.AllAvialAuctions;
					WebServiceCallWrapper WSC = new WebServiceCallWrapper();
					ResponseEntity<String> loginResponse = WSC.call(actionUrl, jString);
					if (loginResponse.getStatusCode() == HttpStatus.OK) {
						String jstring = loginResponse.getBody();
						try {
							 salrm = mapper.readValue(jstring, SimpleAuctionListResponseModel.class);
							 model.addAttribute("productDetails", salrm.getSARM());
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
		
		return "products";
	}
	
	@RequestMapping(value = "/allmyauctions", method = RequestMethod.GET)
	public String allmyauctions(HttpServletRequest req, ModelMap model) {
		System.out.println("entered All Auctions page");
		UserRequestModel urm = new UserRequestModel();
		urm.setUserName((String)req.getSession().getAttribute(SessionManagement.SessionUSER));
		urm.setUserid((Integer)req.getSession().getAttribute(SessionManagement.SessionUserId));
		
		SimpleAuctionListResponseModel salrm = new SimpleAuctionListResponseModel();
		try {
			// convert it to jString.
			ObjectMapper mapper = new ObjectMapper();
			String jString = mapper.writeValueAsString(urm);
					// Make a webservice call to check user validity with login
					// information.
					String actionUrl = WebServicesActions.AllAuctions;
					WebServiceCallWrapper WSC = new WebServiceCallWrapper();
					ResponseEntity<String> loginResponse = WSC.call(actionUrl, jString);
					if (loginResponse.getStatusCode() == HttpStatus.OK) {
						String jstring = loginResponse.getBody();
						try {
							 salrm = mapper.readValue(jstring, SimpleAuctionListResponseModel.class);
							 model.addAttribute("productDetails", salrm.getSARM());
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
		
		return "products";
	}
	
	
	@RequestMapping(value = "/posteditemsforsale", method = RequestMethod.GET)
	public String posteditemsforsale(HttpServletRequest req, ModelMap model) {
		System.out.println("entered posted items for sale");
		UserRequestModel urm = new UserRequestModel();
		urm.setUserName((String)req.getSession().getAttribute(SessionManagement.SessionUSER));
		urm.setUserid((Integer)req.getSession().getAttribute(SessionManagement.SessionUserId));
		
		SimpleAuctionListResponseModel salrm = new SimpleAuctionListResponseModel();
		try {
			// convert it to jString.
			ObjectMapper mapper = new ObjectMapper();
			String jString = mapper.writeValueAsString(urm);
					// Make a webservice call to check user validity with login
					// information.
					String actionUrl = WebServicesActions.AllMyActiveAuctions;
					WebServiceCallWrapper WSC = new WebServiceCallWrapper();
					ResponseEntity<String> loginResponse = WSC.call(actionUrl, jString);
					if (loginResponse.getStatusCode() == HttpStatus.OK) {
						String jstring = loginResponse.getBody();
						try {
							 salrm = mapper.readValue(jstring, SimpleAuctionListResponseModel.class);
							 model.addAttribute("productDetails", salrm.getSARM());
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
		
		return "posteditemsforsale";
	}
	
	
	@RequestMapping(value = "/closebid", method = RequestMethod.POST)
	public String myactiveauctions(HttpServletRequest request, ModelMap model) {
		System.out.println("entered close bid controller");
		SimpleAuctionParamModel sapm = new SimpleAuctionParamModel();
		sapm.setUserName((Integer)request.getSession().getAttribute(SessionManagement.SessionUserId));
		sapm.setAuctionid(Integer.parseInt(request.getParameter("auctionid")));
		
		AuctionResponseModel logRespdef = new AuctionResponseModel();
		logRespdef.setErrorMessage("not succesful");
		logRespdef.setResponseStatus(false);
		logRespdef.setUserid(0);
	
		try {
			ObjectMapper mapper = new ObjectMapper();
			String jString = mapper.writeValueAsString(sapm);
			String actionUrl = WebServicesActions.CloseMyAuction;
			WebServiceCallWrapper WSC = new WebServiceCallWrapper();
			ResponseEntity<String> loginResponse = WSC.call(actionUrl, jString);
			if (loginResponse.getStatusCode() == HttpStatus.OK) {
	
				logRespdef.setResponseStatus(true);
			}
		}catch(Exception e){
			
		}
			
		if (logRespdef.getResponseStatus() == true) {
			model.addAttribute("ERR_MSG", "Bid is closed and you can't purchase this item anymore");
			return "homepage";
		}

	return "error";
	}
	
	@RequestMapping(value = "/itemsincartcontroller", method = RequestMethod.GET)
	public String itemsincart(HttpServletRequest req, ModelMap model) {
		System.out.println("entered Items cart");
		UserRequestModel urm = new UserRequestModel();
		urm.setUserName((String)req.getSession().getAttribute(SessionManagement.SessionUSER));
		urm.setUserid((Integer)req.getSession().getAttribute(SessionManagement.SessionUserId));
		
		SimpleAuctionListResponseModel salrm = new SimpleAuctionListResponseModel();
		try {
			// convert it to jString.
			ObjectMapper mapper = new ObjectMapper();
			String jString = mapper.writeValueAsString(urm);
					// Make a webservice call to check user validity with login
					// information.
					String actionUrl = WebServicesActions.viewmyCarts;
					WebServiceCallWrapper WSC = new WebServiceCallWrapper();
					ResponseEntity<String> loginResponse = WSC.call(actionUrl, jString);
					if (loginResponse.getStatusCode() == HttpStatus.OK) {
						String jstring = loginResponse.getBody();
						System.out.println("welcome in items cart");
						try {
							 salrm = mapper.readValue(jstring, SimpleAuctionListResponseModel.class);
							 model.addAttribute("productDetails", salrm.getSARM());
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
		
		return "itemsincart";
	}
	
	
	
	@RequestMapping(value = "/purchaseditems", method = RequestMethod.GET)
	public String purchaseditems(HttpServletRequest req, ModelMap model) {
		System.out.println("entered purchased items");
		UserRequestModel urm = new UserRequestModel();
		urm.setUserName((String)req.getSession().getAttribute(SessionManagement.SessionUSER));
		urm.setUserid((Integer)req.getSession().getAttribute(SessionManagement.SessionUserId));
		
		SimpleAuctionListResponseModel salrm = new SimpleAuctionListResponseModel();
		try {
			// convert it to jString.
			ObjectMapper mapper = new ObjectMapper();
			String jString = mapper.writeValueAsString(urm);
					// Make a webservice call to check user validity with login
					// information.
					String actionUrl = WebServicesActions.viewmyOrders;
					WebServiceCallWrapper WSC = new WebServiceCallWrapper();
					ResponseEntity<String> loginResponse = WSC.call(actionUrl, jString);
					if (loginResponse.getStatusCode() == HttpStatus.OK) {
						String jstring = loginResponse.getBody();
						try {
							 salrm = mapper.readValue(jstring, SimpleAuctionListResponseModel.class);
							 model.addAttribute("productDetails", salrm.getSARM());
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
		
		return "purchaseditems";
	}
	
	
}
