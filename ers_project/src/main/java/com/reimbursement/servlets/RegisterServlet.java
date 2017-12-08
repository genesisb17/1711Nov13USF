package com.reimbursement.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimbursement.pojos.Employee;
import com.reimbursement.services.Services;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	static Services serv = new Services();
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		if(br != null){
			json = br.readLine();
		}
		
		System.out.println(json);
		ObjectMapper mapper = new ObjectMapper();
		
		Employee e = mapper.readValue(json, Employee.class);
		e = serv.addUser(e);
		PrintWriter out = resp.getWriter();
		
		resp.setContentType("application/json");
		
		String userJSON = mapper.writeValueAsString(e);
		out.write(userJSON);
	}
}
