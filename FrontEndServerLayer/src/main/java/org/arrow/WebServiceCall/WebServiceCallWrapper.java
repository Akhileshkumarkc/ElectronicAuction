package org.arrow.WebServiceCall;



import org.arrow.beans.LoginBean;
//import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
public class WebServiceCallWrapper {
	
	String WebserviceBasicUrl = "http://localhost:8080/WebServiceLayer/";
	
	public ResponseEntity<String> call(String actionUrl,String jString){
		String urlString = WebserviceBasicUrl+actionUrl;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(jString, headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> Response = restTemplate
				  .exchange(urlString, HttpMethod.POST, entity, String.class);
		System.out.println(Response.getBody());
		return Response;
		
	
				
	}

	public static void main(String args[]){
		LoginBean bean=new LoginBean();
		bean.setuserName("Vivek");
		bean.setPassword("password");
		Boolean status = true;
		try {
			ObjectMapper mapper = new ObjectMapper();
			String jString = mapper.writeValueAsString(bean);
			System.out.println(jString);
			//JSONObject jObj = new JSONObject(jString);
			
//			MultivaluedMap formData = new MultivaluedMapImpl();
//			formData.add("username", name);
//			formData.add("password", password);
			
			String actionUrl = WebServicesActions.CheckUserValidity;
			
			WebServiceCallWrapper WSC = new WebServiceCallWrapper();
			ResponseEntity<String> responseEntity = WSC.call(actionUrl, jString);
			if(responseEntity.getStatusCode() == HttpStatus.OK){
				System.out.println("accepted");
			}
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
