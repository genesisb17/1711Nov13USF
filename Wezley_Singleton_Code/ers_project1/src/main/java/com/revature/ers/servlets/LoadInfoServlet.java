package com.revature.ers.servlets;

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
import com.revature.ers.dto.DetailedReimbursement;
import com.revature.ers.helpers.LoadInfoHelper;
import com.revature.ers.service.Service;

/**
 * Servlet implementation class LoadInfoServlet using Front Controller design
 */
@WebServlet("*.loadinfo")
public class LoadInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("[LOG] - Request sent to front controller, LoadInfoServlet - doGet");

		Object info = new LoadInfoHelper().process(request, response);

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(info);

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		out.write(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("[LOG] - Request sent to front controller, LoadInfoServlet - doPost");
		
		Service service = new Service();

		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(request.getInputStream()));

		String json = "";
		if(br != null) {
			json = br.readLine();
		}

		ObjectMapper mapper = new ObjectMapper();
		int reimbId = mapper.readValue(json, Integer.class);

		DetailedReimbursement reimb = service.getDetailedReimbursementById(reimbId);
		json = mapper.writeValueAsString(reimb);

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		out.write(json);
	}


}
