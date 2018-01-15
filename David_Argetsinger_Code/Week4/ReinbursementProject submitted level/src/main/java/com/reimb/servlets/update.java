package com.reimb.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimb.pojos.User;
import com.reimb.service.Service;
//update user 
@WebServlet("/update")
public class update extends HttpServlet {
	static Service service = new Service();
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			if(request.getSession(false) != null){//if session exists. 
				HttpSession session = request.getSession(false);
				User ogU = (User)session.getAttribute("user");

				BufferedReader br = 
						new BufferedReader(new InputStreamReader(request.getInputStream()));
				String json = "";
				if(br != null){
					json = br.readLine();
				}
				ObjectMapper mapper = new ObjectMapper();

				User u = mapper.readValue(json, User.class);
				u.setId(ogU.getId()); // id wont change and niether will e-mail .. nah lets let that happen username will remain though. session bound as will role
				u.setRole(ogU.getRole());
				u.setUsername(ogU.getUsername());

				// set the SESSION to match new changes!! 
				// if the user doesn't decide to change their  information for fields they will remain the same! 
				// <:! 
				if(u.getEmail()=="")
					u.setEmail(ogU.getEmail());
				else 
					ogU.setEmail(u.getEmail());
				if(u.getLastname()=="")
					u.setLastname(ogU.getLastname());
				else 
					ogU.setLastname(u.getLastname());
				if(u.getName()=="")
					u.setName(ogU.getName());
				else
					ogU.setName(u.getName());
				if(u.getEmail()=="")
					u.setEmail(ogU.getEmail());
				else
					ogU.setEmail(u.getEmail());
				if(u.getPassword()=="")
					u.setPassword(ogU.getPassword());
				else
					ogU.setPassword(u.getPassword());

				service.updateUser(u);
			}

		}catch (NullPointerException e){
		}

	}
}
