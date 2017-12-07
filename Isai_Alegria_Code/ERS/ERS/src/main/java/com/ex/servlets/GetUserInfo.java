package com.ex.servlets;

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

@WebServlet("/getUserInfo")
public class GetUserInfo extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		//System.out.println("user from session: " + user);
		
		if(user!=null) {
			
			//turn user retrieved into JSON
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(user);
			
			PrintWriter out = resp.getWriter();
			out.write(json);
		}
		
		else {
			//not correctly getting user from session
			resp.setStatus(418);
			
		}
		
	}
	
	
	
	

}