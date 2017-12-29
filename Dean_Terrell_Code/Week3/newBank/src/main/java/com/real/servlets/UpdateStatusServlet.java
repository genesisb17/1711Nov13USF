package com.real.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.real.pojos.TableRow;
import com.real.pojos.User;
import com.real.util.Service;

@WebServlet("/updateStatus")
public class UpdateStatusServlet extends HttpServlet {
	
	static Service service = new Service();
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("In update status servlet");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		if(br != null){
			json = br.readLine();
		}
		
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		
		ObjectMapper mapper = new ObjectMapper();
		
		String[] rowData = mapper.readValue(json, String[].class);
		rowData[2] = Integer.toString(user.getId());
		service.updateReimbursement(rowData);
	}
}