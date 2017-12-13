package com.rev.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.DTOs.ManagerTicketInfo;
import com.rev.service.ManagerService;

@WebServlet("/ManagerViewAll")
public class ManagerView extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ManagerService ManagerService = new ManagerService();
		
		ArrayList<ManagerTicketInfo> arr = new ArrayList<ManagerTicketInfo>();
		
		arr = ManagerService.managerTicketInfo();
		
		System.out.println("ARRAY LIST: " + arr);			
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
			
		ObjectMapper mapper = new ObjectMapper();
		String userJSON = mapper.writeValueAsString(arr);		
		out.write(userJSON);
		
	}
}
