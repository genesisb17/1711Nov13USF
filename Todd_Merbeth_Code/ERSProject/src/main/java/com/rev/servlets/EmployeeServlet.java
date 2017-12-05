package com.rev.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rev.service.Service;

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	static Service service = new Service();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}
}
