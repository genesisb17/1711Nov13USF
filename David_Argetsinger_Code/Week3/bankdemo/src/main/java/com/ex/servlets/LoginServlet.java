package com.ex.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.service.DemoService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	static DemoService service = new DemoService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("in login servlet");
		//1. get reciver json data from reuqest 
		BufferedReader br= new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json="";
		if (br!=null)
			json=br.readLine();
		System.out.println("JSON String: "+ json);
		// 2. initiate jason mapper
		ObjectMapper mapper=new ObjectMapper();
		//3convert from json string to  string array 
		String[] user = mapper.readValue(json,String[].class);
		String username = user[0];
		String password = user[1];

		
		System.out.println(username);
		System.out.println(password);
		//set response type to json
		//resp.getContentType("application/json);
		
	}
	
	
}
