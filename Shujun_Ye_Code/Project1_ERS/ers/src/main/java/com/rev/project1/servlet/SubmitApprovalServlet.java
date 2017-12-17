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

@WebServlet("/submitApproval")
public class SubmitApprovalServlet extends HttpServlet {
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

		// 2. initiate jackson mapper
		ObjectMapper mapper = new ObjectMapper();
				
		// 3. Convert received JSON to reimbId, userId, reimbStatus
		String[] ticket = mapper.readValue(json, String[].class);
		int reimbId = Integer.parseInt(ticket[0]);
		int userId = Integer.parseInt(ticket[1]);
		int reimbStatus = Integer.parseInt(ticket[2]);
		
		service.authorizedRequest(reimbId, userId, reimbStatus);
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		
		String process = mapper.writeValueAsString("Successfully update!");
		out.write(process);	
	}

}
