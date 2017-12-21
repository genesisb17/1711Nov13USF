package com.rev.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.pojos.User;
import com.rev.service.Service;

@WebServlet("/EditProfile")
public class EditProfileServlet extends HttpServlet {
	static Service service = new Service();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		System.out.println("in EditProfile servlet");

		// 1. get received JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		if (br != null) {
			json = br.readLine();
		}
		System.out.println("JSON STRING: " + json);

		// 2. initiate jackson mapper
		ObjectMapper mapper = new ObjectMapper();

		//// 3. Convert received JSON to String array
		String[] info = mapper.readValue(json, String[].class);
		String email = info[0];
		String firstname = info[1];
		String lastname=info[2];
		if(email.equals(""))
			email=user.getEmail();
		if(firstname.equals(""))
			firstname=user.getFirstName();
		if(lastname.equals(""))
			lastname=user.getLastName();

		System.out.println(service.setAccount(user.getUser_ID(), email, firstname, lastname));
	}

}
