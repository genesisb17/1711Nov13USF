package com.bank.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.pojos.User;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/login")
public class LoginServlet extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("In login servlet");

		// 1. Get received JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));

		String json = "";
		if (br != null)
		{
			json = br.readLine();
		}
		System.out.println("JSON STRING: " + json);
		
		// 2. Initiate Jackson Mapper
		ObjectMapper mapper = new ObjectMapper();
		
		// 3. Convert received JSON to String array
		String[] user = mapper.readValue(json,  String[].class);
		//System.out.println(user[0]);
		
		String firstname = user[0];
		String lastname = user[1];
		String username = user[2];
		String password = user[3];
		
		//User u = new User();
		
		//u.setFirstName(user[0]);
		//u.setLastName(user[1]);
		//u.setUserName(user[2]);
		//u.setFirstName(user[3]);
		
		System.out.println(username);
		
		
		
		
		
		// 4. Set response type to JSON
		// response.setContentType("/application/json");
	}

}
