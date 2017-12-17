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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	static Service service = new Service();
	
	/**
	 * 
	 */
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
		
		// 3. Convert received JSON to User object
		User u = mapper.readValue(json, User.class);
		
		// Find the user with the given username and store it in the temp
		// If the user does not exist, will return null and store it in temp
		User temp = service.validateUser(u.getUsername());
		
		if(temp == null) {
			// nothing to modify
		} else if(!temp.getPassword().equals(u.getPassword())) {
			temp.setPassword(null);
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("user", temp);	
		}
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		
		String userJSON = mapper.writeValueAsString(temp);
		out.write(userJSON);
	}	
}
