package com.bank.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getDashboard")
public class GetDashboardServlet extends HttpServlet{

	
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) throws
			ServletException, IOException{
		
		System.out.println("in dashboard servlet");
		
		
		req.getRequestDispatcher("partials/dashboard.html")
		.forward(req, resp);
	}
}
