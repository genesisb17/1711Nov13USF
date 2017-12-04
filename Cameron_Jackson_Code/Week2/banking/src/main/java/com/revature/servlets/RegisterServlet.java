package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.User;
import com.revature.service.BankService;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{

	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("username");
		String pass = request.getParameter("password");
		System.out.println("Username: " + name + "\nPassword: " + pass);

		//		PrintWriter out = response.getWriter();
		//		out.print("<h1>Welcome " + name + "!<h1>");

		Enumeration<String> paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String param = paramNames.nextElement();
			String val = request.getParameter(param);
			System.out.println(param + ": " + val);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BankService service = new BankService();

		// 1. get received JSON data from request
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(request.getInputStream()));
		String json = "";
		if (br !=null) {
			json = br.readLine();
		}
		System.out.println("JSON STRING: " + json);

		// 2. initiate jackson mapper
		ObjectMapper mapper = new ObjectMapper();

		// 3. Convert received JSON to object
		User user = mapper.readValue(json, User.class);

		service.addUser(user);

//		ArrayList<User> users = service.getAllUsers();
//		String userList = "<ul>";
//		for (User v: users) {
//			userList = userList + "<li>" + v.getUsername() + "</li>";
//		}
//		userList = userList + "</ul>";
//
//		PrintWriter out = response.getWriter();
//		response.setContentType("text/html");
//		out.print(userList);
	}
}
