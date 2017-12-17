package com.ex.servlet;

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
import com.rev.pojos.Reimbursement;
import com.rev.pojos.Users;
import com.rev.service.Service;

@WebServlet("/updateservlet")
public class UpdateServlet extends HttpServlet{
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
		Users user = mapper.readValue(json, Users.class);

		HttpSession session = req.getSession();
		Users u = (Users) session.getAttribute("user");
		service.updateProfile(u.getUsers_id(), user.getFirstname(), user.getLastname(),
				user.getEmail());
		
		
	}
}
