package org.arrow.webservicelayer.MicroServiceCall;

import org.arrow.webservicelayer.model.LoginResponseModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author Akhilesh
 *
 */
public class MicroServiceCallWrapper {
	
	public static String microServiceBaseUrl = "http://localhost:8080/MicroServiceLayer";
	
	public ResponseEntity call(String actionUrl,String jString){
		String urlString = microServiceBaseUrl+actionUrl;
		System.out.println(urlString);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(jString, headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity Response = restTemplate
				  .exchange(urlString, HttpMethod.POST, entity, String.class);
		System.out.println(Response.getBody());
		return Response;
		
	
				
	}

}
