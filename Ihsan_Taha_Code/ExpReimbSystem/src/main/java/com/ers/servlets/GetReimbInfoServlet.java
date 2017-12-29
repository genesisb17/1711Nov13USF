package com.ers.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

@WebServlet("/GetReimbInfoServlet")
public class GetReimbInfoServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));

		String json = "";

		if (br != null)
			json = br.readLine();

		ObjectMapper mapper = new ObjectMapper();
		Reimbursement reimb = mapper.readValue(json, Reimbursement.class);

		Service service = new Service();
		reimb = service.getReimb(reimb.getReimbId());
		
		HttpSession sessionReimb = request.getSession();
		sessionReimb.setAttribute("reimb", reimb);
		
		mapper = new ObjectMapper();
		json = mapper.writeValueAsString(reimb);

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		out.write(json);
	}
}