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
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.pojos.ERSUser;
import com.rev.service.Service;

@WebServlet("/userLogin")
public class UserLoginServlet extends HttpServlet {
	static Service service = new Service();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("inside UserLoginServlet");
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		if(br != null){
			json = br.readLine();
		}
		System.out.println("JSON STRING: " + json);
		ObjectMapper mapper = new ObjectMapper();
		String[] userInfo = mapper.readValue(json, String[].class);
		String username = userInfo[0];
		String password = userInfo[1];
		ERSUser temp = service.checkUsernameExists(username); // get user by uname
		System.out.println(temp.toString());
		
		if(temp.getUserID() == 0) {
			temp = null;
			System.out.println("invalid username");
		}
		//else if(temp.getPassword() != password) {
		else if(!temp.getPassword().equals(password)) {
			System.out.println("invalid password");
			//temp = null;
			//temp.setUserid(0);
			temp.nullifyUser();
		}	
		else {
			HttpSession session = req.getSession();
			session.setAttribute("user", temp);
		}
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		
		String userJSON = mapper.writeValueAsString(temp);
		//System.out.println("JSON: " + userJSON);
		out.write(userJSON);
	}
	
}
