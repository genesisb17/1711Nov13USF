package com.ex.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.pojos.Users;
import com.rev.service.Service;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	static Service service = new Service();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
		ServletException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		
		String json = "";
		
		if(br != null) {
			json = br.readLine();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		Users user = mapper.readValue(json, Users.class);
		user = service.addUser(user);
		
		
	}
}
	
	
	
	
	
	
