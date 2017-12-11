package com.rev.servlets;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.pojos.Reimbursement;
import com.rev.pojos.User;
import com.rev.service.Service;

@WebServlet("/newReimbursement")
public class NewReimbursementServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	static Service service = new Service();
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("in new reimbursement servlet");

		BufferedReader br = 
				new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		if(br != null){
			json = br.readLine();
		}
		System.out.println(json);
		
		ObjectMapper mapper = new ObjectMapper();
		
		Reimbursement r = mapper.readValue(json, Reimbursement.class);
		
		HttpSession session = req.getSession();
		User u = (User) session.getAttribute("user");
		
		r.setAuthor(u.getId());
		
		System.out.println("after mapper");
		r = service.addReimbursement(r);
		System.out.println("after service");
		PrintWriter out = resp.getWriter();
		
		resp.setContentType("application/json");
		
		String userJSON = mapper.writeValueAsString(r);
		out.write(userJSON);
	}

}
