package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dto.ReimbDTO;
import com.revature.pojos.Reimbursement;
import com.revature.pojos.Users;
import com.revature.service.ERSService;

@WebServlet("/getemployeetickets")
public class GetEmployeeTickets extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ERSService service = new ERSService();
		
		HttpSession session = req.getSession();
		Users u = (Users)session.getAttribute("user");
		int userId = u.getUserId();
		ArrayList<Reimbursement> reimbs = new ArrayList<>();
		// Check if user is a manager, if so then return all tickets
		// otherwise return their past tickets
		if (u.getRoleId() == 1)
			reimbs = service.getPastTickets(userId);
		else if (u.getRoleId() == 2)
			reimbs = service.getAllTickets();
		
		// add information to DTO with author, resolver, status, and type info
		ArrayList<ReimbDTO> tickets = new ArrayList<>();
		for (Reimbursement r: reimbs) {
			Users resolver = new Users();
			Users author = new Users();
			resolver = service.getUser(r.getResolver());
			author = service.getUser(r.getAuthor());
			ReimbDTO rdto = new ReimbDTO();
			rdto.setReimb(r);
			rdto.setAuthor(author);
			rdto.setResolver(resolver);
			rdto.setStatus(service.getStatus(r.getStatusId()));
			rdto.setType(service.getType(r.getTypeId()));
			tickets.add(rdto);
		}
		
		
		StringBuilder json = new StringBuilder();
		json.append("["); // have to make a custom json string since an ArrayList can't be converted easily
		ObjectMapper mapper = new ObjectMapper();
		for (ReimbDTO t: tickets) {
			json.append(mapper.writeValueAsString(t));
			json.append(",");
		}
		json.replace(json.lastIndexOf(","), json.length(), "]");
//		System.out.println(json);
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.println(json);		
	}
}
