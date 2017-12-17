package com.rev.project1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.project1.domain.User;
import com.rev.project1.service.Service;

@WebServlet("/getUserInfo")
public class GetUserInfoServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		HttpSession session = req.getSession();
		User u = (User) session.getAttribute("user");
		
		if(u != null) {
			
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(u);
			
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			out.write(json);
		} else {
			resp.setStatus(418);
		}	
	}
}
