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
import com.rev.pojos.User;
import com.rev.service.Service;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
    	
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		System.out.println("In LoginServlet - doGet");
		
		Service service = new Service();
		
		// 1. get recieved JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		
		String json = "";
		if(br != null) {
			json = br.readLine();
		}
		
		System.out.println("JSON STRING: " + json);
		
		// 2. initiate Jackson mapper (allows for conversion to and from Java and JSON)
		ObjectMapper mapper = new ObjectMapper();
		
		// 3. Convert received JSON to String array
		String[] userInfo = mapper.readValue(json, String[].class);
		String username = userInfo[0];
		String password = userInfo[1];
		
		
		User temp = (service.getUserByUsername(username).getId() != 0) ? service.getUserByUsername(username) : null;
		
		if(temp == null) {
			System.out.println("temp is null");
		}
		
		else if(!temp.getPassword().equals(password)) {
			temp.setId(0);
			temp.setFirstName(null);
			temp.setLastName(null);
			temp.setEmailAddress(null);
			temp.setUsername(null);
			temp.setPassword(null);
		}
		
		else {
			HttpSession session = request.getSession();
			session.setAttribute("user", temp); // persists this user to the session
		}
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		
		String userJSON = mapper.writeValueAsString(temp);
		
		System.out.println(userJSON);
		
		out.write(userJSON);
		
		
		
		
		
		
		/*Service service = new Service();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User loggedInUser = service.loginUser(username, password);
		
		PrintWriter out = response.getWriter();
		
		if(loggedInUser != null) {
			out.println("<h1>Welcome, " + loggedInUser.getFirstName() + "</h1>");
		}
		
		else {
			response.sendRedirect("login.html");
			
		}*/
	}

}
