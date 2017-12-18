package com.rev.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.dtos.ManagerReimbursementsDTO;
import com.rev.service.Service;

@WebServlet("/managerTable")
public class CreateMangerTableServlet extends HttpServlet {
	static Service service = new Service();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<ManagerReimbursementsDTO> arrayList = service.getManagerReimbursements();
		ObjectMapper mapper = new ObjectMapper();
		resp.setContentType("application/json");
		String json = mapper.writeValueAsString(arrayList);
		PrintWriter out = resp.getWriter();
		out.write(json);
	}

}
