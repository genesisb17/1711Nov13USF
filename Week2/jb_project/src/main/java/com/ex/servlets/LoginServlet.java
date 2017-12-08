package com.ex.servlets;
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

import com.bank.pojos.Employee;
import com.bank.services.ReimbServices;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	static ReimbServices service = new ReimbServices();
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	System.out.println("in login servlet");
	// 1. get received JSON data from request
	BufferedReader br = 
			new BufferedReader(new InputStreamReader(req.getInputStream()));
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
	

	Employee temp = service.validateUser(username); // get user by uname
	if(temp == null){ // if invalid user, obj = null
		System.out.println("temp is null");
		
	}
	else if(!temp.getPassword().equals(password)){ // if invalid pw, id = 0;
		temp.setUserId(0);
		temp.setPassword(null); //set all user fields to null;
	}
	else{// valid credentials
		HttpSession session = req.getSession();
		session.setAttribute("user", temp);//persist this user to the session to be accessed throughout servlets
	}
	PrintWriter out = resp.getWriter();
	resp.setContentType("application/json");
	
	String userJSON = mapper.writeValueAsString(temp);
	System.out.println("JSON: " + userJSON);
	out.write(userJSON);
}
}

