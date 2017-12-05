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

@WebServlet("/employeeInfo")
public class EmployeeInfo extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) throws
			ServletException, IOException{
		
		System.out.println("in empInfo servlet");
		
		HttpSession session = req.getSession();
		User u = (User) session.getAttribute("user");
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		
		ObjectMapper mapper = new ObjectMapper();
		String userJSON = mapper.writeValueAsString(u);
		out.write(userJSON);
	}
}
