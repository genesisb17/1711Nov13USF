package com.revature.ers.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.helpers.ValidationHelper;

/**
 * Servlet implementation class ValidationServlet using Front Controller design
 */
@WebServlet("*.validate")
public class ValidationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("[LOG] - Request sent to front controller, ValidationServlet");
		
		String input = new ValidationHelper().process(request, response);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(input);
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		out.write(json);
		
	}
}
