package com.demo.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {
	public String process(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("in request helper before switch " + req.getServletPath());
		switch(req.getServletPath()) {
			case "/demo/login.page" : {
				System.out.println("reached login page");
				return "partials/login.html";
			}
			case "/demo/register.page" : {
				System.out.println("reached login page");
				return "partials/register.html";
			}
		}
		return null;
	}
}
