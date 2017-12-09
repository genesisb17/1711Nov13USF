package com.rev.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rev.service.DemoService;

@WebServlet("/demo")
public class DemoServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{

		String name = request.getParameter("username");
		String pass = request.getParameter("password");

		System.out.println("User: " + name + "\nPassword: " + pass);

		Enumeration<String> paramNames = request.getParameterNames();
		while(paramNames.hasMoreElements()){
			String param = paramNames.nextElement();
			String val = request.getParameter(param);
			System.out.println(param + ": " + val);
		}

		//		PrintWriter out = response.getWriter();
		//		out.print("Welcome " + name +"!");

	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		DemoService service = new DemoService();
		
		String name = request.getParameter("username");
		service.addUser(name);
		
		
		ArrayList<String> users = service.getUsers();
		
		String userList = "<ul>";
		for(String u : users){
			userList = userList + "<li>" + u + "</li>";
		}
		userList = userList + "</ul>";
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.print(userList);
		
	}
}
