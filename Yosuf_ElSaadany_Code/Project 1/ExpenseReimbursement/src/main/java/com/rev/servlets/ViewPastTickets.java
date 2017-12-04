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
import com.rev.pojos.Reimbursement;
import com.rev.pojos.User;
import com.rev.service.EmployeeService;

@WebServlet("/ViewPastTickets")
public class ViewPastTickets extends HttpServlet{

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
		
		User u = new User();
		u.setUsername(username);
		
		ArrayList<Reimbursement> arr = new ArrayList<Reimbursement>();
		
		arr = empservice.viewPastTickets(u);
				
		// No Past Tickets for this user
		if(arr == null)
			System.out.println("Servlet NULL");
		// Valid credentials
		else {
			HttpSession session = req.getSession();
			session.setAttribute("user", arr);//persist this user to the session to be accessed throughout servlets
			System.out.println("Success");
		}
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
				
		String userJSON = mapper.writeValueAsString(arr);		
		out.write(userJSON);
	}	

}
