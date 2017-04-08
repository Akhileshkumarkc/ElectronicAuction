package org.arrow.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		
		LoginBean bean=new LoginBean();
		bean.setName(name);
		bean.setPassword(password);
		request.setAttribute("bean",bean);
		Boolean status = true;
//		try {
//			 
//			Client client = Client.create();
//			WebResource webResource = client.resource("http://localhost:8080/jaxrs-jersey-rest/loginservices/checkuservalidity");
//			MultivaluedMap formData = new MultivaluedMapImpl();
//			formData.add("username", name);
//			formData.add("password", password);
//			ClientResponse restResponse = webResource
//			    .type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
//			    .post(ClientResponse.class, formData);
//			
//			if (restResponse.getStatus() != 200) {
//				throw new RuntimeException("Failed : HTTP error code : " + restResponse.getStatus());
//			}
// 
//			String statusString = restResponse.getEntity(String.class);
//			status = Boolean.parseBoolean(statusString);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} 
		if(status){
			HttpSession session = request.getSession();
			session.setAttribute("USER", name);
			RequestDispatcher rd=request.getRequestDispatcher("welcome-page.jsp");
			rd.forward(request, response);
		}
		else{
			RequestDispatcher rd=request.getRequestDispatcher("login-error.jsp");
			rd.forward(request, response);
		}
	}

}
