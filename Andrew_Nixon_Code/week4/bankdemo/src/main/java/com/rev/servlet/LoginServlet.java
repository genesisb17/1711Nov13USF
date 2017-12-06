package com.rev.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.pojos.User;
import com.rev.service.Service;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	static Service service = new Service();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("in login servlet");

		
		// 1. get received JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		if(br != null){
			json = br.readLine();
		}
		System.out.println("JSON STRING: " + json);

		// 2. initiate jackson mapper
		ObjectMapper mapper = new ObjectMapper();

		//// 3. Convert received JSON to String array
		String[] userInfo = mapper.readValue(json, String[].class);
		String username = userInfo[0];
		String password = userInfo[1];
		

		User temp = service.validateUser(username); // get user by uname
		if(temp == null){ // if invalid user, obj = null
			System.out.println("temp is null");
		}
		else if(!temp.getPassword().equals(password)){ // if invalid pw, id = 0;
			temp.setId(0);
			temp.setPassword(null);
		}
		else{// valid credentials
			HttpSession session = req.getSession();
			session.setAttribute("user", temp);//persist this user to the session to be accessed throughout servlets
		}
		//System.out.println("Building PrintWriter");
		PrintWriter out = resp.getWriter();
		//System.out.println("application/json");
		resp.setContentType("application/json");
		//System.out.println(temp.toString());
		String userJSON = mapper.writeValueAsString(temp);
		//System.out.println("out.write(userJSON);");
		out.write(userJSON);
		
		//System.out.println("Leaving doPost");
	}

}
