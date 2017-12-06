package com.bank.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetHomeViewServlet
 */
@WebServlet("/getHomeView")
public class GetHomeViewServlet extends HttpServlet{

	
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) throws
			ServletException, IOException{
		
		System.out.println("in login view servlet");
		
		//using the request object and getting a request dispatcher, and
		//forwarding it to 
		req.getRequestDispatcher("partials/loginpartial.html")
		.forward(req, resp);
	}
}
