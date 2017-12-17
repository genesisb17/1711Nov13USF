package com.ex.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.pojos.Reimbursement;
import com.rev.pojos.ReimbursementNames;
import com.rev.pojos.Users;
import com.rev.service.Service;

@WebServlet("/viewrequest")
public class ViewRequest extends HttpServlet{
	
	static Service service = new Service();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		
		ReimbursementNames reimb = new ReimbursementNames();
		HttpSession session = req.getSession();
		Users user = (Users)session.getAttribute("user");

		ArrayList<ReimbursementNames> data = service.getUserViewData(user.getUsers_id());
		PrintWriter out = resp.getWriter();
		
		resp.setContentType("application/json");
		

		
		ObjectMapper mapper = new ObjectMapper();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm a z");
		mapper.setDateFormat(df);
		String json = mapper.writeValueAsString(data);

		out.write(json);
	}
}

