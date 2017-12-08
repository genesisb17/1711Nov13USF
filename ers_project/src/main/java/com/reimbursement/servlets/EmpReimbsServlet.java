package com.reimbursement.servlets;

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
//import com.reimbursement.dto.DTO;
import com.reimbursement.pojos.Employee;
import com.reimbursement.pojos.Reimbursement;
import com.reimbursement.services.Services;

/**
 * Servlet implementation class empReimbs
 */
@WebServlet("/EmpReimbsServlet")
public class EmpReimbsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Services serv = new Services();
		HttpSession session = request.getSession();
		Employee emp = (Employee) session.getAttribute("user");
		ArrayList<Reimbursement> reimbs = serv.getRById(emp.getUserId());
		StringBuilder json = null;
		ObjectMapper mapper = new ObjectMapper();
		if (!reimbs.isEmpty()) {
			json = new StringBuilder();
			json.append("[");
			for (Reimbursement result: reimbs) {
				json.append(mapper.writeValueAsString(result));
				json.append(",");
			}
			json.replace(json.lastIndexOf(","), json.length(), "]");
		}
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		out.println(json);	

	}

}
