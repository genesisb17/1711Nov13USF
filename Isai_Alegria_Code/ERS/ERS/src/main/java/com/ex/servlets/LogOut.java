package com.ex.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet ("/logOut.view")
public class LogOut extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
			System.out.println("logging out user");
			if(req.getSession(false) == null) {
				//req.getSession returns the current HttpSession, if there is none
				//bool value of true would create session
				resp.sendRedirect("app.html");
			}
			
			HttpSession session = req.getSession(false);
			if(session!=null) {
				
				session.invalidate();
				//System.out.println("session invalidated!");
				//resp.sendRedirect("index.html");
				resp.sendRedirect("login.html");
				
			}
			
	}

}
