package com.reimb.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reimb.service.Service;

@WebServlet("/logout")
public class Logout extends HttpServlet {
	static Service service = new Service();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
		HttpSession session  = request.getSession();
	    session.removeAttribute("user");
	    session.invalidate();                
	}
}
