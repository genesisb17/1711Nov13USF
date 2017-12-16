package com.rev.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {
	public String process(HttpServletRequest req, HttpServletResponse resp) {
		String partial="";
		switch(req.getRequestURI()){
		case "/ers/login.view":{
			partial="partials/login.html";
			break;
		}
		case "/ers/profile.view":{
			partial="partials/profile.html";
			break;
		}
		case "/ers/register.view":{
			partial="partials/register.html";
			break;
		}
		case "/ers/newReimbursement.view":{
			partial="partials/newReimbursement.html";
			break;
		}
		}
		return partial;
	}
}
