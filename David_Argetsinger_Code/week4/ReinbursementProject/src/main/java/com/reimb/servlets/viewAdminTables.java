package com.reimb.servlets;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimb.pojos.Reimburse;
import com.reimb.service.Service;

@WebServlet("/viewAdminTable")
public class viewAdminTables extends HttpServlet {
		static Service service = new Service();
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
		    System.out.println("Please ViewAdmintables servlet");
		    
		    ArrayList<Reimburse> temp= service.adminRiembs();
		    PrintWriter out = response.getWriter();
		    response.setContentType("application/json");
		    ObjectMapper mapper = new ObjectMapper();
		    String ticketsJSON = mapper.writeValueAsString(temp);
		    System.out.println(ticketsJSON);
		    out.write(ticketsJSON);
		  }	
	}

