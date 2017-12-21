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

@WebServlet("/getUserInfo")
public class GetUserInfoServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		ObjectMapper mapper = new ObjectMapper();
		PrintWriter out = resp.getWriter();
		System.out.println("IN GET USER SERVLET");
		resp.setContentType("application/json");
		String userJSON = mapper.writeValueAsString(user);
		System.out.println("JSON: " + userJSON);
		out.write(userJSON);
		
	}
}
