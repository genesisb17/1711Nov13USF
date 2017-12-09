package com.rev.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {
	
	public String process(HttpServletRequest req, HttpServletResponse resp) {
		switch (req.getRequestURI()) {
		case "/RevProject1/main.view":{
			return "main.html";
		}
		}
		return null;
	}

}
