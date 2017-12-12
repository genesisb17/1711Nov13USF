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

@WebServlet("/validregister")
public class ValidateRegisterServlet extends HttpServlet {
	
	static Service service= new Service();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(req.getInputStream()));
		String username="";
		if(br!=null) {
			username=br.readLine();
		}

		
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		if(service.userExists(username)) {
			pw.write("Username already exists.");
		} else {
			pw.write("Validated.");
		}
	}
}
