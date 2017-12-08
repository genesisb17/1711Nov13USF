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


public class ForwardRedirect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("In servlet - init()");
		super.init();
	}

	public void destroy() {
		System.out.println("In servlet - destroy()");
		super.destroy();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in get method");
		response.getWriter().append("Served at: ").
			append(request.getContextPath());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in post method");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Service service = new Service();
		User user = service.validateUser(username);
		if(user!=null){
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			request.getRequestDispatcher("welcome.html").forward(request, response);
			//WRONG
		//	request.getRequestDispatcher("https://www.google.com").forward(request, response);
		}
		else{
			
			response.sendRedirect("index.html");
			//OKAY
			//response.sendRedirect("https://www.google.com");
		}
		
		//doGet(request, response);
	}

}
/*
 * Understanding HTTP Forward vs Redirect:
 * 
 * - Forwards:
 * 		- performed internally by the application (servlet)
 * 		- the browser is completely unaware that it has taken place so the 
 * 			original URL remains intact
 * 		- any browser reload of the resulting page will simply repeat the 
 * 			original request with the original URL
 * 
 * 
 * - Redirect:
 * 		- two-step process --> the web app instructs the browser to fetch
 * 			a second URL which can differ from the original. 
 * 		- browser reload will load second URL, not reload the first
 * 		- marginally slower than forward
 * 		- objects placed in request scope are not available to the second request
 * 		- can redirect to another server or another location on the same server
 * 
 */



