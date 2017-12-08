package com.reimbursement.servlets;

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
import com.reimbursement.pojos.Employee;
import com.reimbursement.pojos.Reimbursement;
import com.reimbursement.services.Services;

@WebServlet("/MakeReimb")
public class MakeReimbServlet extends HttpServlet {
	static Services serv = new Services();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
			BufferedReader br = 
					new BufferedReader(new InputStreamReader(req.getInputStream()));
			String json = "";
			if(br != null){
				json = br.readLine();
			}
			
			ObjectMapper mapper = new ObjectMapper();
			
			Reimbursement r = mapper.readValue(json, Reimbursement.class);
			
			HttpSession session = req.getSession();
			Employee u = (Employee) session.getAttribute("user");
			
			r.setReimbAuthor(u.getUserId());
			r = serv.makeReimb(r);
			PrintWriter out = resp.getWriter();
			
			resp.setContentType("application/json");
			
			String userJSON = mapper.writeValueAsString(r);
			out.write(userJSON);
		}
	}
	