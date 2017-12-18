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
import com.rev.service.Service;

@WebServlet("/deleteReimbursement")
public class DeleteReimbursementServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) throws
			ServletException, IOException{
		
		System.out.println("In delete");
		Service service = new Service();
		
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(req.getInputStream()));
		
		String json = "";
		if(br != null){
			json = br.readLine();
		}
		
		int id = Integer.parseInt(json);
		
		boolean result = service.deleteReimbursement(id);
		PrintWriter out = resp.getWriter();
		
		resp.setContentType("application/json");
		
		ObjectMapper mapper = new ObjectMapper();
		String resJSON = mapper.writeValueAsString(result);
		out.write(resJSON);
	}
}
