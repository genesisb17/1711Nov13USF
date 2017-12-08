package com.ex.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {

	public String process(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("[LOG] Processing request with helper : " + req.getRequestURI());


		System.out.println("in process method");
		switch (req.getRequestURI()) {
		case "/reimburse/profile.view":{
			
			return "partials/profile.html";
		}
		case "/reimburse/home.view":{
			System.out.println("IN HOME CASE STATEMENT");
			return "partials/home.html";
		}
		case "/reimburse/register.view":{
			return "register.html";
		}
		case "/reimburse/app.view":{
			return "landing.html";
		}
		}
		
		return null;

	}
}
