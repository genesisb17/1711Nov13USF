package com.rev.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {

	public String process(HttpServletRequest req, HttpServletResponse resp) {
		System.err.println("[LOG] Processing request with helper : " + req.getRequestURI());

		System.out.println("in process method");
		switch (req.getRequestURI()) {
		case "view/profile": {
			return "partials/profile.html";
		}
		case "view/home": {
			return "partials/home.html";
		}
		}

		return null;

	}
}
