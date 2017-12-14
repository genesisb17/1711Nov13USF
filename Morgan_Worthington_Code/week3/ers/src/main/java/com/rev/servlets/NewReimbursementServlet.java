package com.rev.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.pojos.User;
import com.rev.service.Service;

@WebServlet("/newReimbursement")
public class NewReimbursementServlet extends HttpServlet {
	static Service service=new Service();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json="";
		if(br!=null) {
			json=br.readLine();
		}
		
		ObjectMapper om=new ObjectMapper();
		JsonNode reimbursement=om.readTree(json);
		String amount=reimbursement.get("amount").asText();
		String description=reimbursement.get("description").asText();
		String type=reimbursement.get("type").asText();
		
		HttpSession session=req.getSession();
		User u= (User) session.getAttribute("user");
		int id=u.getId();
		String author=Integer.toString(id);
		
		String[] reimbInfo= {amount, description, author, type};
		service.addReimbursement(reimbInfo);
	}
}
