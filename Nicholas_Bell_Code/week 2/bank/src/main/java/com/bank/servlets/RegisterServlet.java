package com.bank.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.service.Service;
//We
//
@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	
	
	private static final long serialVersionUID = -3189771712380168077L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)/*or maybe doPost*/
			throws ServletException, IOException{
		String name = request.getParameter("username");
		String pass = request.getParameter("password");
		
		System.out.println("User: " + name + "\nPassword: " + pass);
		
		
		//another way to get parameters, especially if we don't know them
		Enumeration<String> paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {			//while collection of entities has more
			String param = paramNames.nextElement();	//get me the name of that param
			String val = request.getParameter(param);	//get me the value of that param
			System.out.println(param + ": " + val);
		}
		
		
		//PrintWriter out = response.getWriter();
		//out.print("<h1> Welcome " + name +"!</h1>");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		Service service = new Service();
		String name = request.getParameter("username");
		
		//
		//As an example. Do all the stuff required to make a person
		//...
		//...
		//service.addUser(name);
		
		//ArrayList<Users> users = service.getUsers();
		//String userList = "<ul>";
		//PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		//out.print(userList);
		
	}
	
}
