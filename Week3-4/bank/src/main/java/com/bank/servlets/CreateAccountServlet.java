package com.bank.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.pojos.Account;
import com.bank.pojos.User;
import com.bank.service.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/addAccount")
public class CreateAccountServlet extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("posting new account to db");
	
		//Grab all paramenters, in this case only 1 JSON String
		Map<String, String[]> myMap = request.getParameterMap();

		//Get the the keySet from the map, returns a Set
		Set<String> txObject = myMap.keySet();

		//API for converting our JSON into a Java Object
		ObjectMapper jackson = new ObjectMapper();

		//Convert the the keySet into an array, then get the first element (index 0) from that set
		Object obj = txObject.toArray()[0];
//		
		String accType =  jackson.readValue(((String)obj), String.class);
//		
		
		
		
		
	System.out.println("creating account of type " + accType);
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
//		
//		
//		
		Service service = new Service();
		Account temp = service.addAccount(user, accType);
//		
//		System.out.println(temp.toString());
//		
		session.setAttribute("user", user);
		session.setAttribute("newAcc", temp);
//		
		request.getRequestDispatcher("partials/dashboard.html");
		
	}
	
}
