package com.ex.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws 
		ServletException, IOException {
		
		System.out.println("logging out user");
		if(req.getSession(false) == null) {
		//req.getSession returns the current HttpSession, if there is none, bool value of 		//true, would create session, we want to make sure we are not creating new session
		// getSession(true) would create a new session
			resp.sendRedirect("app.html");
		}
		
		HttpSession session = req.getSession(false);
		if(session != null) {
			session.removeAttribute("user");
			session.invalidate();
			System.out.println("session invalidated");
		}
		resp.sendRedirect("app.html");
		
	}
}













