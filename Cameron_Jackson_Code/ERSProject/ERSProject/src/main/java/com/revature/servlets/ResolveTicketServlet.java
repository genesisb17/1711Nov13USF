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

@WebServlet("/resolveticket")
public class ResolveTicketServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ERSService service = new ERSService();
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		if (br !=null) {
			json = br.readLine();
		}
		
//		System.out.println("resolveticket: " + json);
		ObjectMapper mapper = new ObjectMapper();
		String[] data = mapper.readValue(json, String[].class);
		
		HttpSession session = req.getSession();
		Users resolver = (Users) session.getAttribute("user");
		ReimbursementStatus status = ReimbursementStatus.valueOf(data[1].toUpperCase());
		
		Reimbursement r = new Reimbursement();
		r = service.resolveTicket(Integer.parseInt(data[0]), status, resolver.getUserId());
//		System.out.println(r);
		Users author = service.getUser(r.getAuthor());
		String resolverStr = null;
		String authorStr = null;
		if (resolver != null)
			resolverStr = resolver.getFirstName() + " " + resolver.getLastName();
		if (author != null)
			authorStr = author.getFirstName() + " " + author.getLastName();
		ReimbDTO rdto = new ReimbDTO(
				r.getReimbId(), 
				r.getAmount(), 
				r.getSubmitted(), 
				r.getResolved(), 
				r.getDescription(), 
				authorStr, 
				resolverStr,
				service.getStatus(r.getStatusId()), 
				service.getType(r.getTypeId()));
		
		StringBuilder toClient = new StringBuilder();
		toClient.append("["+mapper.writeValueAsString(rdto)+"]");
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.println(toClient);
//		System.out.println(toClient);
	}
}
