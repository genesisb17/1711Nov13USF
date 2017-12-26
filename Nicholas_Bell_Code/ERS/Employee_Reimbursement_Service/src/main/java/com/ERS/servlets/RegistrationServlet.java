package com.ERS.servlets;

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

import com.ERS.pojos.User;
import com.ERS.service.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Service service = new Service(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		
		String JSON = br.readLine();
		
		System.out.println("JSON = " + JSON);
		
		ObjectMapper mapper = new ObjectMapper();
		User newUser = mapper.readValue(JSON, User.class);
		boolean admin = (newUser.getRole() ? true : false);		
		
				
		
		//returns null if username not found
		//returns fully populated user otherwise
		
		System.out.println(newUser);
		newUser = service.addUser(newUser, admin);
		
	}
}


