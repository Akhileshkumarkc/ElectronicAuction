package org.arrow.micro.dao;

import java.util.List;

import org.arrow.micro.email.EmailModel;
import org.arrow.micro.email.EmailTemplateClass;
import org.arrow.micro.model.AuctionEventModel;
import org.arrow.micro.model.AuctionStatusModel;
import org.arrow.micro.model.BidModel;
import org.arrow.micro.model.PurchasedItemModel;
import org.arrow.micro.simple.model.AuctionResponseModel;
import org.arrow.micro.simple.model.UserRequestModel;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;



public class AuctionDaoImpl extends AbsHibernateSession{
	
	@Autowired
	LoginDaoImpl loginDao;
	@Autowired
	private MailSender mailsender;
	public AuctionResponseModel create(AuctionEventModel model, AuctionResponseModel resp) {
		try{
			//create
			Session session = sessionFactory.openSession();
			
			session.beginTransaction();
			session.save(model);
			session.getTransaction().commit();
			}
			
			catch(Exception e){
				System.out.println(e);
				resp.setErrorMessage("Unable to create Auction");
				resp.setResponseStatus(true);
				throw e;
			}
			resp.setAuctionid(model.getAuctionId());
			resp.setErrorMessage("Succesfully Added");
			resp.setResponseStatus(true);
			resp.setUserid(model.getOwner().getUserId());	
			return resp;
						
		}
	@SuppressWarnings("unchecked")
	public List<AuctionEventModel> getAllAuctions(){
		List<AuctionEventModel> querylist = null;
		try{
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			session.beginTransaction();
			Query query = session.createQuery("from AuctionEventModel");
			querylist =  (List<AuctionEventModel>)query.list();
			session.getTransaction().commit();
		}
		catch(Exception e){
			System.out.println("Error while applying the state");
			querylist = null;
		}

		return querylist;
	}
	
	public AuctionEventModel getAuctionById(int auctionId){
		AuctionEventModel aem = null;
		try{
			Session session = sessionFactory.openSession();			
			session.beginTransaction();
			Query query = session.createQuery("from AuctionEventModel where auctionId = "+ auctionId);
			aem =  (AuctionEventModel)query.list().get(0);
			session.getTransaction().commit();
		}
		catch(Exception e){
			System.out.println("Error while applying the state");
			aem = null;
		}

		return (AuctionEventModel) aem;

		
	}
	
	public AuctionEventModel getMyAuctions(UserRequestModel userModel){
		//TODO: Join.
		AuctionEventModel aem = null;
		Session session = sessionFactory.openSession();
		// new Auction Event
		// userId
			session.beginTransaction();
			Query query = session.createQuery("from AuctionEventModel where userId = "+ userModel.getUserid() );
			aem =  (AuctionEventModel)query.list();
			session.getTransaction().commit();
		return (AuctionEventModel) aem;
	}
	
	public AuctionResponseModel update(AuctionEventModel model, AuctionResponseModel resp) {
		try{
			//create
			Session session = sessionFactory.openSession();
			
			session.beginTransaction();
			session.update(model);
			session.getTransaction().commit();
			}
			
			catch(Exception e){
				System.out.println(e);
				resp.setErrorMessage("Unable to create Auction or bidding");
				resp.setResponseStatus(true);
				throw e;
			}
			resp.setAuctionid(model.getAuctionId());
			resp.setErrorMessage("Succesfully Added");
			resp.setResponseStatus(true);
			resp.setUserid(model.getOwner().getUserId());	
			return resp;
						
		}
	
	
	public List<AuctionEventModel> getAllMyAuctions(UserRequestModel userModel) {
		List<AuctionEventModel> aem = null;
		try{
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Query query = session.createQuery("from AuctionEventModel where Owner_userId != "+ 
					+ userModel.getUserid() 
					+" and status ="+AuctionStatusModel.OPEN);
			aem =  (List<AuctionEventModel>)query.list();
			session.getTransaction().commit();
		}
		catch(Exception e){
			System.out.println("Error while applying the state");
			aem = null;
		}

		return  aem;
		
	}

	
	public List<AuctionEventModel> getAvailableAuctions(UserRequestModel userModel) {
		List<AuctionEventModel> aem = null;
		try{
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Query query = session.createQuery("from AuctionEventModel where Owner_userId != "+ 
					+ userModel.getUserid() 
					+" and status ="+AuctionStatusModel.OPEN);
			aem =  (List<AuctionEventModel>)query.list();
			session.getTransaction().commit();
		}
		catch(Exception e){
			System.out.println("Error while applying the state");
			aem = null;
		}

		return  aem;
		
	}
	public void savePurchaseModel(PurchasedItemModel pm) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(pm);
		session.getTransaction().commit();
		
	}
	public boolean closeAuction(int auctionid) {
		
		//Auction id

		AuctionEventModel aem = null;
		Session session = sessionFactory.openSession();			
		try{
			
			session.beginTransaction();
			Query query = session.createQuery("from AuctionEventModel where auctionId = "+ auctionid);
			aem =  (AuctionEventModel)query.list().get(0);
			
		}
		catch(Exception e){
		System.out.println("Hello");
		}
		//
		BidModel  maxbm = new BidModel();
		List<BidModel> bmlist = (List<BidModel>) aem.getBidModels();
		if( bmlist.size()!= 0){
			maxbm = bmlist.get(0);		
		}
		for(int i = 0; i < bmlist.size(); i++){
			BidModel bd = bmlist.get(i);
			if(bd != null && bd.getBid()!=null){
				if(bd.getBid() > maxbm.getBid()){
					maxbm =bd;
				}
			}
		}
		aem.setStatus(AuctionStatusModel.CLOSE);
		if(maxbm != null){
			
//			SimpleMailMessage message = new SimpleMailMessage();
//			EmailTemplateClass.init();
//			EmailModel em = EmailTemplateClass.getTemplate(EmailTemplateClass.BID_PURCHASED);
//			loginDao = new 		
//			message.setTo(maxbm.setUserId(userId));
//			message.setSubject(em.subject);
//			message.setText("Hi "+ user.getUserName()+"  "+em.messageBody);
//			mailsender.send(message);

			SimpleMailMessage message = new SimpleMailMessage();
	
			message.setTo("sai.vivek15@gmail.com");
			message.setSubject("Congratulations");
			message.setText("Hi User\n \nYou have won the bidding. \n \n Thanks, Aravind.");
			mailsender.send(message);
		}
		//close the Auction.
		
		

		return true;
		
	}
	
}
