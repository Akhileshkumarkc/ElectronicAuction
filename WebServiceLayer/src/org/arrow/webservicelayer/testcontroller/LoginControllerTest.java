package org.arrow.webservicelayer.testcontroller;

import java.net.URI;

import org.arrow.webservicelayer.model.LoginModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
public class LoginControllerTest {
	
	public static final String REST_SERVICE_URI = "http://localhost:8080/WebServiceLayer/";
	public static final String loginAction = "loginservices/checkuservalidity";
	
	
	public static void main(String args[]) throws JsonProcessingException{
		
		String urlString = REST_SERVICE_URI+loginAction;
		LoginModel lm1 = new LoginModel();
		lm1.setUserName("akhilesh");
		lm1.setPassword("password");
		ObjectMapper mapper = new ObjectMapper();
		String jString = mapper.writeValueAsString(lm1);
		System.out.println(jString);
	
		// set headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(jString, headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> loginResponse = restTemplate
				  .exchange(urlString, HttpMethod.POST, entity, String.class);
		System.out.println(loginResponse.getBody());
		boolean status = false;
		if(loginResponse.getStatusCode() == HttpStatus.OK){
			if(loginResponse.getBody().equalsIgnoreCase("true")){
				status = true;
			}
		}
		System.out.println(status);
	}

}
