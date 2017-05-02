package org.arrow.micro.test;

import java.io.File;
import java.util.Date;

import org.arrow.micro.model.AddressModel;
import org.arrow.micro.model.AuctionEventModel;
import org.arrow.micro.model.AuctionStatusModel;
import org.arrow.micro.model.BidModel;
import org.arrow.micro.model.LoginModel;
import org.arrow.micro.model.PurchasedItemModel;
import org.arrow.micro.model.UserDetailsModel;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestModel {
	
	
	
public static void main(String args[]){
	
	//1. create 2 users.
	
	UserDetailsModel akhileshUser = new UserDetailsModel();
	UserDetailsModel VivekUser = new UserDetailsModel();
	
	
	//2. Register akhilesh
		//2a.akhilesh login info,
		LoginModel lma = new LoginModel();
		lma.setUserName("akhilesh");
		lma.setPassword("password");
		lma.setLastLogin(new Date(System.currentTimeMillis()));
		lma.setLocation("Dallas");
		
		//associate login info.
		akhileshUser.setLoginInfo(lma);
		
		// 2b.  fill in normal details.
		akhileshUser.setFirstName("Akhilesh");
		akhileshUser.setLastName("kumar");
		akhileshUser.setPhoneNumber("4696644745");
		akhileshUser.setCompany("utdallas");
		akhileshUser.setEmail("akhi.x319@gmail.com");
		akhileshUser.setUseraddress( new AddressModel("7815", "16101", "Richardson", "Texas", "75252"));
		akhileshUser.setShippingAddress( new AddressModel("7815", "16101", "Richardson", "Texas", "75252"));
		
	  //2. Register Vivek
				//2a.akhilesh login info,
				LoginModel lmv = new LoginModel();
				lmv.setUserName("vivek");
				lmv.setPassword("password");
				VivekUser.setLoginInfo(lma);
				// 2b.  fill in normal details.
				VivekUser.setFirstName("Vivek");
				VivekUser.setLastName("Kanaparthy");
				VivekUser.setPhoneNumber("6647655674");
				VivekUser.setCompany("utdallas");
				VivekUser.setEmail("vivek@gmail.com");
				VivekUser.setUseraddress( new AddressModel("7825", "140", "Richardson", "Texas", "75252"));
				VivekUser.setShippingAddress( new AddressModel("7815", "140", "Richardson", "Texas", "75252")); 
		
				ObjectMapper mapper = new ObjectMapper();
				String jString = null;
				try {
					jString = mapper.writeValueAsString(akhileshUser);
					System.out.println(jString);
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
	//login to be done by web.			
	//create 2 Auction items for akhilesh.
	 AuctionEventModel 	AuctionEventIphone = new AuctionEventModel();
	 AuctionEventModel 	AuctionEventDell = new AuctionEventModel();
	 
	 AuctionEventIphone.setStatus(AuctionStatusModel.CREATED);
	 AuctionEventIphone.setStartingBid(new Double(300));
	 AuctionEventIphone.setStartDateTime(new Date());
	 
	 //setting date.
	 long len = (new Date().getTime()) + 8*24*60*60*1000 ;
	 Date d1 = new Date(len);
	 //TODO: Research on date.	 
	 AuctionEventIphone.setScheduledEndDate(d1);
	 
	 //create the item:

	 AuctionEventDell.setStatus(AuctionStatusModel.CREATED);
	 AuctionEventDell.setStartingBid(new Double(300));
	 AuctionEventDell.setStartDateTime(new Date());
	 
	 //setting date.
	
	 //TODO: Research on date.	 
	 AuctionEventIphone.setScheduledEndDate(d1);
	 
	 //create the item:
	 int UserId = VivekUser.getUserId();
	 
	 BidModel bd1 = new BidModel( VivekUser.getLoginInfo() );
	 bd1.setBid(new Double(100));
	 AuctionEventIphone.addBidModel(bd1);
	
	 //on close few more events.
	 //AuctionEventIphone.setStatus(AuctionStatusModel.CLOSE);
	 //AuctionEventclose.
	 PurchasedItemModel pm = new PurchasedItemModel();
	 pm.setAuction(AuctionEventIphone);
	// pm.setUser(VivekUser);
	 
	 //TODO:Set price
	 //pm.setPrice(AuctionEventIphone.getBidModel().);
	
		try{
			jString = mapper.writeValueAsString(AuctionEventIphone);
			System.out.println(jString);
		}catch(JsonProcessingException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	 
	 //	 AuctionEventGetAllBids();
		 //AuctionEvent.close();
		 // Award the event to a buyer();
		// Prepare the bill.
	// }
	 
		Configuration configuration = new Configuration();
	    configuration.configure(new File("./WebContent/WEB-INF/hibernate.cfg.xml") );
	    configuration.addAnnotatedClass(LoginModel.class);
	    configuration.addAnnotatedClass(AddressModel.class);
	    configuration.addAnnotatedClass(UserDetailsModel.class);
	    configuration.addAnnotatedClass(AuctionEventModel.class);
	    configuration.addAnnotatedClass(BidModel.class);
	    configuration.addAnnotatedClass(PurchasedItemModel.class);
	    
	    
	    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).build();
	    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try{
			
			session.save(akhileshUser);
			session.save(lma);
			session.save(VivekUser);
			session.save(lmv);
			session.save(AuctionEventDell);
			session.save(AuctionEventIphone);
			session.save(bd1);
			
			session.getTransaction().commit();
					}
		catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	    	 session.close();
	      }
		
		
	
	
	
	
}
}
