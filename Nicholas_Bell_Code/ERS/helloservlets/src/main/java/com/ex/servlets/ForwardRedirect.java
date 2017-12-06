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
     * @see HttpServlet#HttpServlet()
     */
    public ForwardRedirect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("in servlet: init");
		super.init();
		//we don't want to override what it already does, we're just adding to it
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("in servlet: destroy");
		super.destroy();
		//we don't want to override what it already does, we're just adding to it
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("in get method");
		response.getWriter().append("Served at: ").
			append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("in post method");
		//we're using forms here, so its different than the AJAX stuff
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Service service = new Service();
		User u = service.validateUser(username);
		if(u!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", u);
			//must remain internal
			request.getRequestDispatcher("welcome.html").forward(request, response);
		}
		else {
			//can go external
			response.sendRedirect("index.html");
		}
		
	}

}
/*
 * Understanding Forward vs Redirect:
 * 
 * - Forwards:
 * 		-performed internally by the application (servlet)
 * 		-the browser is completely unaware that it has taken place so the original
 * 			url remins intact
 * 		-any browser reload of the resulting page will simply repeat the
 * 		 original request with the original url
 * 
 * - Redirect:
 * 		-two step process --> the web app instructs the browser to fetch
 * 		 a second url which can differ from the original.
 * 		-browser reload will load a second url, not reload the first
 * 		-marginally slower than forward
 * 		-objects placed in request scope are not available to the second request
 * 		-can redirect to another server ot another location on the same server 
 * 
 */
