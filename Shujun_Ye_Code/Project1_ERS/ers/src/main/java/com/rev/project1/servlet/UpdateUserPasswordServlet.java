package com.rev.project1.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.project1.domain.User;
import com.rev.project1.service.Service;

@WebServlet("/updateUserPass")
public class UpdateUserPasswordServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException{
		HttpSession session = req.getSession();
		User u = (User) session.getAttribute("user");

		Service service = new Service();
		
		// 1. get received JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
				
		String json = "";
		if(br != null) {
			json = br.readLine();		
		}
		
		// 2. initiate jackson mapper
		ObjectMapper mapper = new ObjectMapper();
				
		// 3. Convert received JSON to User object
		String[] newpass = mapper.readValue(json, String[].class);
		
		u.setPassword(newpass[0]);
		u = service.updateUser(u);
		
		if(u != null) {
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			String userJSON = mapper.writeValueAsString(u);
			out.write(userJSON);
		}	
	}
}
