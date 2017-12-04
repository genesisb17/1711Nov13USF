package com.real.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.real.pojos.User;
import com.real.util.Service;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	static Service service = new Service();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// 1. get received JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		if(br != null) {
			json = br.readLine();
		}
		
		// 2. initiate jackson mapper
		ObjectMapper mapper = new ObjectMapper();
		Service service = new Service();
		// 3. Convert received JSON to String array
		String[] user = mapper.readValue(json, String[].class);
		String username = user[0];
		String password = user[1];
		if(service.isUser(username))
			System.out.println(username + " is a user!");
		else
			System.out.println("Not a user.");
		
		// 4. Set response type to JSON
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		
		String userJSON = mapper.writeValueAsString(user);
		
		out.write(userJSON);
	}
}
