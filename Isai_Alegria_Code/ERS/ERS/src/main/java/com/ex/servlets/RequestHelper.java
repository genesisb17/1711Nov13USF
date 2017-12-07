package com.ex.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper{
	
	
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.err.println("[LOG] Processing requesting with helper: " + req.getRequestURI());
		
		System.out.println(req.getRequestURI());
		System.out.println("In process method");
		switch(req.getRequestURI()) {
		
			case "/ERS/profile.view":{
				
				return "partials/profile.html";
			}
			
			case "/ERS/home.view": {
				return "partials/home.html";	
			}
			
			case "/ERS/request.view": {
				return "partials/addRequest.html";
			}
			
			case "/ERS/tickets.view": {
				return "partials/viewTickets.html";
			}
			
			case "/ERS/editprofile.view": {
				
				return "partials/editprofile.html";
			}
			
			case "/ERS/logOut.view": {
				return "partials/logIn.html";
		}
			
		}
		
		return null;
	}
	

}
