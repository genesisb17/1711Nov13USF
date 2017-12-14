package com.rev.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.pojos.User;
import com.rev.service.Service;

@WebServlet("/updateUser")
public class UpdateUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Service service = new Service();

		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		if (br != null) {
			json = br.readLine();
		}
		ObjectMapper mapper = new ObjectMapper();

		User newUser = mapper.readValue(json, User.class);
		
		User oldUser = (User) req.getSession().getAttribute("user");
		int id = oldUser.getId();
		
		User result = service.updateUser(newUser, id);

		PrintWriter out = resp.getWriter();

		resp.setContentType("application/json");

		String resJSON = mapper.writeValueAsString(result);
		out.write(resJSON);

	}

}
