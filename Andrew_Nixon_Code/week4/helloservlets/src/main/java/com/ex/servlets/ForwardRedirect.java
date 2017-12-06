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
       
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("In FD servlet init");
		super.init();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("In FD servlet destoy");
		super.destroy();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in get method");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in post method");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Service service = new Service();
		User user = service.validateUser(username);
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
			request.getRequestDispatcher("Welcome.html").forward(request, response);
		}
		else {
			response.sendRedirect("index.html");
		}
		
		//doGet(request, response);
	}

}

/*
 * understanding HTTP forward and redirect:
 * -Froward:
 * 		-performed internally by the application (servlet)
 * 		-the browser is completely unaware that it has taken place so the original URL remains intact
 * 		-any browser reload of the resulting page will simply repeat the original request with the 
 * 			original url 
 * 
 * -Redirect:
 * 		-2 step process. the web app instructs the browser to fetch a second url not reload the first 
 * 			which cna differ from the original
 * 
 */

