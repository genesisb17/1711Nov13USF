package com.rev.project1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rev.project1.domain.Reimbursement;
import com.rev.project1.service.FormatTickets;
import com.rev.project1.service.Service;

@WebServlet("/getAllReimb")
public class GetAllReimbServlet extends HttpServlet {
	static Service service = new Service();
	static FormatTickets format = new FormatTickets();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		
		List<Reimbursement> reimbs = service.viewAllRequests();
		String json = "";
		
		if (reimbs.size() == 0) {
			json = "[]";	
		} else {
			int index = 0;
			while(index < reimbs.size()) {
				json += format.manView(reimbs.get(index)) + ",";
				index++;
			}
			json = "[" + json.substring(0, json.length()-1) + "]";
		}
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.write(json);	
	}
}
