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
import com.rev.dto.DTO;
import com.rev.pojos.Reimbursement;
import com.rev.pojos.User;
import com.rev.service.Service;

@WebServlet("/employeeReimbursements")
public class EmployeeReimbursementsServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Service service = new Service();
		HttpSession session = req.getSession();
		User u = (User) session.getAttribute("user");
		DTO dto = (DTO) session.getAttribute("dto");
		
		ArrayList<Reimbursement> reimbs = service.getUserReimbursements(u.getId());
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		
		ObjectMapper mapper = new ObjectMapper();
		String userJSON = mapper.writeValueAsString(reimbs);
		out.write(userJSON);
	}
}
