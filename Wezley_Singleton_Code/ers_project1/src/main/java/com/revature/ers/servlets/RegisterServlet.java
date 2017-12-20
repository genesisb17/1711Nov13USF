package com.revature.ers.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.pojos.User;
import com.revature.ers.service.Service;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		System.out.println("[LOG] - Request sent to RegisterServlet...");
		
		Service service = new Service();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String json = "";
		if(br != null) {
			json = br.readLine();
		}
		
		/*System.out.println(json);*/
		
		ObjectMapper mapper = new ObjectMapper();
		User u = mapper.readValue(json, User.class);
		System.out.println(u);
		u = service.createNewUser(u);
		
		if(u == null) {
			System.out.println("User is null");
		}
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		
		String userJSON = mapper.writeValueAsString(u);
		
		out.write(userJSON);
	}

}
