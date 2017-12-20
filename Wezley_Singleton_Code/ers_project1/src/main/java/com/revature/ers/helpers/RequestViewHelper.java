package com.revature.ers.helpers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestViewHelper {

	public String process(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("[LOG] - Processing request with helper: " + request.getRequestURI());

		switch(request.getRequestURI()) {

		case "/ers/login.view":
			return "partials/login.html";

		case "/ers/register.view":
			return "partials/register.html";
			
		case "/ers/managerLogin.view":
			return "partials/managerLogin.html";

		case "/ers/home.view":
			return "partials/tabs.html";
			
		case "/ers/mhome.view":
			return "partials/mtabs.html";
			
		case "/ers/userView-profile.view":
			return "partials/userView-profile.html";
			
		case "/ers/editProfile.view":
			return "partials/editProfile.html";
			
		case "/ers/userView-openTicket.view":
			return "partials/userView-openTicket.html";
			
		case "/ers/userView-pending.view":
			return "partials/userView-pending.html";
			
		case "/ers/managerView-pending.view":
			return "partials/managerView-pending.html";
		
		case "/ers/userView-pendingDetails.view":
			return "partials/userView-pendingDetails.html";
			
		case "/ers/userView-history.view":
			return "partials/userView-history.html";
			
		case "/ers/editTicket.view":
			return "partials/editTicket.html";
			
		//more cases will go here as views are realized...

		default:
			return null;
		}
	}
}
