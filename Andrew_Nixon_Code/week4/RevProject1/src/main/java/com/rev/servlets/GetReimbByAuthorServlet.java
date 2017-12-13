package com.rev.servlets;

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
import com.rev.pojos.ERSUser;
import com.rev.pojos.Reimbursement;
import com.rev.service.Service;

@WebServlet("/getReimbByAuthor")
public class GetReimbByAuthorServlet extends HttpServlet{
	static Service service = new Service();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		ERSUser user = (ERSUser) session.getAttribute("user");
		ArrayList<Reimbursement> reimbs = service.getReimbsByAuthor(user.getUserID());
		
		//if ((user != null) && (reimbs != null) && (!reimbs.isEmpty())) {
		if ((user != null)) {
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(reimbs);

			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			out.write(json);
		} //else if ((user != null) && (reimbs != null) && (reimbs.isEmpty())){} 
		else {
			resp.setStatus(418);
		}
		
	}

}
