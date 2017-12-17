package com.ers.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.pojos.Reimbursement;
import com.ers.pojos.User;
import com.ers.util.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/GetReimbListServlet")
public class GetReimbListServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Service service = new Service();
		ArrayList<Reimbursement> reimbs = new ArrayList<>();

		HttpSession sessionUser = request.getSession();
		User user = (User) sessionUser.getAttribute("user");

		if (user.getRoleId() == 1)
			reimbs = service.getReimbByUser(user);
		else
			reimbs = service.getAllReimb();

		HttpSession sessionReimbList = request.getSession();
		sessionReimbList.setAttribute("reimbs", reimbs);

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(reimbs);

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		out.write(json);
	}
}
