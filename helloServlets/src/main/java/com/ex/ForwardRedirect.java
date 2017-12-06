package com.ex;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ForwardRedirect extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
	public void init(ServletConfig config)throws ServletException
	{
		System.out.println("In Servlet - init");
		super.init();
		
	}
	
	public void destroy()
	{
		System.out.println("In Servlet - destroy");
		super.destroy();

	}
	public ForwardRedirect() 
	{
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").
		//append(request.getContextPath());
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//doGet(request, response);
	
		Service service = new Service();
		User user = service.validateUser(username);
		if(user!=null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
			request.getRequestDispatcher("welcome.html").forward(request, response);
		}
		else
		{
			response.sendRedirect("www.google.com");
		}		
}
}

/*
 * Understanding HTTP Forward vs Redirect:
 * -performed internally by the application (servlet)
 * --the broser is completelly unaware that it has taken place so the 
 * original url remains intact
 * -- any browser reload of the resulting page will simply repeat the original request with the original url
 * 
 * Redirect:
 * -two-step process --> the web app insructs the browser to fetch a secon 
 * url which can differ from the original.
 * -browser reload will load second url, not reload the first
 * --marginally slower than forward
 * --objects placed in request scope are not available to the second
 * request
 * --can redirect to another server or another location on the same 
 * server.
 * 
 * 
 */
*/