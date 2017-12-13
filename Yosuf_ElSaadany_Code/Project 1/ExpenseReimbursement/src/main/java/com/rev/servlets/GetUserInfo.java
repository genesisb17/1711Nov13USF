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
import com.rev.DTOs.PastReimbursementsDTO;
import com.rev.pojos.Reimbursement;
import com.rev.pojos.User;
import com.rev.service.EmployeeService;

@WebServlet("/getUserInfo")
public class GetUserInfo extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EmployeeService EmployeeService = new EmployeeService();
		
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
				
		if(user != null) {
			// Get User's Past Reimbursement Tickets
			ArrayList<Reimbursement> pastTickets = EmployeeService.viewPastTickets(user);
						
			// Store User info along with his past reimbursements in DTO
			PastReimbursementsDTO DTO = new PastReimbursementsDTO(user, pastTickets);
			
			//PastReimbursementsDTO DTO = EmployeeService.viewPastTickets(user);
			
			ObjectMapper mapper = new ObjectMapper();
			String JSON = mapper.writeValueAsString(DTO);
			
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			out.write(JSON);
		}
		else {
			resp.setStatus(418);
		}
	
	}
}
