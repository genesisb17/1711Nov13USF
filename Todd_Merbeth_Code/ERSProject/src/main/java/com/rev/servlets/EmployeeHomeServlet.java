package com.rev.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/employeeHome")
public class EmployeeHomeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) throws
			ServletException, IOException{
		
		System.out.println("in empHome servlet");
		
		req.getRequestDispatcher("partials/empHome.html")
		.forward(req, resp);
	}
}
