package com.rev.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.pojos.User;
import com.rev.service.Service;

@WebServlet("/resolve")
public class ResolveServlet extends HttpServlet {
	static Service service = new Service();
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Timestamp time=new Timestamp(System.currentTimeMillis());
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		System.out.println("in login servlet");

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
		String[] optionInfo = mapper.readValue(json, String[].class);
		System.out.println(json);
		int option = Integer.parseInt(optionInfo[0]);
		System.out.println(option);
		int id = Integer.parseInt(optionInfo[1]);
		System.out.println(id);
		service.setTicket(id, user.getUser_ID(), time, option);
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		String jsonString = mapper.writeValueAsString(option);
		
		System.out.println("testing in manager");
		out.println(jsonString);
		
	}
}
