package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.Users;
import com.revature.service.ERSService;

@WebServlet("/create-account")
public class CreateAccountServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		ERSService service = new ERSService();
		// 1. get received JSON data from request
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		if (br !=null) {
			json = br.readLine();
		}
		System.out.println("JSON STRING: " + json);

		// 2. initiate jackson mapper
		ObjectMapper mapper = new ObjectMapper();
		
		// 3. Convert received JSON to String array
		Users u = mapper.readValue(json, Users.class);
		
	}
}
