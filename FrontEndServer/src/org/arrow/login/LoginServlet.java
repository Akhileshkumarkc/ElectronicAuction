package org.arrow.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.arrow.WebServiceCall.WebServiceCallWrapper;
import org.arrow.WebServiceCall.WebServicesActions;
import org.arrow.authenticate.SessionManagement;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//set the content to html.
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		// get the name and password encrypt it.
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		//TODO: Encryption of the password.
		
		//Create bean class 
		LoginBean bean=new LoginBean();
		bean.setuserName(name);
		bean.setPassword(password);
		request.setAttribute("bean",bean);
		
		Boolean status = false;
		try {
			
			// convert it to jString.
			ObjectMapper mapper = new ObjectMapper();
			String jString = mapper.writeValueAsString(bean);
			 
			//Make a webservice call to check user validity with login information.			
			String actionUrl = WebServicesActions.CheckUserValidity;
			WebServiceCallWrapper WSC = new WebServiceCallWrapper();
			ResponseEntity<String> loginResponse = WSC.call(actionUrl, jString);
			if(loginResponse.getStatusCode() == HttpStatus.OK){
				if(loginResponse.getBody().equalsIgnoreCase("true")){
					status = true;
				}
			}
			
			
		
		} catch (Exception e) {
			e.printStackTrace();
		} 
		if(status){
			//HttpSession session = request.getSession();
			//session.setAttribute("USER", name);
			SessionManagement sm = new SessionManagement();
			sm.createSessionUser(request, bean);
			RequestDispatcher rd=request.getRequestDispatcher("welcome-page.jsp");
			rd.forward(request, response);
		}
		else{
			RequestDispatcher rd=request.getRequestDispatcher("login-error.jsp");
			rd.forward(request, response);
		}
	}
	
	public static void main(String args[]) throws JsonProcessingException{
		LoginBean bean=new LoginBean();
		bean.setuserName("Akhilesh");
		bean.setPassword("kumar");
		
		Boolean status = true;
			ObjectMapper mapper = new ObjectMapper();
			String jString = mapper.writeValueAsString(bean);
			System.out.println(jString);
			JSONObject jobj = new JSONObject(jString);
	
	}
}