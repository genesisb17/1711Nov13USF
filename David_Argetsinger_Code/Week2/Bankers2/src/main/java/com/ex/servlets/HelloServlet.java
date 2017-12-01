package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse responce) throws ServletException, IOException {
		responce.setContentType("text/html");
		PrintWriter out = responce.getWriter();
		out.println("<h1> jello welcome to your first sevlet ! </h1>"
				+ "<br><br>"
				+ "<ul><li>this is a list item </li></ul>");
		
	}

}
