package com.ERS.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewsHelper {
	
	public String process(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("[LOG] Processing request with helper : " + req.getRequestURI());



		System.out.println("in process method");
		switch (req.getRequestURI()) {
		case "/Employee_Reimbursement_Service/profile.view":{
			
			return "profile.html";
		}
		case "/Employee_Reimbursement_Service/home.view":{
			System.out.println("IN HOME CASE STATEMENT");
			return "home.html";
		}
		case "/Employee_Reimbursement_Service/register.view":{
			return "register.html";
		}
		case "/Employee_Reimbursement_Service/app.view":{
			return "app.html";
		}
		case "/Employee_Reimbursement_Service/login.view":{
			return "login.html";
		}
		}
		return null;


	}

}
