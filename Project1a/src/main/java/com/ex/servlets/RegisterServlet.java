package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rev.pojo.newUser;
import com.rev.service.Service;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet
{
	private static final long serialVersionUID =1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(name +" "+ password);
		
		Enumeration<String> paraNames = request.getParameterNames();
		
		PrintWriter out = response.getWriter();
		out.print("<h1>Welcome "+name+"!</h1>");
		while(paraNames.hasMoreElements())
		{
			String param =paraNames.nextElement();
			String val = request.getParameter(param);
			System.out.println(param+": "+val);
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		Service service = new Service();
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		String first = request.getParameter("first");
		String last = request.getParameter("last");
		String Balance = request.getParameter("balance");
		int b = Integer.parseInt(Balance);
		
		newUser u1 =new newUser();
		
		u1.setBalance(b);
		u1.setFirstname(first);
		u1.setLastname(last);
		u1.setUsername(name);
		u1.setPassword(password);
		
		service.addUser(u1,100);
		PrintWriter out = response.getWriter();
		out.println(name+" "+u1.getBalance());
		

	}
	
	//Servlet
	//Generic Servlet
	//HttpServlet
}
