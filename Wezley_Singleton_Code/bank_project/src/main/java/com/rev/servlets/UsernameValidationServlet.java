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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.service.Service;

/**
 * Servlet implementation class UsernameValidationServlet
 */
@WebServlet("/usernameValidate")
public class UsernameValidationServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    static Service service = new Service();
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("In UsernameValidationServlet...");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String json = "";
		if(br != null) {
			json = br.readLine();
		}
		
		System.out.println(json);
		
		ObjectMapper mapper = new ObjectMapper();
		String username = mapper.readValue(json, String.class);
		System.out.println(username);
		boolean usernameValid = false;
		
		if(service.isUsernameAvailable(username)) {
			usernameValid = true;
		}
		
		if(!usernameValid) {
			username = null;
		}
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		
		String dataJSON = mapper.writeValueAsString(username);
		
		out.write(dataJSON);
		
	}

}
