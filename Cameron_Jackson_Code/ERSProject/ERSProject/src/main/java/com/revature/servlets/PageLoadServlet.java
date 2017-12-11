package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.pojos.Users;

@WebServlet("/loadPage")
public class PageLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain;charset=UTF-8");
		HttpSession session = request.getSession(false);
		if (session == null) {
			out.print("login");
		} else {
			Users u = (Users)session.getAttribute("user");
			String view = (String)session.getAttribute("view");
//			System.out.println(view);
			out.print(view);
//			if (u == null) 
//				out.print("login");
//			else
//				out.print(view);	
		}
	}
}
