package org.arrow.micro.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserLoginHistoryModel {
	
	@Column(name="userHistoryId")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "userHistoryIds")
	@SequenceGenerator(name="userHistoryId",sequenceName="userHistoryIds" ,allocationSize = 1)
	@Id
	private int userHistoryId;
	Date loginDate;
	String location;
	
	public Date getLoginDate() {
		return this.loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public int getUserHistoryId() {
		return userHistoryId;
	}
	public void setUserHistoryId(int userHistoryId) {
		this.userHistoryId = userHistoryId;
	}
	public static void main(String args[]){
		UserLoginHistoryModel ulhm = new UserLoginHistoryModel();
		ulhm.setUserHistoryId(2);
		ulhm.setLoginDate(new Date(System.currentTimeMillis()));
		ulhm.setLocation("bihar");
		
		ObjectMapper mapper = new ObjectMapper();
		String jString = null;
		try{
			jString = mapper.writeValueAsString(ulhm);
			System.out.println(jString);
		}catch(JsonProcessingException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
}
