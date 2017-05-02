package org.arrow.authenticate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.arrow.beans.LoginBean;
import org.arrow.model.SimpleUserModel;

public class SessionManagement {
	public static final String SessionUSER = "USER";
	public static final String SessionUserId = "USERID";
	public static final String Lastlogin = "6:20PM";
	
	public static void createSessionUser(HttpServletRequest request, LoginBean bean,int userid){
	HttpSession session = request.getSession();
	session.setAttribute(SessionUSER, bean.getuserName());
	session.setAttribute(SessionUserId, userid);
	
	}
	public static void createSessionLastlogin(HttpServletRequest request, SimpleUserModel sum) throws ParseException{
		HttpSession session = request.getSession();
		Date date = sum.getLastLogin();
		session.setAttribute(Lastlogin, date);
		
	}
	
	public static int validSessionUser(HttpSession session){
		if(session.getAttribute(SessionUSER)!=null || session.getAttribute(SessionUSER)!=""){
			return 1;
		}else{
			return 0;
		}
	}
	public void logoutSessionUser(HttpSession session){
		session.invalidate();
	}
}
