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

@WebServlet("/logoutSession")
public class LogoutServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		session.removeAttribute("user");
		session.invalidate();
		
		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();

		ObjectMapper mapper = new ObjectMapper();
		String messageJSON = mapper.writeValueAsString("You are successfully logged out!");
		out.write(messageJSON);		
	}
}
