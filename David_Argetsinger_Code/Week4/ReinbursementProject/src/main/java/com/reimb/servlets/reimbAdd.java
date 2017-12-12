package com.reimb.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimb.pojos.Reimburse;
import com.reimb.pojos.User;
import com.reimb.service.Service;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({"/reimbAdd"})
public class reimbAdd extends HttpServlet
{
	public reimbAdd() {}

	static Service service = new Service();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
		System.out.println("Please register servlet");
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(request.getInputStream()));
		String json = "";
		if (br != null) {
			json = br.readLine();
		}
		ObjectMapper mapper = new ObjectMapper();
		Reimburse reimb = (Reimburse)mapper.readValue(json, Reimburse.class);

		HttpSession session = request.getSession();
		User ogU = (User)session.getAttribute("user");

		reimb.setAuthor(ogU.getId());
		reimb.setStatus(0);
		service.addReim(reimb);
		service.usersRiembs(ogU);

	}
}