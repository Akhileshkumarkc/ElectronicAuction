<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8" %>
<%@page import="org.arrow.beans.LoginBean,org.arrow.authenticate.SessionManagement"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Welcome</title>
</head>
<body>
<% 
	
	if (session == null)
  	{
    	String address = "/login-error.jsp";
    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(address);
    	dispatcher.forward(request,response);
  	}
	else
	{
		SessionManagement sm = new SessionManagement();
		//String name=(String)session.getAttribute("USER");
		//LoginBean bean=(LoginBean)request.getAttribute("bean");
		if(sm.validSessionUser(session)==1){
			out.print("entered");
			LoginBean bean=(LoginBean)request.getAttribute("bean");
			out.print("Welcome, "+bean.getuserName());
		}else{
			String address = "/login-error.jsp";
	    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(address);
	    	dispatcher.forward(request,response);
		}
	}
%>
</body>
</html>