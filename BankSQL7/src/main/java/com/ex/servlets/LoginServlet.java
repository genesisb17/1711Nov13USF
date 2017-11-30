package com.ex.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.rev.service.Service;

@WebServlet("/login")
public class LoginServlet extends HttpServlet
{
	static Service service = new Service();
	@Override
	protected void doPost(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException ,java.io.IOException 
	{
		System.out.println("in login Servlet");
	}
}
