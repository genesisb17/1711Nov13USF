package com.revature.servlets;

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
import com.revature.pojos.User;
import com.revature.service.BankService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	static BankService service = new BankService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in login servlet");
		
		// 1. get received JSON data from request
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		if (br !=null) {
			json = br.readLine();
		}
		System.out.println("JSON STRING: " + json);
		
		// 2. initiate jackson mapper
		ObjectMapper mapper = new ObjectMapper();
		
		// 3. Convert received JSON to String array
//		String[] user = mapper.readValue(json, String[].class);
		User user = mapper.readValue(json, User.class);
		String username = user.getUsername();
		String password = user.getPassword();
		System.out.println(username + ": " + password);
		
		// Validation and stuff happens here
		// HttpSession used to save page state
		User temp = service.login(username, password);
		if (temp == null) {
			System.out.println("invalid user");
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
