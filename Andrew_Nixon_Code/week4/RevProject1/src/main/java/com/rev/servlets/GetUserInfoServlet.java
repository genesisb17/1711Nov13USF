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
import com.rev.pojos.ERSUser;

@WebServlet("/getUserInfo")
public class GetUserInfoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		ERSUser user = (ERSUser) session.getAttribute("user");

		if (user != null) {
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(user);

			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			out.write(json);
		} else {
			resp.setStatus(418);
		}
	}

}
