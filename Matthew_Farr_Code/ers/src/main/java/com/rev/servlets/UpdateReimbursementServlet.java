package com.rev.servlets;

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
import com.rev.pojos.ReimbursementUpdate;
import com.rev.pojos.User;
import com.rev.service.Service;

@WebServlet("/update")
public class UpdateReimbursementServlet extends HttpServlet {

	static Service service = new Service();
	
	// so the compiler won't complain
	private static final long serialVersionUID = -8404273901551183661L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in submit reimbursements servlet");

		// get received JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		if (br != null) {
			json = br.readLine();
		}
		System.out.println("JSON STRING: " + json);

		// initiate jackson object mapper
		ObjectMapper mapper = new ObjectMapper();
		
		// Get user from session object
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		
		ReimbursementUpdate rs = mapper.readValue(json, ReimbursementUpdate.class);
		System.out.println(rs.toString());

		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		
		service.updateReimbursement(user, rs.getReimbursementId(), rs.getStatusId());;

		String reimbJSON = mapper.writeValueAsString(true);
		System.out.println("JSON: " + reimbJSON);
		out.write(reimbJSON);
	}
}
