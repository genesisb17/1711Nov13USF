package com.rev.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getViews")
public class GetViewsServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.err.println("[LOG] Request sent to Front Controller");
		System.out.println("in getviews servlet");
		
		String nextView = new RequestHelper().process(req, resp);
		
		req.getRequestDispatcher(nextView).forward(req, resp);
		
	}

}
