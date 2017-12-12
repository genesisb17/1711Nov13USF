package com.ex.servlet;

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
import com.rev.pojos.Users;
import com.rev.service.Service;

@WebServlet("/validateEmail")
public class ValidateEmailServlet extends HttpServlet{
	
	static Service service = new Service();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws 		ServletException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		
		String json = "";
		if(br != null) {
			json = br.readLine();
		}
// AJAX sent via user typing in email, convert JSON to java string to check in database
		ObjectMapper mapper = new ObjectMapper();
		String[] userInfo = mapper.readValue(json, String[].class);
		String email = userInfo[0];
		
// function to validate whether the email exists		
		Users user = service.validateEmail(email);

// send a response back to JS whether the email exists or not(null)
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		
		String userJSON = mapper.writeValueAsString(user);
		
		out.write(userJSON);
		
		
	}
	
}
