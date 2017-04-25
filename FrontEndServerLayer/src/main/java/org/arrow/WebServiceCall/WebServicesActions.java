package org.arrow.WebServiceCall;

public  class WebServicesActions {
	
	//main Services.
	
	public static String LOGINSERVICE = "/loginservices";
	public static String USERSERVICE = "/userservices";
	public static String AUCTIONSERVICE = "/auctionservice";
	public static String BIDSERVICE = "/bidservice";
	public static String ORDERSERVICE = "/order";
	
	//login
	public static String CheckUserValidity = LOGINSERVICE+"/checkuservalidity";
	public static String Register = LOGINSERVICE+"/register";
	
	//user
	public static String userprofileview = USERSERVICE+"/profileview";
	public static String userprofiledit = USERSERVICE+"/profileedit";
	
	//Auction
	public static String createAuction = AUCTIONSERVICE+"/create";
	public static String updateAuction = AUCTIONSERVICE+"/update";
	public static String AllAvialAuctions = AUCTIONSERVICE+"/allavailauctions";
	public static String AllMyAuctions = AUCTIONSERVICE+"/allmyauctions";
	public static String AllAuctions = AUCTIONSERVICE +"/allmyauctions";
	public static String CloseMyAuction = AUCTIONSERVICE +"/closeAuction";
	
	//bid
	public static String viewsAllbids = BIDSERVICE+"/allbids";
	public static String viewsmybids = BIDSERVICE+"/mybid";
	public static String bidforitem = BIDSERVICE+"/bid";
	public static String deletebid = BIDSERVICE+"/deletebid";
	
	//order
	public static String viewmyOrders = ORDERSERVICE+ "/allorders";
}
