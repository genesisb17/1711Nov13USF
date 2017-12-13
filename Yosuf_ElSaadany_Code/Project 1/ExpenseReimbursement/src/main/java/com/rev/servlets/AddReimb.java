package com.rev.servlets;

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
import com.rev.pojos.Reimbursement;
import com.rev.pojos.User;
import com.rev.service.EmployeeService;

@WebServlet("/AddReimb")
public class AddReimb extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	static EmployeeService empservice = new EmployeeService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

		// 1. get received JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		
		String json = "";
		if(br != null) {
			json = br.readLine();
		}
		
		System.out.println("JSON STRING: " + json);

		// 2. initiate jackson mapper
		ObjectMapper mapper = new ObjectMapper();

		//// 3. Convert received JSON to String array
		String[] userInfo = mapper.readValue(json, String[].class);
		
		String username = userInfo[0];
		double amount = Double.parseDouble(userInfo[1]);
		String typeID = userInfo[2];
		String description = userInfo[3];
		
		int type = 0;
		switch(typeID) {
		case "Food":
			type = 1;
			break;
		case "Travel":
			type = 2;
			break;
		case "Lodging":
			type = 3;
			break;
		case "Other":
			type = 4;
		}
		
		Reimbursement r = new Reimbursement();
		r.setAmount(amount);
		r.setType(type);
		r.setDescription(description);
		
		User u = new User();
		u.setUsername(username);
		
		r = empservice.addReimbursement(r, u);		
			
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
				
		String userJSON = mapper.writeValueAsString(r);		
		out.write(userJSON);	
	}
}
