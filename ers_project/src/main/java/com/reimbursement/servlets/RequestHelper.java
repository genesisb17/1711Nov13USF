package com.reimbursement.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {
	
	public String process(HttpServletRequest req, HttpServletResponse resp) {
		
		System.out.println("In process method");
		switch (req.getRequestURI()) {
		case "/ers_project/employeeProfile.view": {
			return "partials/empProfile.html";
		}
		case "/ers_project/employeeHome.view": {
			return "partials/eHome.html";
		}
		case "/ers_project/login.view": {
			return "partials/login.html";
		}
		case "/ers_project/register.view": {
			return "partials/register.html";
		}
		case "/ers_project/empNewRequest.view": {
			return "partials/eMakeReimb.html";
		}
		case "/ers_project/managerHome.view": {
			return "partials/mHome.html";
		}
		case "/ers_project/manResRequest.view": {
			return "partials/mResoReimb.html";
		}
		}
		return null;
	}

}