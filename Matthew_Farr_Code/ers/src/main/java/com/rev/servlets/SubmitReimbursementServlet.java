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
import com.rev.pojos.Reimbursement;
import com.rev.pojos.ReimbursementSubmission;
import com.rev.pojos.User;
import com.rev.service.Service;

@WebServlet("/submit")
public class SubmitReimbursementServlet extends HttpServlet {

	static Service service = new Service();

	// so the compiler won't yell at me
	private static final long serialVersionUID = -7695443032906523931L;

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
		
		ReimbursementSubmission rs = mapper.readValue(json, ReimbursementSubmission.class);
		System.out.println(rs.toString());

		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		
		Reimbursement inserted = service.addReimbursement(user, rs.getAmount(), rs.getDescription(), rs.getTypeId());

		String reimbJSON = mapper.writeValueAsString(inserted);
		System.out.println("JSON: " + reimbJSON);
		out.write(reimbJSON);
	}

}
