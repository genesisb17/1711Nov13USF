package com.ex.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.service.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	static Service service = new Service();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
			
		System.out.println("in login servlet");
		
		// 1. get recieved JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		
		String json = "";
		if(br != null) {
			json = br.readLine();
		}
		
		System.out.println("JSON STRING: " + json);
		
		// 2. initiate jackson mapper
		ObjectMapper mapper = new ObjectMapper();
		
		// 3. Convert recieved JSON to String Array
		String[] user = mapper.readValue(json, String[].class);
		String username = user[0];
		String password = user[1];
		System.out.println(username);
		
	
		// 4. Set response tye to JSON
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/js");
		
		String userJSON = mapper.writeValueAsString(temp);
		out.write(userJSON);
	}
}