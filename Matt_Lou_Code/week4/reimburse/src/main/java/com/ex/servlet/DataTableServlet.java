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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.pojos.Reimbursement;
import com.rev.pojos.ReimbursementNames;
import com.rev.service.Service;

@WebServlet("/datatable")
public class DataTableServlet extends HttpServlet{
	
	static Service service = new Service();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		
		ReimbursementNames reimb = new ReimbursementNames();
		
		ArrayList<ReimbursementNames> data = service.getdata();
		PrintWriter out = resp.getWriter();
		
		resp.setContentType("application/json");
		
		ObjectMapper mapper = new ObjectMapper();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm a z");
		mapper.setDateFormat(df);
		String json = mapper.writeValueAsString(data);

		out.write(json);
	}
}