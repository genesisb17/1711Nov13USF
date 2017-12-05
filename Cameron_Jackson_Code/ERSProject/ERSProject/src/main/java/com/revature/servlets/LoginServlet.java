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
import com.revature.pojos.Users;
import com.revature.service.ERSService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ERSService service = new ERSService();
		
		// Read json from request
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		if (br !=null) {
			json = br.readLine();
		}
		
		// initiate jackson object mapper
		ObjectMapper mapper = new ObjectMapper();
		
		// convert json to object
		Users user = mapper.readValue(json, Users.class);
		
		// Actually login and set HttpSession
		Users currentUser = service.login(user.getUsername(), user.getPassword());
		
		if (currentUser != null) {
			HttpSession session = req.getSession();
			session.setAttribute("user", currentUser);
		} 
			
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.write(mapper.writeValueAsString(currentUser));
	}
}
