package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rev.pojos.User;
import com.rev.service.Service;

/*
 *  the pattern should be shown as localhost.../register
 *	action points to URL via the index.html's form action="register"
 * note that doGet will post info to the URL, don't do that for sensitive info
 */

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		// we use request, because we are requesting for information
		String name = request.getParameter("username");
		String pass = request.getParameter("password");
		System.out.println("User: " + name + "\nPassword: " + pass);
		
		Enumeration<String> paramNames = request.getParameterNames();
		while(paramNames.hasMoreElements()) {
			String param = paramNames.nextElement();
			String val = request.getParameter(param);
			System.out.println(param + ": " + val);
		}
		
		
		// printwriter send response back to client
		// note that you can just input plain text and not include html tags
//		PrintWriter out = response.getWriter();
//		out.print("<h1> Welcome " + name + "! <h1>");
		
		
	}
	
	// sometimes you might need to keep the @Override in order to work.
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		Service service = new Service();
		User user = new User();
		
		String name = request.getParameter("username");
		user.setUsername(name);
		service.addUser(user);
		
		PrintWriter out = response.getWriter();
		ArrayList<String> users = service.getUsers();
		String userList = "<ul>";
		for(String u: users) {
			userList = userList + "<li>" + u + "</li>";
		}
		
		userList = userList + "</ul>";
		
		PrintWriter out = response.getWriter();
		out.print(userList);
		
	}
	
}




