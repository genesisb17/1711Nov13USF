package com.ex.servlets;

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
public class RegisterServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Service service = new Service();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		BufferedReader br = 
				new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		if(br != null){
			json = br.readLine();
		}
		
		User temp = new User();
		ObjectMapper mapper = new ObjectMapper();
		String[] userInfo = mapper.readValue(json, String[].class);
		//System.out.println("first element in array: " + userInfo[0] + "second element: " + userInfo[1] );
		temp.setUsername(userInfo[0]); 
		temp.setPassword(userInfo[1]);
		temp.setFirstName(userInfo[2]);
		temp.setLastName(userInfo[3]);
		temp.setEmail(userInfo[4]);
		int id = service.addUser(temp); //return user id
		//set user being added's ID
		temp.setUserID(id);
		
		//User u = mapper.readValue(json, User.class); 
		//System.out.println("take a look " + u.getUsername());
		//service.addUser(u,u.getUsername());
		
		// redirect to login page? display successful login page then request login page? 
		
	}
	
	

}
