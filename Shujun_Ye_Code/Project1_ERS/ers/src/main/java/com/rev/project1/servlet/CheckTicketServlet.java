package com.rev.project1.servlet;

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
import com.rev.project1.service.Service;

@WebServlet("/checkTicket")
public class CheckTicketServlet extends HttpServlet {
	static Service service = new Service();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// 1. get received JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
				
		String json = "";
		if(br != null) {
			json = br.readLine();		
		}
		
		int proceedRequest = 0;
		// 2. initiate jackson mapper
		ObjectMapper mapper = new ObjectMapper();
		
		// 3. Convert received JSON to int
		String[] ticket = mapper.readValue(json, String[].class);
		int reimbId = Integer.parseInt(ticket[0]);
		int managerId = Integer.parseInt(ticket[1]);
		int reimbAuthorId = service.getReimbAuthor(reimbId);
		if (managerId != reimbAuthorId) {
			proceedRequest = 1;
		}
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		
		String process = mapper.writeValueAsString(proceedRequest);
		out.write(process);	
	}

}
