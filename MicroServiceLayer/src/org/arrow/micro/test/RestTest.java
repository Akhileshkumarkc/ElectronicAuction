package org.arrow.micro.test;

import java.util.ArrayList;
import org.arrow.micro.model.AddressModel;
import org.arrow.micro.model.LoginModel;
import org.arrow.micro.model.UserDetailsModel;
import org.arrow.micro.model.UserLoginHistoryModel;
import org.arrow.micro.simple.model.SimpleUserModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RestTest {

	public static void main(String args[]){

		//testRegister();
		testRegister2();
		testLogin();
	}

	private static void testRegister2() {
		// TODO Auto-generated method stub
		
		String microServiceBaseUrl = "http://localhost:8080/MicroServiceLayer/";
		String LoginRegister = "loginservice/register";
		String urlString = microServiceBaseUrl + LoginRegister;
	
		SimpleUserModel sum = new SimpleUserModel();
		sum.setUserId(1);
		sum.setFirstName("Akhilesh");
		sum.setLastName("Kumar");
		//	this.streetName = streetName;
		//	this.houseNumber = houseNumber;
		//	this.city = city;
		//	this.state = state;
		//	this.pinCode = pinCode;
		sum.getUser_streetName()
		sum.get
		sum.
		sum.
		sum.
		sum.
		//sum.setShippingaddress(new AddressModel("7815","16101","Richardson","Texas","75252"));
		sum.setEmail("akhi.x319@gmail.com");
		sum.setPhoneNumber("4696644745");
		sum.setCompany("SAP");
		
		ObjectMapper mapper = new ObjectMapper();
		String jString = null;
		try{
			jString = mapper.writeValueAsString(sum);
			System.out.println(jString);
		}catch(JsonProcessingException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		// set headers
		HttpHeaders headers = new HttpHeaders();headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(jString, headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> loginResponse = restTemplate.exchange(urlString, HttpMethod.POST, entity,
			String.class);System.out.println(loginResponse.getBody());
		boolean status = false;if(loginResponse.getStatusCode()==HttpStatus.OK){
			if (loginResponse.getBody().equalsIgnoreCase("true")) {
				status = true;
			}
		}
		System.out.println(status);
	}

	private static void testLogin() {
		String microServiceBaseUrl = "http://localhost:8080/MicroServiceLayer/";
		String LoginRegister = "loginservice/authenicate";
		
		String urlString = microServiceBaseUrl + LoginRegister;
	
		// 2a.akhilesh login info,
		LoginModel lma = new LoginModel();
		lma.setLoginId(1);
		lma.setUserName("akhilesh");
		lma.setPassword("password");
		
		ObjectMapper mapper = new ObjectMapper();
		String jString = null;
		try{
			jString = mapper.writeValueAsString(lma);
			System.out.println(jString);
		}catch(JsonProcessingException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		// set headers
		HttpHeaders headers = new HttpHeaders();headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(jString, headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> loginResponse = restTemplate.exchange(urlString, HttpMethod.POST, entity,
			String.class);System.out.println(loginResponse.getBody());
		boolean status = false;if(loginResponse.getStatusCode()==HttpStatus.OK){
			if (loginResponse.getBody().equalsIgnoreCase("true")) {
				status = true;
			}
		}
		System.out.println(status);

	
		
	}

	private static void testRegister() {
		String microServiceBaseUrl = "http://localhost:8080/MicroServiceLayer/";
		String LoginRegister = "loginservice/register";
		String urlString = microServiceBaseUrl + LoginRegister;
	
		// 2a.akhilesh login info,
		LoginModel lma = new LoginModel();
		lma.setLoginId(1);
		lma.setUserName("akhilesh");
		lma.setPassword("password");
		UserDetailsModel akhileshUser = new UserDetailsModel();
		akhileshUser.setLoginInfo(lma);
		// 2b. fill in normal details.
		akhileshUser.setFirstName("Akhilesh");
		akhileshUser.setLastName("kumar");
		akhileshUser.setPhoneNumber("4696644745");
		akhileshUser.setCompany("utdallas");
		akhileshUser.setUseraddress(new AddressModel("7815","16101","Richardson","Texas","75252"));
		akhileshUser.setShippingAddress(new AddressModel("7815","16101","Richardson","Texas","75252"));
		akhileshUser.setEmail("akhi.x319@gmail.com");
		akhileshUser.setUserHistory( new ArrayList<UserLoginHistoryModel>());
		
		ObjectMapper mapper = new ObjectMapper();
		String jString = null;
		try{
			jString = mapper.writeValueAsString(akhileshUser);
			System.out.println(jString);
		}catch(JsonProcessingException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		// set headers
		HttpHeaders headers = new HttpHeaders();headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(jString, headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> loginResponse = restTemplate.exchange(urlString, HttpMethod.POST, entity,
			String.class);System.out.println(loginResponse.getBody());
		boolean status = false;if(loginResponse.getStatusCode()==HttpStatus.OK){
			if (loginResponse.getBody().equalsIgnoreCase("true")) {
				status = true;
			}
		}
		System.out.println(status);
	}
}