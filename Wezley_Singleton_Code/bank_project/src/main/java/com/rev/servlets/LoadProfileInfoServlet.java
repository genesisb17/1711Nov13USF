package com.rev.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.pojos.User;

/**
 * Servlet implementation class LoadProfileInfoServlet
 */
@WebServlet("/loadProfileInfo")
public class LoadProfileInfoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("In LoadProfileInfoServlet - doGet");
		
		//Service service = new Service();
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		//System.out.println(user);
		
		if(user != null) {
			
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(user);
			
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			
			out.write(json);
			
		}
		
		else {
			User emptyUser = new User();
			
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(emptyUser);
			
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			
			out.write(json);
		}
		
		
	}

}
