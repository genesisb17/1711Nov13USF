package com.rev.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.pojos.R_Type;
import com.rev.service.Service;

@WebServlet("/reimbursementTypes")
public class ReimbursementTypesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Service service = new Service();
		ArrayList<R_Type> types = service.getAllRTypes();
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		
		ObjectMapper mapper = new ObjectMapper();
		String userJSON = mapper.writeValueAsString(types);
		out.write(userJSON);
	}

}
