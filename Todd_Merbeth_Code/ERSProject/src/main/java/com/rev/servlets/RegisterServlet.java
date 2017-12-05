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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.pojos.User;
import com.rev.service.Service;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	static Service service = new Service();
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("in register servlet");

		BufferedReader br = 
				new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		if(br != null){
			json = br.readLine();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		
		User u = mapper.readValue(json, User.class);
		u = service.addUser(u);
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		
		String userJSON = mapper.writeValueAsString(u);
		out.write(userJSON);
	}
}
