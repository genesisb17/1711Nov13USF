package com.rev.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.view")
public class ViewServlet extends HttpServlet{

	private static final long serialVersionUID = -9181768865057790703L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view;
		switch(req.getRequestURI()) {
		
		case "/ExpReimb/login.view":
			view = "templates/login.html";
			break;
		case "/ExpReimb/register.view":
			view = "templates/register.html";
			break;
		case "/ExpReimb/landing.view":
		default:
			view = "templates/landing.html";
			break;
		}
		req.getRequestDispatcher(view).forward(req, resp);
	}
	
}
