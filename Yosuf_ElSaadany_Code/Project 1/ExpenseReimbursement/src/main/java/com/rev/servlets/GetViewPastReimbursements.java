package com.rev.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getPastTicketsView")
public class GetViewPastReimbursements extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		
		req.getRequestDispatcher("partials/ViewPastReimbursements.html")
		.forward(req, resp);
	}

}
