package com.ex.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetViewsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException
	{
		System.err.println("[LOG] Request sent to Front Controller");
		
		String nextView = new RequestHelper().process(req, resp);
		
		req.getRequestDispatcher(nextView).forward(req, resp);
		

//		req.getRequestDispatcher("partials/home.html")
//		.forward(req, resp);
	}

}