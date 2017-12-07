package com.rev.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {
	public String process(HttpServletRequest req, HttpServletResponse resp) {
		System.err.println("[LOG] Processing request with helper : "+req.getRequestURI());
		
		System.out.println("in process method");
		switch(req.getRequestURI()) {
		case "bankdemo/profile.view":{
			return "partials/profile.html";
		}
		case "bankdemo/home.view":{
			return "partials/home.html";
		}
		
		}
		return null;
	}
}
