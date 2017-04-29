package org.arrow.webservicelayer.WebServiceCall;

public  class WebServicesActions {
	
	//main Services.
	
	public static String LOGINSERVICE = "/loginservices";
	public static String USERSERVICE = "/userservices";
	public static String AUCTIONSERVICE = "/auctionservices";
	public static String BIDSERVICE = "/bidservices";
	public static String ORDERSERVICE = "/orderservices";
	
	//login
	public static String CheckUserValidity = LOGINSERVICE+"/checkuservalidity";
	public static String Register = LOGINSERVICE+"/register";
	
	
	//user
	public static String profileview = "/profileview";
	public static String profiledit = "/profileedit";
	public static String userprofileview = USERSERVICE+profileview;
	public static String userprofiledit = USERSERVICE+profiledit;
	
	
	//Auction
	public static String create = "/create";
	public static String update = "/update";
	public static String AllAvial = "/allavailauctions";
	public static String AllMy ="/allmyauctions";
	public static String All = "/allauctions";
	public static String Close = "/closeAuction";
	
	public static String createAuction = AUCTIONSERVICE+create;
	public static String updateAuction = AUCTIONSERVICE+update;
	public static String AllAvialAuctions = AUCTIONSERVICE+AllAvial;
	public static String AllMyAuctions = AUCTIONSERVICE+AllMy;
	public static String AllAuctions = AUCTIONSERVICE +All;
	public static String CloseMyAuction = AUCTIONSERVICE +Close;
	
	//bid
	public static String Allbids = "/allbids";
	public static String mybids = "/mybid";
	public static String foritem = "/bid";
	public static String delete = "/deletebid";
	
	public static String viewsAllbids = BIDSERVICE+Allbids;
	public static String viewsmybids = BIDSERVICE+mybids;
	public static String bidforitem = BIDSERVICE+foritem;
	public static String deletebid = BIDSERVICE+delete;
	
	//order
	public static String myOrders = "/myorders";
	public static String viewmyOrders = ORDERSERVICE+ myOrders;
}

