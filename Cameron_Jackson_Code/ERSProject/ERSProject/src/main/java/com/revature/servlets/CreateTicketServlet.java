package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

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
import com.revature.types.ReimbursementStatus;

@WebServlet("/createticket")
public class CreateTicketServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ERSService service = new ERSService();
		ObjectMapper mapper = new ObjectMapper();
		
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		if (br !=null) 
			json = br.readLine();
		
		Reimbursement ticket = mapper.readValue(json, Reimbursement.class);
		HttpSession session = req.getSession();
		Users u = (Users)session.getAttribute("user");
		ticket.setAuthor(u.getUserId());
		ticket.setStatusId(ReimbursementStatus.PENDING.ordinal()+1);
//		System.out.println(ticket);
		Reimbursement r = new Reimbursement();
		r = service.addTicket(ticket);
//		System.out.println("Create Ticket servlet: " + newTicket);
		String authorStr = u.getFirstName() + " " + u.getLastName();
		String resolverStr = null;
		Users resolver = service.getUser(r.getResolver());
		if (resolver != null) 
			resolverStr = resolver.getFirstName() + " " + resolver.getLastName();
		ReimbDTO rdto = new ReimbDTO(r.getReimbId(), r.getAmount(), r.getSubmitted(), 
						r.getResolved(), r.getDescription(), authorStr, resolverStr, 
						service.getStatus(r.getStatusId()), service.getType(r.getTypeId()));
//		System.out.println("create ticket: "+ rdto);
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.println(mapper.writeValueAsString(rdto));
	}
}
