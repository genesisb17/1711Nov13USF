package com.rev.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.pojos.Reimbursement;
import com.rev.pojos.User;
import com.rev.service.Service;

@WebServlet("/reimbursements")
public class GetReimbursementsServlet extends HttpServlet {
	
	static Service service = new Service();

	// So the compiler won't complain
	private static final long serialVersionUID = 4460237015815171383L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		System.out.println("in reimbursements servlet");
		
		ObjectMapper mapper = new ObjectMapper();
		
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		
		System.out.println(user.toString());
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		
		List<Reimbursement> userReimbursements = service.getUserReimbursements(user);

		String reimbJSON = mapper.writeValueAsString(userReimbursements);
		System.out.println("JSON: " + reimbJSON);
		out.write(reimbJSON);
	}

}
