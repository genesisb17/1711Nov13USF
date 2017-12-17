package com.rev.project1.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rev.project1.domain.User;

public class GetViewsServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		String nextView = process(req, resp);
		req.getRequestDispatcher(nextView).forward(req, resp);
	}
	
	public String process(HttpServletRequest req, HttpServletResponse resp) {
//		System.out.println("IN VIEW PROGRESS:" + req.getRequestURI()); // testing
		
		switch(req.getRequestURI()) {
		case "/ers/login.view":
			return "partials/login.html";
			
		case "/ers/register.view":
			return "partials/register.html";
			
		case "/ers/app.view":
			return "partials/app.html";
			
		case "/ers/profile.view":
			return "partials/profile.html";
			
		case "/ers/expense.view":
			return "partials/reimbHead.html";
			
		case "/ers/table.view":
			HttpSession session = req.getSession(false);
			User u = (User) session.getAttribute("user");
			if (u.getRoleId() == 1) return "partials/emp.html";
			
			return "partials/man.html";
			
		case "/ers/logout.view":
			return "partials/logout.html";
		}
		return null;
	}
}
