package com.rev.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		System.out.println("Logging user out");
		if(req.getSession(false) == null) {
			// req.getSession returns the current HttpSession, if there is non
			// bool value of true would create session
			resp.sendRedirect("Login.html");
			//req.getRequestDispatcher("Login.html").forward(req,resp);
		}
		
		HttpSession session = req.getSession(false);
		if(session != null) {
			session.removeAttribute("user");
			session.invalidate();
			System.out.println("Session Invalidated");
		}
		resp.sendRedirect("Login.html");
		//req.getRequestDispatcher("Login.html").forward(req,resp);
	}

}
