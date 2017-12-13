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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.DTOs.ManagerTicketInfo;
import com.rev.pojos.ReimbursementStatus;
import com.rev.service.ManagerService;

@WebServlet("/ManagerFiltered")
public class ManagerFiltered extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		ManagerService ManagerService = new ManagerService();
		System.out.println(req.toString());
		// 1. get received JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		
		String json = "";
		if(br != null) {
			json = br.readLine();
		}
				
		System.out.println("THE JSON STRING: " + json);

		// 2. initiate jackson mapper
		ObjectMapper mapper = new ObjectMapper();
		String[] userInfo = mapper.readValue(json, String[].class);
		
		int status = Integer.parseInt(userInfo[0]);		
		
		ReimbursementStatus rs = new ReimbursementStatus();
		rs.setStatus_id(status);
		
		ArrayList<ManagerTicketInfo> arr = new ArrayList<ManagerTicketInfo>();

		arr = ManagerService.filterByStatus(rs);
		
		/*ArrayList<Reimbursement> arr = new ArrayList<Reimbursement>();

		arr = ManagerService.filterByStatus(rs);*/
		System.out.println("THE ARRAY LIST: " + arr);			
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
			
		String userJSON = mapper.writeValueAsString(arr);		
		out.write(userJSON);
		
	}

}
