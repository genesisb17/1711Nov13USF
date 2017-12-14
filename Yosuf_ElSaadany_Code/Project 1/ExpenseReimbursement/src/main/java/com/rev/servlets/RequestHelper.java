package com.rev.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {

	public String process(HttpServletRequest req, HttpServletResponse resp) {
		System.err.println("[LOG] Processing request with helper : " + req.getRequestURI());
		
		switch (req.getRequestURI()) {
		case "/ExpenseReimbursement/profile.view":{
			return "partials/profile.html";
		}
		case "/ExpenseReimbursement/AddReimbursement.view":{
			return "partials/AddReimbursement.html";
		}
		case "/ExpenseReimbursement/ViewPastReimbursements.view":{
			return "partials/ViewPastReimbursements.html";
		}
		case "/ExpenseReimbursement/ManagerView.view":{
			return "/partials/ManagerViewAll.html";
		}
/*		case "/ExpenseReimbursement/ManagerFilter.view":{
			return "/partials/ManagerFilter.html";
		}	*/
		}
		return null;
	}
	
}