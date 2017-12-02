package com.ex.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.pojos.User;
import com.ex.service.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	static Service service = new Service();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("in login servlet");

		BufferedReader br = 
				new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		if(br != null){
			json = br.readLine();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		
		User u = mapper.readValue(json, User.class);
		u = service.addUser(u);
		
		// redirect to login page? display successful login page then request login page? 
		
	}

}
