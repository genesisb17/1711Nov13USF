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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.pojos.Reimbursement;
import com.rev.pojos.User;
import com.rev.service.Service;

@WebServlet("/updateReimbursement")
public class UpdateReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Service service = new Service();
		
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		if(br != null){
			json = br.readLine();
		}
		ObjectMapper mapper = new ObjectMapper();
		
		int[] values = mapper.readValue(json, int[].class);
		int index = values[0];
		int status = values[1];
		
		int resolver = ((User) req.getSession().getAttribute("user")).getId();
		
		Reimbursement result = service.updateReimbursement(index, resolver, status);
		
		PrintWriter out = resp.getWriter();
		
		resp.setContentType("application/json");
		
		String resJSON = mapper.writeValueAsString(result);
		out.write(resJSON);
		
	}

}
