package com.rev.project1.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.project1.domain.User;
import com.rev.project1.service.Service;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	static Service service = new Service();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		// 1. get received JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		
		String json = "";
		if(br != null) {
			json = br.readLine();		
		}
		
		// 2. initiate jackson mapper
		ObjectMapper mapper = new ObjectMapper();
				
		// 3. Convert received JSON to User object
		User u = mapper.readValue(json, User.class);

		if(!service.uniqueEmail(u.getEmail())) {
			u.setEmail(null);			
		} else if(!service.uniqueUsername(u.getUsername())) {
			u.setUsername(null);
		} else {
			service.addUser(u);
		}
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		String userJSON = mapper.writeValueAsString(u);
		out.write(userJSON);	
	}
}
