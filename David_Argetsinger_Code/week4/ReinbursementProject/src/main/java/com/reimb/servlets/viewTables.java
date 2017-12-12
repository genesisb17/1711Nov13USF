package com.reimb.servlets;

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

import com.reimb.pojos.Reimburse;
import com.reimb.pojos.User;
//import com.reimb.service.DemoService;
import com.reimb.service.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/viewTable")
public class viewTables extends HttpServlet {
	static Service service = new Service();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
	    System.out.println("Please Viewtables servlet");
	    
	    HttpSession session = request.getSession();
	    User ogU = (User)session.getAttribute("user");
	    ArrayList<Reimburse> temp= service.usersRiembs(ogU);
	    PrintWriter out = response.getWriter();
	    response.setContentType("application/json");
	    ObjectMapper mapper = new ObjectMapper();
	    String ticketsJSON = mapper.writeValueAsString(temp);
	    System.out.println(ticketsJSON);
	    out.write(ticketsJSON);
	  }	
}
