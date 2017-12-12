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
import com.revature.types.ReimbursementStatus;

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
		if (reimbs != null) {
			int count = 1;
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
				ReimbDTO rdto = new ReimbDTO(
						r.getReimbId(), 
						r.getAmount(), 
						r.getSubmitted(), 
						r.getResolved(), 
						r.getDescription(), 
						authorStr, 
						resolverStr, 
						r.getStatusId(), 
						service.getType(r.getTypeId()));
				//				rdto.setReimb(r);
				//				rdto.setAuthor(authorStr);
				//				rdto.setResolver(resolverStr);
				//				rdto.setStatus(service.getStatus(r.getStatusId()));
				//				rdto.setType(service.getType(r.getTypeId()));
				tickets.add(rdto);
			}
		}

		StringBuilder json = null;
		ObjectMapper mapper = new ObjectMapper();
		if (!tickets.isEmpty()) {
			json = new StringBuilder();
			json.append("{\"data\":["); // have to make a custom json string since an ArrayList can't be converted easily
			for (ReimbDTO t: tickets) {
				json.append("{\"reimbursements\":");
				json.append(mapper.writeValueAsString(t));
				json.append(",");
				json.append("\"r_status\":");
				json.append(mapper.writeValueAsString(ReimbursementStatus.valueOf(service.getStatus(t.getStatus()))));
				json.append("},");
			}
			json.replace(json.lastIndexOf(","), json.length(), "],");
			json.append("\"options\":{\"reimbursements.status\":[");
			json.append(mapper.writeValueAsString(ReimbursementStatus.PENDING)+",");
			json.append(mapper.writeValueAsString(ReimbursementStatus.APPROVED)+",");
			json.append(mapper.writeValueAsString(ReimbursementStatus.DENIED)+"]}}");
		}
//		System.out.println(json);
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.println(json);		
	}
}
