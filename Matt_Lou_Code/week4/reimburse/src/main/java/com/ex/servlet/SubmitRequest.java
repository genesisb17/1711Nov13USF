package com.ex.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.pojos.Reimbursement;
import com.rev.pojos.Users;
import com.rev.service.Service;

@WebServlet("/submitrequest")
public class SubmitRequest extends HttpServlet{
	
	static Service service = new Service();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException {
		System.out.println("here");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		System.out.println("after bufferedreader");
		String json = "";
		
		if(br != null) {
			json = br.readLine();
		}
		HttpSession session = req.getSession(false);
		Users user = (Users) session.getAttribute("user");
		//System.out.println(user.toString());
		System.out.println("in submit request, " + user.getUsers_id());
		
		System.out.println("submit request servlet");
		ObjectMapper mapper = new ObjectMapper();
		Reimbursement reimburse = mapper.readValue(json, Reimbursement.class);

		service.submitRequest(reimburse.getAmount(), reimburse.getDescription(),
				user.getUsers_id(), reimburse.getType_id());
		
	}
}






