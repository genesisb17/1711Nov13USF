package com.ers.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.pojos.User;
import com.ers.util.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet
{
	static Service service = new Service();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		
		String json = "";
		
		if (br != null)
			json = br.readLine();

		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(json, User.class);
		user = service.addUser(user);
	}
}