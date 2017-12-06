package com.revature.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {
	
	public String process(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("Watch me " + req.getRequestURI());
		switch (req.getRequestURI()) {
		case "/banking/getHomeView.view": {
			System.out.println("case for home view");
			return "partials/home.html";
		}
		case "/banking/getProfileView.view": {
			return "partials/profile.html";
		}
		default:
			return null;
		}
	}
}
