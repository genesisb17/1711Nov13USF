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

		String[] change = mapper.readValue(json, String[].class);

		User oldUser = (User) req.getSession().getAttribute("user");
		User newUser = new User(oldUser.getId(), oldUser.getUsername(), oldUser.getPassword(), oldUser.getFirstname(), oldUser.getLastname(), oldUser.getEmail(), oldUser.getRole(), oldUser.getRoleStr());
		int id = oldUser.getId();

		switch (change[0]) {
		case "firstname":
			newUser.setFirstname(change[1]);
			break;
		case "lastname":
			newUser.setLastname(change[1]);
			break;
		case "email":
			newUser.setEmail(change[1]);
			break;
		case "username":
			newUser.setUsername(change[1]);
			break;
		case "password":
			newUser.setPassword(change[1]);
			break;
		default: 
			newUser = null;
		}	
		User result = service.updateUser(newUser, id);
		
		if (result != null) {
			req.getSession().setAttribute("user", result);
		}

		PrintWriter out = resp.getWriter();

		resp.setContentType("application/json");

		String resJSON = mapper.writeValueAsString(result);
		out.write(resJSON);

	}

}
