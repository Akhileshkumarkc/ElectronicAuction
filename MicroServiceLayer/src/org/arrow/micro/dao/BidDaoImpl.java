package org.arrow.micro.dao;

import java.util.ArrayList;
import java.util.List;

import org.arrow.micro.model.AuctionEventModel;
import org.arrow.micro.model.AuctionStatusModel;
import org.arrow.micro.model.BidModel;
import org.arrow.micro.model.LoginModel;
import org.arrow.micro.simple.model.AuctionResponseModel;
import org.arrow.micro.simple.model.BidParamModel;
import org.arrow.micro.simple.model.SimpleAuctionListResponseModel;
import org.arrow.micro.simple.model.SimpleAuctionResponseModel;
import org.arrow.micro.simple.model.UserRequestModel;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver;

public class BidDaoImpl extends AbsHibernateSession {

	public AuctionResponseModel update(BidParamModel model, AuctionResponseModel arm) {
		Session session = sessionFactory.openSession();
		
		// get Auction Event
		AuctionEventModel aem = null;
		try {
			session.beginTransaction();
			Query query = session.createQuery("from AuctionEventModel where auctionId = " + model.getAuctionId());
			aem = (AuctionEventModel) query.list().get(0);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error while applying the state");
		}

		// get the login model.
		LoginModel newLogin = new LoginModel();
		try {

		
			Query query = session.createQuery("from LoginModel where userName='" + model.getUserName() + "'");
			System.out.println(query);
			newLogin = (LoginModel) query.list().get(0);
		
		} catch (Exception e) {
			System.out.println("Error while applying the state");
			newLogin = null;
		}

		// create the bid
		BidModel bid = new BidModel(newLogin);
		bid.setBid(model.getBidvalue());
		session.save(bid);
		// add to auction
		aem.addBidModel(bid);
		
		// update the auction.
		try {
			session.beginTransaction();
			session.update(aem);
			session.getTransaction().commit();
		}

		catch (Exception e) {
			System.out.println(e);
			arm.setErrorMessage(" Bidding Unsuccessful");
			arm.setResponseStatus(false);
			throw e;
		}
		arm.setAuctionid(model.getAuctionId());
		arm.setErrorMessage("Succesfully Added the Bid");
		arm.setResponseStatus(true);
		return arm;

	}

	public SimpleAuctionListResponseModel getCarts(UserRequestModel model, SimpleAuctionListResponseModel sALR) {
		
		AuctionEventModel aem = null;
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery("from AuctionEventModel");
			List<AuctionEventModel>  auctionList =  (List<AuctionEventModel>)query.list();
			session.getTransaction().commit();
			
			SimpleAuctionListResponseModel SALRM = new SimpleAuctionListResponseModel();
			List<SimpleAuctionResponseModel> sarm1 = new ArrayList<SimpleAuctionResponseModel>();
			SALRM.setSARM(sarm1);
			
			
			for(int i = 0; i < auctionList.size(); i++){
				AuctionEventModel ae = auctionList.get(i) ;
				if(ae.getStatus()==AuctionStatusModel.CLOSE){
					continue;
				}
				List<BidModel> bidModels = (List<BidModel>)ae.getBidModels() ;
				for(int j =0; j < bidModels.size();j++ ){
					BidModel bd = bidModels.get(j);
					if(model.getUserid() == bd.getUserId()){
						SimpleAuctionResponseModel sarm = new SimpleAuctionResponseModel();
						sarm.setCategory(ae.getCategory());
						sarm.setProductDescription(ae.getDescription());
						sarm.setProductName(ae.getName());
						sarm.setProductDescription(ae.getDescription());
						sarm.setAcutalEndDate(ae.getScheduledEndDate());
						sarm.setStartingBid(bd.getBid());
						sarm.setAuctionid(ae.getAuctionId());
						sarm.setUserName(ae.getName());
						
						sALR.getSARM().add(sarm);
					}
				}
			}
			}catch (Exception e) {
			System.out.println("Error while applying the state");
			sALR.setErrorMessage("error happened");
			sALR.setStatus(false);
		}
		sALR.setErrorMessage("successful");
		sALR.setStatus(true);
		return sALR;	
	}
	
public SimpleAuctionListResponseModel getorders(UserRequestModel model, SimpleAuctionListResponseModel sALR) {
		
		AuctionEventModel aem = null;
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery("from AuctionEventModel");
			aem = (AuctionEventModel) query.list();
			session.getTransaction().commit();
			
			SimpleAuctionListResponseModel SALRM = new SimpleAuctionListResponseModel();
			
			List<AuctionEventModel>  auctionList =  (List<AuctionEventModel>)query.list();
			for(int i = 0; i < auctionList.size(); i++){
				AuctionEventModel ae = auctionList.get(i) ;
				if(ae.getStatus()!=AuctionStatusModel.CLOSE){
					continue;
				}
				List<BidModel> bidModels = (List<BidModel>)ae.getBidModels() ;
				for(int j =0; j < bidModels.size();j++ ){
					BidModel bd = bidModels.get(j);
					if(model.getUserid() == bd.getUserId()){
						SimpleAuctionResponseModel sarm = new SimpleAuctionResponseModel();
						sarm.setCategory(ae.getCategory());
						sarm.setProductDescription(ae.getDescription());
						sarm.setProductName(ae.getName());
						sarm.setProductDescription(ae.getDescription());
						sarm.setAcutalEndDate(ae.getScheduledEndDate());
						sarm.setStartingBid(bd.getBid());
						sarm.setAuctionid(ae.getAuctionId());
						sarm.setUserName(ae.getName());
						
						sALR.getSARM().add(sarm);
					}
				}
			}
			}catch (Exception e) {
			System.out.println("Error while applying the state");
			sALR.setErrorMessage("error happened");
			sALR.setStatus(false);
		}
		sALR.setErrorMessage("successful");
		sALR.setStatus(true);
		return sALR;	
	}



}