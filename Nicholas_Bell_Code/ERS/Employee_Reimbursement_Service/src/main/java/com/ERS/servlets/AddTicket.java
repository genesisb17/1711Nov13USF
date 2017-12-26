package com.ERS.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ERS.pojos.Reimbursement;
import com.ERS.pojos.User;
import com.ERS.service.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/AddTicket")
public class AddTicket extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Service service = new Service();
		ObjectMapper mapper = new ObjectMapper();
		
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		if (br !=null) 
			json = br.readLine();
		String[] data = mapper.readValue(json, String[].class);
		
		Reimbursement ri = new Reimbursement(Double.parseDouble(data[0]), Integer.parseInt(data[2]), data[1]);
		
		HttpSession session = req.getSession();
		User u = (User)session.getAttribute("user");
	
		ri = service.addTicket(ri,u);
	}
}