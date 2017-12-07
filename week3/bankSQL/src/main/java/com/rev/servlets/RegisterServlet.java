package com.rev.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.pojos.User;
import com.rev.service.Service;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	static{
		System.out.println("in register servlet");
	}
	
	static Service service = new Service();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		System.out.println("in do get");
		request.getRequestDispatcher("register.html").forward(request, response);
		}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		System.out.println("in register servlet");

		BufferedReader br = 
				new BufferedReader(new InputStreamReader(request.getInputStream()));
		String json = "";
		
		if(br != null){
			json = br.readLine();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		
		User u = mapper.readValue(json, User.class);
		String username=u.getUsername();
		String password=u.getPassword();
		String fn=u.getFirstname();
		String ln=u.getLastname();
		service.addUser(fn,ln,username,password);
		
		// redirect to login page? display successful login page then request login page? 
	}
}
