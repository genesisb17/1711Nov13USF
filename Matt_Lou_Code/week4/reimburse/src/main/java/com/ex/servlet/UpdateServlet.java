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
import com.rev.pojos.Reimbursement;
import com.rev.pojos.Users;

@WebServlet("/updateservlet")
public class UpdateServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		Reimbursement reimb = new Reimbursement();
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		if(br != null) {
			json = br.readLine();
		}
		System.out.println("in update servlet");
		System.out.println(json);
		ObjectMapper mapper = new ObjectMapper();
		
		String values = mapper.readValue(json, String.class);
		System.out.println(values);
		
		HttpSession session = req.getSession();
		Users user = (Users) session.getAttribute("user");
		
		
	}
}
