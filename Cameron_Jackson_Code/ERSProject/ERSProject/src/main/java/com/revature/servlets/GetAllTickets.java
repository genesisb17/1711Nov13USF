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

@WebServlet("/getalltickets")
public class GetAllTickets extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		ERSService service = new ERSService();
		HttpSession session = req.getSession();
		Users u = (Users)session.getAttribute("user");
		ArrayList<Reimbursement> reimbs = new ArrayList<>();
		// Check if user is a manager, if so then return all tickets
		// otherwise return their past tickets
		if (u.getRoleId() == 1)
			reimbs = null;
		else if (u.getRoleId() == 2)
			reimbs = service.getAllTickets();

		// add information to DTO with author, resolver, status, and type info
		ArrayList<ReimbDTO> tickets = new ArrayList<>();
		if (reimbs != null) {
//			int count = 1;
			for (Reimbursement r: reimbs) {
//				System.out.println(r);
				Users resolver = service.getUser(r.getResolver());
				Users author = service.getUser(r.getAuthor());
//				System.out.println(resolver);
//				System.out.println(author);
				String resolverStr = null;
				String authorStr = null;
				if (resolver != null)
					resolverStr = resolver.getFirstName() + " " + resolver.getLastName();
				if (author != null)
					authorStr = author.getFirstName() + " " + author.getLastName();
//				System.out.println(count++ + ": " + r);
				if (!r.getAuthor().equals(u.getUserId()))  {
					ReimbDTO rdto = new ReimbDTO(r.getReimbId(), r.getAmount(), r.getSubmitted(), 
							r.getResolved(), r.getDescription(), authorStr, resolverStr, 
							service.getStatus(r.getStatusId()), service.getType(r.getTypeId()));
					//				rdto.setReimb(r);
					//				rdto.setAuthor(authorStr);
					//				rdto.setResolver(resolverStr);
					//				rdto.setStatus(service.getStatus(r.getStatusId()));
					//				rdto.setType(service.getType(r.getTypeId()));
					tickets.add(rdto);
				}

			}
		}

		StringBuilder json = null;
		ObjectMapper mapper = new ObjectMapper();
		if (!tickets.isEmpty()) {
			json = new StringBuilder();
			json.append("["); // have to make a custom json string since an ArrayList can't be converted easily
			for (ReimbDTO t: tickets) {
				json.append(mapper.writeValueAsString(t));
				json.append(",");
			}
			json.replace(json.lastIndexOf(","), json.length(), "]");
		}
		System.out.println(json);
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.println(json);		
	}
}
