package com.bank.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.pojos.User;
import com.bank.util.Service;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String first = request.getParameter("firstname");
		String last = request.getParameter("lastname");
		String name = request.getParameter("username");
		String pass = request.getParameter("password");
		
		System.out.println("User: " + name + "\nPassword: " + pass);
		
		Enumeration<String> paramNames = request.getParameterNames();
		while(paramNames.hasMoreElements()) {
			String param = paramNames.nextElement();
			String val = request.getParameter(param);
			System.out.println(param + " " + val);
		}

		PrintWriter out = response.getWriter();
		
		out.print("<h1>Welcome " + name + "</h1>");	
	}
	*/
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In Post");
		
		Service service = new Service();
		
		String first = request.getParameter("firstname");
		String last = request.getParameter("lastname");
		String name = request.getParameter("username");
		String pass = request.getParameter("password");
		
		User user = new User();
		
		user.setFirstName(first);
		user.setLastName(last);
		user.setUserName(name);
		user.setPassWord(pass);
		
		service.addUser(user);
		
		System.out.println(user.toString());
		
		//PrintWriter out = response.getWriter();
	}
}
