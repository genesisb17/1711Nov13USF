package com.ers.servlets;

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

import com.ers.pojos.Author;
import com.ers.pojos.Reimbursement;
import com.ers.pojos.User;
import com.ers.util.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/GetAuthorServlet")
public class GetAuthorServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{	
		System.out.println("In GetAuthorServlet");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));

		String json = "";

		if (br != null)
			json = br.readLine();

		ObjectMapper mapper = new ObjectMapper();
		Author author = mapper.readValue(json, Author.class);

		System.out.println(author.getAuthorId());
		
		Service service = new Service();
		User user = service.getUserById(author.getAuthorId());

		author.setAuthorName(user.getFirstName());
		
		System.out.println(author.getAuthorName());
		
		HttpSession sessionReimb = request.getSession();
		sessionReimb.setAttribute("author", author);

		json = mapper.writeValueAsString(author);

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		out.write(json);
	}
}
