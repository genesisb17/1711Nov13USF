package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.Users;

@WebServlet("/getuser")
public class GetSessionUser extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Users u = (Users) session.getAttribute("user");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(u);
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.println(json);
	}
}
