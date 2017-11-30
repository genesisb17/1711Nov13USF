package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class HelloServlets extends GenericServlet
{
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>hello I am your new ruler of the world</h1>"+"<br><br>"+"<ul><li>this is a list item</li></ul>");
	}	
}


