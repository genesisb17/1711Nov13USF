package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet extends GenericServlet{

	@Override
	public void service(ServletRequest request, ServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<h1>What's up? Servlets are pretty cool!</h1>");
		out.println("<br><br>");
		out.println("<ul><li>this is list item</li><ul>");
		
		
	}

	
}
