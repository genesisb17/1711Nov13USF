package com.rev.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.pojos.SpecTicket;
import com.rev.pojos.User;
import com.rev.service.Service;

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {
	static Service service = new Service();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		System.out.println("in Manager servlet");

		// 1. get received JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		if (br != null) {
			json = br.readLine();
		}
		System.out.println("JSON STRING: " + json);
		ObjectMapper mapper = new ObjectMapper();
		
		List<SpecTicket> testing = new ArrayList<>();
		testing=service.getUserTickets(user.getUser_ID());
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		String jsonString = mapper.writeValueAsString(testing);
		System.out.println(jsonString);
		
		System.out.println("testing in manager");
		out.println(jsonString);
	}
}
