package org.arrow.micro.dao;

import org.arrow.micro.model.AuctionEventModel;
import org.arrow.micro.model.BidModel;
import org.arrow.micro.model.LoginModel;
import org.arrow.micro.simple.model.AuctionResponseModel;
import org.arrow.micro.simple.model.BidParamModel;
import org.hibernate.Session;
import org.hibernate.query.Query;

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
}