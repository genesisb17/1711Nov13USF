package com.bank.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.service.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/login")//slash is necessary
public class LoginServlet extends HttpServlet{
	static Service service = new Service();
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("in login servlet");
	
		//1) get received JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		if(br != null) {
			json = br.readLine();
		}
		System.out.println("JSON STRING:" + json);
		
		//2) initiate jackson mapper
		ObjectMapper mapper = new ObjectMapper();
		
		//3) Convert received json to String array
		//	we formatted the json in the app.js file tp be in the form of [username, password]
		String[] user = mapper.readValue(json, String[].class);
		String username = user[0];
		String password = user[1];
		System.out.println(username);
		
		//4) set response type to json
		
	} 
}
