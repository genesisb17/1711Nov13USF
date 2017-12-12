package com.rev.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.service.Service;

@WebServlet("/registerNew")
public class NewRegisterServlet extends HttpServlet {
	
	static Service service= new Service();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json="";
		if(br!=null) {
			json=br.readLine();
		}
		
		ObjectMapper om=new ObjectMapper();
		JsonNode user=om.readTree(json);
		String firstname=user.get("firstname").asText();
		String lastname=user.get("lastname").asText();
		String email=user.get("email").asText();
		String username=user.get("username").asText();
		String password=user.get("password").asText();
		String role=user.get("role").asText();
		String[] userInfo= {firstname,lastname,email,username,password,role};
		service.addUser(userInfo);
	}
}
