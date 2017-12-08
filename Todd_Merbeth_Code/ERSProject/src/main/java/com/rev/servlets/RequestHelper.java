package com.rev.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {
	
	public String process(HttpServletRequest req, HttpServletResponse resp) {
		
		System.out.println("In process method");
		switch (req.getRequestURI()) {
		case "/ERSProject/employeeProfile.view": {
			return "partials/empProfile.html";
		}
		case "/ERSProject/employeeHome.view": {
			return "partials/empHome.html";
		}
		case "/ERSProject/login.view": {
			return "partials/loginP.html";
		}
		case "/ERSProject/register.view": {
			return "partials/registerP.html";
		}
		}
		return null;
	}

}
