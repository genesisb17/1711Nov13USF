package com.real.servlets;

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
import com.real.pojos.TableRow;
import com.real.pojos.User;
import com.real.util.Service;

@WebServlet("/getTableInfo")
public class GetTableInfoServlet extends HttpServlet {
	
	static Service service = new Service();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		ArrayList<TableRow> tableVals = service.getReimbursements(user);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(tableVals);
			
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.write(json);
	}
}