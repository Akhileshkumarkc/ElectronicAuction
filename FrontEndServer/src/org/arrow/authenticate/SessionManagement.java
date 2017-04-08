package org.arrow.authenticate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.arrow.login.LoginBean;

public class SessionManagement {
	public static void createSessionUser(HttpServletRequest request, LoginBean bean){
	HttpSession session = request.getSession();
	session.setAttribute("USER", bean.getName());
	
	}
	public static int validSessionUser(HttpSession session){
		if(session.getAttribute("USER")!=null || session.getAttribute("USER")!=""){
			return 1;
		}else{
			return 0;
		}
	}
	public void logoutSessionUser(HttpSession session){
		session.invalidate();;
	}
}
