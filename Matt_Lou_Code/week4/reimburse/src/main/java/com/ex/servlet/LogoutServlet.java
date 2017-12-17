package com.ex.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rev.pojos.Users;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws 
		ServletException, IOException {
		
//		if(req.getSession(false) == null) {
//		//req.getSession returns the current HttpSession, if there is none, bool value of 		//true, would create session, we want to make sure we are not creating new session
//		// getSession(true) would create a new session
//			resp.sendRedirect("index.html");
//		}
		
		HttpSession session = req.getSession(false);
		Users user = (Users)(session.getAttribute("user"));

//		if(session != null) {
//			session.removeAttribute("user");		
//			session.invalidate();
//			System.out.println("insider" + user.getEmail());
//			System.out.println("session invalidated");
//		}
		session.removeAttribute("user");		
		session.invalidate();

		resp.sendRedirect("index.html");
	}
}













