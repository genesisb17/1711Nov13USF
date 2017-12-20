package com.revature.ers.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.pojos.User;
import com.revature.ers.service.Service;

@WebServlet("/updateAccount")
public class UpdateAccountServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("[LOG] - Request sent to UpdateAccountServlet...");

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Service service = new Service();

		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String json = "";
		if(br != null) {
			json = br.readLine();
		}

		ObjectMapper mapper = new ObjectMapper();
		User u = mapper.readValue(json, User.class);
		
		if(u.getUsername() != "") {
			service.updateUsernameById(user.getUserId(), u.getUsername());
		}
		
		if(u.getEmailAddress() != "") {
			service.updateEmailAddressById(user.getUserId(), u.getEmailAddress());
		}
		
		if(u.getPassword() != "") {
			service.updatePasswordById(user.getUserId(), u.getPassword());
		}
		
		u = service.getUserById(user.getUserId());
		
		json = mapper.writeValueAsString(u);

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		out.write(json);
	}

}
