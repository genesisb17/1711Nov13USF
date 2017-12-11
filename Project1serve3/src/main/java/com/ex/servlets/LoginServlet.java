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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.pojo.User;
import com.rev.service.Service;

@WebServlet("/login")
public class LoginServlet extends HttpServlet 
{
	static Service service = new Service();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		// 1. get received JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		if (br != null) 
		{
			json = br.readLine();
		}
		
		// 2. initiate jackson mapper
		ObjectMapper mapper = new ObjectMapper();
		//// 3. Convert received JSON to String array
		String[] userInfo = mapper.readValue(json, String[].class);
		String username = userInfo[0];
		String password = userInfo[1];
		
		User temp = service.geters_users(username, password); // get user by uname
		if (temp == null) 
		{ // if invalid user, obj = null
			//System.out.println("temp is null");
		} 
		else if (!temp.getPassword().equals(password)) 
		{ 
			// if invalid pw, id = 0;
			temp.setUid(0);
			temp.setPassword(null);
		} 
		else 
		{// valid credentials
			HttpSession session = req.getSession();
			session.setAttribute("user", temp);// persist this user to the session to be accessed throughout servlets			
		}
//where the if statement for user and manager should go
		//resp.setContentType("profile/html");
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		//check line above if none of the code is working?
		String userJSON = mapper.writeValueAsString(temp);
		//out.write(userJSON);
		out.println("I'm Batman");
		out.print("<div>There is some text here</span>");
	
	}
	
}
