package com.real.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.real.util.Service;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("username");
		String pass = request.getParameter("password");

		Enumeration<String> paramNames = request.getParameterNames();
		while(paramNames.hasMoreElements()) {
			String param = paramNames.nextElement();
			String val = request.getParameter(param);
			System.out.printf("\n%s : %s", param, val);
		}
		PrintWriter out = response.getWriter();
		out.print("<h1> Welcome " + name + "!</h1>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Service service = new Service();
		
		String name = request.getParameter("username");
		service.addUser(name);
		
		ArrayList<String> users = service.getUsers();
		String userList = "<ul>";
		for (String u : users) {
			userList = userList + "<li>" + u + "</li>";
		}
		userList = userList + "</ul>";
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.print(userList);
	}
}
