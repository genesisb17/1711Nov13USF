package com.ex.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {

	public String process(HttpServletRequest req, HttpServletResponse resp) {
		System.err.println("[LOG] Processing request with helper : " + req.getRequestURI());


		//		Factory.getMachineGun();
System.out.println("in process method");
		switch (req.getRequestURI()) {
		case "loadView/home":{
			return "partials/home.html";
		}

		default:
			return "login.html";
		
		}



	}

}