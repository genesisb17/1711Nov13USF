package com.ex.servlet;

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
import com.rev.pojos.Users;
import com.rev.service.Service;

@WebServlet("/updatestatusservlet")
public class UpdateStatusServlet extends HttpServlet{
	public static Service service = new Service();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		if(br != null) {
			json = br.readLine();
		}

		ObjectMapper mapper = new ObjectMapper();
		String value[] = mapper.readValue(json, String[].class);


		HttpSession session = req.getSession();
		Users u = (Users) session.getAttribute("user");
		service.callUpdate(u.getUsers_id(), Integer.parseInt(value[1]),
				Integer.parseInt(value[2]));
	}
}
