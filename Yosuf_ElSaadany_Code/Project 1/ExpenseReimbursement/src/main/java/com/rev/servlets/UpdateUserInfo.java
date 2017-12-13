package com.rev.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.DTOs.PastReimbursementsDTO;
import com.rev.pojos.Reimbursement;
import com.rev.pojos.User;
import com.rev.service.EmployeeService;

@WebServlet("/updateInfo")
public class UpdateUserInfo extends HttpServlet{

	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// GET USER INFO FROM CURRENT SESSION
		HttpSession session = req.getSession();
		User olduser = (User) session.getAttribute("user");
		
		// 1. get received JSON data from request (NEW USER INFO)
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		
		String json = "";
		if(br != null) {
			json = br.readLine();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		String[] userInfo = mapper.readValue(json, String[].class);
		
		String username = userInfo[0];
		String password = userInfo[1];
		String firstname = userInfo[2];
		String lastname = userInfo[3];
		String email = userInfo[4];
		
		User newuser = new User();
		
		newuser.setUsername(username);
		newuser.setPassword(password);
		newuser.setFirstname(firstname);
		newuser.setLastname(lastname);
		newuser.setEmail(email);
		
		EmployeeService EmployeeService = new EmployeeService();
		
		User x = new User();
		x = EmployeeService.Update(newuser, olduser);

		if(x != null) {
			HttpSession session1 = req.getSession();
			session1.setAttribute("user", x);
		}
		
		String userJSON = mapper.writeValueAsString(x);
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.write(userJSON);
	}
}
