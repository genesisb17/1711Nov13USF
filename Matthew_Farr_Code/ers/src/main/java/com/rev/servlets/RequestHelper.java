package com.rev.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {

	public String process(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("[LOG] Processing request with helper : " + req.getRequestURI());

		System.out.println("in process method");
		switch (req.getRequestURI()) {
		case "/ers/register.view": {
			return "register.html";
		}
		case "/ers/empApp.view": {
			return "empApp.html";
		}
		case "/ers/empReimb.view": {
			return "partials/empReimb.html";
		}
		case "/ers/manApp.view": {
			return "manApp.html";
		}
		case "/ers/manReimb.view": {
			return "partials/manReimb.html";
		}
		case "/ers/submitReimb.view": {
			return "partials/subReimb.html";
		}
		case "/ers/updateReimb.view": {
			return "partials/updateReimb.html";
		}
		}

		return null;

	}

}
