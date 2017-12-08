package com.ex.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {

	public String process(HttpServletRequest req, HttpServletResponse resp) {

		System.out.println("[LOG] Processing request with helper : " + req.getRequestURI());




		System.out.println("in process method");
		switch (req.getRequestURI()) {

		case "/bankdemo/profile.view":{
			
			return "partials/profile.html";
		}
		case "/bankdemo/home.view":{
			System.out.println("IN HOME CASE STATEMENT");
			return "partials/home.html";
		}
		case "/bankdemo/register.view":{
			return "register.html";
		}
		case "/bankdemo/app.view":{
			return "app.html";
		}

		}
		
		return null;


	}
}
