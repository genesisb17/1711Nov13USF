package com.ex.servlets;

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

import com.rev.pojos.User;
import com.rev.service.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Service service = new Service();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

		
		// 1. get received JSON data from request
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		if(br != null){
			json = br.readLine();
		}
		//System.out.println("JSON STRING: " + json);

		// 2. initiate jackson mapper
		ObjectMapper mapper = new ObjectMapper();

		//// 3. Convert received JSON to String array
		String[] userInfo = mapper.readValue(json, String[].class);
		String username = userInfo[0];
		String password = userInfo[1];


		User temp = service.findUser(username); // get user by uname
		boolean check = service.checkPass(temp, password);
		if(temp == null || check == false){ // if invalid user, obj = null
			if(temp==null)
			{
				System.out.print("Username doesn't exist, ");
			}
			
			else {
				
				System.out.print("Invalid password entered, ");
			}
			
			System.out.println("login failed");
		}
		
		else{// valid credentials
			HttpSession session = req.getSession();
			session.setAttribute("user", temp); //persist this user to the session to be accessed throughout servlets
			
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			String userJSON = mapper.writeValueAsString(temp);
			
			out.write(userJSON);
		}

		
		   
	}

}


