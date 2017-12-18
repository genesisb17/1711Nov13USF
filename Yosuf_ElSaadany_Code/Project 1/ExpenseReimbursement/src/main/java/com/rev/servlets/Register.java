package com.rev.servlets;

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
import com.rev.pojos.User;
import com.rev.service.EmployeeService;

@WebServlet("/Register")
public class Register extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	static EmployeeService empservice = new EmployeeService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		// 1. get received JSON data from request
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		if(br != null){
			json = br.readLine();
		}
		
		// 2. initiate jackson mapper
		ObjectMapper mapper = new ObjectMapper();

		// 3. Convert received JSON to String array
		String[] userInfo = mapper.readValue(json, String[].class);
		String username = userInfo[0];
		String password = userInfo[1];
		String firstname = userInfo[2];
		String lastname = userInfo[3];
		String email = userInfo[4];
		int userrole = Integer.parseInt(userInfo[5]); 
				
		User u = new User();
		u.setUsername(username);
		u.setPassword(password);
		u.setFirstname(firstname);
		u.setLastname(lastname);
		u.setEmail(email);
		u.setUserRole(userrole);
				
		User temp = new User();
		temp = empservice.Register(u);
				
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");		
		String userJSON = mapper.writeValueAsString(temp);
		out.write(userJSON);
	}
}


