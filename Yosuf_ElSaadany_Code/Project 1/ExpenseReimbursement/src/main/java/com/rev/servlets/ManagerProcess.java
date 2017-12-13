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
import com.rev.service.ManagerService;

@WebServlet("/process")
public class ManagerProcess extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ManagerService ManagerService = new ManagerService();

		// 1. get received JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		
		String json = "";
		if(br != null) {
			json = br.readLine();
		}
				
		// 2. initiate jackson mapper
		ObjectMapper mapper = new ObjectMapper();
		String[] processed = mapper.readValue(json, String[].class);
		
		int reimbID = Integer.parseInt(processed[0]);
		int status = Integer.parseInt(processed[1]);
		int resolver_ID = Integer.parseInt(processed[2]);
		
		int result = ManagerService.processRequest(status, reimbID, resolver_ID);
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
			
		String userJSON = mapper.writeValueAsString(result);		
		out.write(userJSON);
		
	}
}
