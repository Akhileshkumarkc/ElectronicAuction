package org.arrow.micro.simple.model;

import java.util.List;

public class SimpleAuctionListResponseModel {
	
	boolean status;
	String errorMessage;
	List<SimpleAuctionResponseModel> SARM;
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public List<SimpleAuctionResponseModel> getSARM() {
		return SARM;
	}
	public void setSARM(List<SimpleAuctionResponseModel> sARM) {
		SARM = sARM;
	}
	
}
