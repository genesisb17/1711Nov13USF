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

@WebServlet("/PostReimbServlet")
public class PostReimbServlet extends HttpServlet
{
	static Service service = new Service();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("In Submit");
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		
		String json = "";
		
		if (br != null)
			json = br.readLine();

		ObjectMapper mapper = new ObjectMapper();
		Reimbursement reimb = mapper.readValue(json, Reimbursement.class);
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		reimb = service.addReimb(user, reimb);
		
		if (reimb != null)
			System.out.println("Successful Reimbursement");
		else
			System.out.println("Error, could not enter new request.");
	}
}
