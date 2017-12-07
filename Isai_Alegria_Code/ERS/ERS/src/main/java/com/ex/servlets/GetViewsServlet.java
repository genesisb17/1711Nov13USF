package com.ex.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GetViewsServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.err.print("[LOG] Request sent to front controller");
		String nextView = new RequestHelper().process(req, resp);
		System.out.println("nextview is: " + nextView);
		
		req.getRequestDispatcher(nextView).forward(req, resp);
		
	}

}
