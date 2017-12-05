package com.ex.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ex.pojos.User;
import com.ex.service.Service;

/**
 * Servlet implementation class ForwardRedirect
 */
public class ForwardRedirect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("In servlet - init");
		super.init();
	}

	public void destroy() {
		System.out.println("In servlet - destroy");
		super.destroy();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("in get method");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("in post method");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Service service = new Service();
		User u = service.validateUser(username);
		if(u != null) {
			// set session attribute of user
			HttpSession session = request.getSession();
			session.setAttribute("user", u);
			
			request.getRequestDispatcher("welcome.html").forward(request, response);
		} else {
			response.sendRedirect("index.html");
		}
//		doGet(request, response);
	}
	/*
	 * Understanding HTTP forward vs. redirect
	 * 
	 * - Forwards: 
	 * 	- performed internally by servlet (application)
	 * 	- the browser is completely unaware that it has taken place so
	 * 	- the original url remains intact
	 * 	- any browser reload of the resulting page will repeat the 
	 * 	- original request with the original url
	 * 
	 * - Redirects:
	 * 	- two-step process
	 * 	- 1. web app instructs the browser to fetch a second url which differs
	 * 	- 	from the original
	 * 	- 2. browser reload will load seocond url, not the first
	 * 	- marginally slower than forward
	 * 	- objects placed in request scope are not available to second request
	 * 	- can redirect to another server or another location on the same server
	 */

}
