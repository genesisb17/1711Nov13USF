package com.ex.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {

	public String process(HttpServletRequest req, HttpServletResponse resp) {
		System.err.println("[LOG] Processing request with helper : " + req.getRequestURI());


		// Factory.getMachineGun();

		switch (req.getRequestURI()) {

		default:
			return "login.html";
		
		}
	}
}