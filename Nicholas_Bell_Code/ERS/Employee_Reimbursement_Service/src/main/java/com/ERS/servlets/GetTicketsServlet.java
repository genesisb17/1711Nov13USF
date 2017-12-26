package com.ERS.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ERS.pojos.ReimbRow;
import com.ERS.pojos.Reimbursement;
import com.ERS.pojos.User;
import com.ERS.service.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/GetTickets")
public class GetTicketsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Service service = new Service();
		HttpSession session = req.getSession();
		User u = (User)session.getAttribute("user");
		boolean manager;
		ArrayList<ReimbRow> tickets = new ArrayList<>();
		if (u != null) {
			manager = u.getRole();
			if(manager) {
				tickets = service.getAllTickets();
			}
			else {
				tickets = service.getTickets(u);
			}
		}
	
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		
		if (!tickets.isEmpty()) {
			json = mapper.writeValueAsString(tickets);
		}
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.println(json);		
	}
}