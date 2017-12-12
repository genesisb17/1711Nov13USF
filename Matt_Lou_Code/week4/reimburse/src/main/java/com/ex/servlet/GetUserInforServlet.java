package com.ex.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.pojos.Users;

@WebServlet("/getUserInfo")
public class GetUserInforServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		//Service service = new Service();
		
		HttpSession session = req.getSession();
		Users user = (Users)session.getAttribute("user");
		System.out.println(user);
		
		if(user != null) {
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(user);
			
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			out.write(json);
		}
		else {
			resp.setStatus(418);
		}
		
		
	} 
	
	
}






