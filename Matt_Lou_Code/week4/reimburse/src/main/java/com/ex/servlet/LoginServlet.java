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
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.pojos.Users;
import com.rev.service.Service;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
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
		String[] userInfo = mapper.readValue(json, String[].class);
		String username = userInfo[0];
		String password = userInfo[1];
		
		Users user = service.login(username, password);
		HttpSession session = req.getSession();
		System.out.println(user.getEmail());
		
		if(user == null) {
			System.out.println("user was null, username/password not found.");
		}
		else{
			// persist the user that logged in to "user"
			session.setAttribute("user", user);
		}
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		
		String userJSON = mapper.writeValueAsString(user);
		System.out.println("JSON: " + userJSON);
		
		out.write(userJSON);

		//resp.sendRedirect("html/submitrequest.html");
		//req.getRequestDispatcher("SubmitRequestPageServlet").forward(req, resp);
			
	}
}
