package com.rev.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		System.out.println("logging out user");
		if(req.getSession(false) == null) {
			//req.getSession returns current httpsession. if there is none
			//bool value of true would create session if there isn't one
			resp.sendRedirect("app.html");
		}
		
		HttpSession session = req.getSession();
		if(session != null) {
			session.removeAttribute("user");
			session.invalidate();
			System.out.println("session invalidated");
		}
		resp.sendRedirect("app.html");
	}

}
