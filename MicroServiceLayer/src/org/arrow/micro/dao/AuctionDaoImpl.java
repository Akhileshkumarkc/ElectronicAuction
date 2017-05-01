package org.arrow.micro.dao;

import java.util.List;

import org.arrow.micro.model.AuctionEventModel;
import org.arrow.micro.simple.model.AuctionResponseModel;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class AuctionDaoImpl extends AbsHibernateSession{

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
	
	public AuctionEventModel getAuctionByName(int auctionId){
		AuctionEventModel aem = null;
		try{
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
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
	
	public AuctionEventModel getMyAuctions(int userId){
		//TODO: Join.
		AuctionEventModel aem = null;
		try{
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			session.beginTransaction();
			Query query = session.createQuery("from AuctionEventModel where name = "+ userId);
			aem =  (AuctionEventModel)query.list().get(0);
			session.getTransaction().commit();
		}
		catch(Exception e){
			System.out.println("Error while applying the state");
			aem = null;
		}

		return (AuctionEventModel) aem;

		
	}
}
