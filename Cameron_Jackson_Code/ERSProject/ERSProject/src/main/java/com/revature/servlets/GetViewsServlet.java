package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.Users;


public class GetViewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextView = process(request, response);
		request.getRequestDispatcher(nextView).forward(request, response);
	}

	private String process(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		switch (request.getRequestURI()) {
		case "/ERSProject/mainpage.view": 
			return "partials/main-page.html";
			
		case "/ERSProject/loginpage.view":
			return "partials/login-page.html";
			
		case "/ERSProject/login.view": 
			session.setAttribute("view", "login");
			return "partials/login.html";
			
		case "/ERSProject/ca.view":
			session.setAttribute("view", "createaccount");
			return "partials/ca.html";
			
		case "/ERSProject/logout-modal.view":
			return "partials/logout-modal.html";
			
		case "/ERSProject/create-ticket.view":
			return "partials/create-ticket-view.html";
			
		case "/ERSProject/manage-account.view":
			session.setAttribute("view", "manageaccount");
			return "partials/account-management.html";
				
		case "/ERSProject/reimb.view":
			Users u = (Users)session.getAttribute("user");
			session.setAttribute("view", "tickets");
			if (u.getRoleId() == 1)
				return "partials/employee-view.html";
			else if (u.getRoleId() == 2)
				return "partials/manager-view.html";
		default:
			return null;
		}
	}
}