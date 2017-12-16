package com.ers.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

@WebServlet("/UpdateReimbServlet")
public class UpdateReimbServlet extends HttpServlet
{
	static Service service = new Service();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		
		String json = "";
		
		if (br != null)
			json = br.readLine();

		ObjectMapper mapper = new ObjectMapper();
		Reimbursement reimb = mapper.readValue(json, Reimbursement.class);
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		service.updateReimbByManager(user, reimb.getReimbStatusId(), reimb.getReimbId());
	}
}
