package org.arrow.micro.WebServiceCall;

public class MicroWebServicesActions {
	
	public static final String microServiceBaseUrl = "http://localhost:8080/MicroServiceLayer";
	public static final String loginService_authenicate = "loginservices/authenicate";
	public static final String loginService_register   = "loginservices/register";
	
	public static final String LOGINSERVICE = "/loginservices";
	public static final String USERSERVICE = "/userservices";
	public static final String AUCTIONSERVICE = "/auctionservices";
	public static final String BIDSERVICE = "/bidservices";
	public static final String ORDERSERVICE = "/orderservices";
	
	//login
	public static final String authenicate = "/authenicate";
	public static final String Register = "/register";
	
	//user
	public static final String profileview = "/profileview";
	public static final String profiledit = "/profileedit";
	public static final String userprofileview = USERSERVICE+profileview;
	public static final String userprofiledit = USERSERVICE+profiledit;
	
	
	//Auction
	public static final String create = "/create";
	public static final String update = "/update";
	public static final String AllAvial = "/allavailauctions";
	public static final String AllMyActive = "/allmyactiveauctions";
	public static final String All = "/allauctions";
	public static final String Close = "/closeAuction";
	
	public static final String createAuction = AUCTIONSERVICE+create;
	public static final String updateAuction = AUCTIONSERVICE+update;
	public static final String AllAvialAuctions = AUCTIONSERVICE+AllAvial;
	public static final String AllMyActiveAuctions = AUCTIONSERVICE +AllMyActive;
	public static final String CloseMyAuction = AUCTIONSERVICE +Close;
	
	//bid
	public static final String Allbids = "/allbids";
	public static final String mybids = "/mybid";
	public static final String foritem = "/bid";
	public static final String delete = "/deletebid";
	
	public static final String viewsAllbids = BIDSERVICE+Allbids;
	public static final String viewsmybids = BIDSERVICE+mybids;
	public static final String bidforitem = BIDSERVICE+foritem;
	public static final String deletebid = BIDSERVICE+delete;
	
	//order
	public static final String myOrders = "/myorders";
	public static final String myCarts = "/myCarts";
	public static final String viewmyOrders = ORDERSERVICE+ myOrders;
	public static final String viewmyCarts = ORDERSERVICE+ myCarts;

}
