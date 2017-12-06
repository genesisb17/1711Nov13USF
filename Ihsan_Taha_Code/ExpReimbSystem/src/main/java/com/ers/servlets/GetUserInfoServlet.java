package com.ers.servlets;

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

import com.ers.pojos.User;
import com.ers.util.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/GetUserInfoServlet")
public class GetUserInfoServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String json = "";
		if (br != null)
			json = br.readLine();

		ObjectMapper mapper = new ObjectMapper();
		String[] userInfo = mapper.readValue(json, String[].class);

		String username = userInfo[0];
		String password = userInfo[1];

		Service service = new Service();
		User user = new User();
		user.setUserName(username);
		user.setPassWord(password);
		user = service.getUser(user);

		if (user != null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			user = (User) session.getAttribute("user");

			mapper = new ObjectMapper();
			json = mapper.writeValueAsString(user);

			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			out.write(json);
		} else
		{
			response.sendRedirect("index.html");
		}
	}
}
