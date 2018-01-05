package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rev.pojos.User;
import com.rev.service.Service;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("username");
		String pass = request.getParameter("password");

		System.out.println("User: " + name + "\nPassword: " + pass);

		Enumeration<String> paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String param = paramNames.nextElement();
			String val = request.getParameter(param);
			System.out.println(param + ": " + val);
		}

		/*
		 * PrintWriter out = response.getWriter(); out.print("<h1>Welcome " + name +
		 * "!</h1>");
		 */

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Service service=new Service();
		String name = request.getParameter("username");
		String pass= request.getParameter("password");
		User user=new User();
		user.setEmail(name);
		user.setPassword(pass);
		user.setFirstname("Register");
		user.setLastname("Servlet");
		service.addUser(user);
		
		String here = "<h1>"+service.getUser(name, pass).toString()+"</h1>";
		
		System.out.println(service.getUser(name, pass));
		PrintWriter out=response.getWriter();
		out.print(here);
		
	}

}