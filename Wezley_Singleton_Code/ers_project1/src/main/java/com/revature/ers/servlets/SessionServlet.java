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
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.pojos.User;
import com.revature.ers.service.Service;

/**
 * Servlet implementation class SessionServlet
 */
@WebServlet("/session")
public class SessionServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("[LOG] - Request sent to SessionServlet: Logout");

		if(request.getSession(false) == null) {
			System.out.println("[LOG] - request.getSession() == null");
			response.sendRedirect("ers.html");
		}

		HttpSession session = request.getSession(false);

		User sessionUser = (User) session.getAttribute("user");
		System.out.println("[LOG] - Logging out user, " + sessionUser.getUsername());

		if(session != null) {
			session.removeAttribute("user");
			session.invalidate();
			System.out.println("[LOG] - Session invalidated");
		}

		response.sendRedirect("ers.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("[LOG] - Request sent to SessionServlet: Login");
		
		Service service = new Service();

		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));

		String json = "";
		if(br != null) {
			json = br.readLine();
		}

		ObjectMapper mapper = new ObjectMapper();

		String[] userInfo = mapper.readValue(json, String[].class);
		String username = userInfo[0];
		String password = userInfo[1];

		User temp = (service.getUserByUsername(username).getUserId() != 0) ? service.getUserByUsername(username) : null;

		if(temp == null) {
			System.out.println("[LOG] - temp variable in LoginServlet is null");
		}

		else if(!temp.getPassword().equals(password)) {
			temp.setUserId(0);
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

		out.write(userJSON);
	}

}
