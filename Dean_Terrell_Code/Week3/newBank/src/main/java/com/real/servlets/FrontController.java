package com.real.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.err.println("[LOG] Request sent to Front Controller");
		
		String nextView = process(req, resp);
		
		req.getRequestDispatcher(nextView).forward(req, resp);
	}
	
	public static String process(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println(req.getRequestURI());
		switch (req.getRequestURI()) {
		case "/newBank/profile.view": {
			return "partials/profile.html";
		}
		case "/newBank/profile2.view": {
			return "partials/profile2.html";
		}
		case "/newBank/home.view": {
			return "partials/home.html";
		}
		case "/newBank/home2.view": {
			return "partials/home2.html";
		}
		case "/newBank/reimb.view": {
			return "partials/reimb.html";
		}
		case "/newBank/register.view": {
			return "register.html";
		}
		case "/newBank/app1.view": {
			return "app1.html";
		}
		case "/newBank/app2.view": {
			return "app2.html";
		}
		case "/newBank/login.view": {
			return "login.html";
		}
		}
		System.out.println("Improper process request	");
		return null;
	}
}
