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
		System.out.println("in servlet - init()");
		super.init();
		
	}

	public void destroy() {
		System.out.println("in sevlet - destory()");
		super.destroy();
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in get()");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in post()");
		String username = request.getParameter("username"); // forms directly map to url pattern!
		Service service = new Service();
		User user = service.ValidateUser(username);
		//doGet(request, response);
		if (user!=null){
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			request.getRequestDispatcher("welcome.html").forward(request, response);
		}
		else {
			response.sendRedirect("index.html");
		}
	}

}
/* understand http forward vs redirect ! 
forward is preformed interally by applicationtion ( servlet) 
-the brower is completely unaware that it has takenplace so the origenal url remaisn intact 
0 any browser relaod of the reult page will repeat the origan request wilth thr url 


where a redirect - two step prpocess 
the webapp instruct the url browser to fetch a second url that(can) differs from the origenal 
browser wreload will laod second durl no the first 
-marginally slwoer than foward 
-objects placed in request scopre are not available to secondreuqest 
can redirect to another server or another location 
*
*
*/