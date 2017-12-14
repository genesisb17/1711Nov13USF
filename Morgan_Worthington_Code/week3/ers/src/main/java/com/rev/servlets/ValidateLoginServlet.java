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
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.pojos.User;
import com.rev.service.Service;

@WebServlet("/validLogin")
public class ValidateLoginServlet extends HttpServlet{
	
	static Service service=new Service();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json="";
		if(br!=null) {
			json=br.readLine();
		}
		
		ObjectMapper om=new ObjectMapper();
		String[] credentials=om.readValue(json,String[].class);
		String username=credentials[0];
		String password=credentials[1];
		
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		if(service.userExists(username)) {
			if(service.passwordCorrect(username,password)) {
				pw.write("Validated.");
				User u=service.getUserByUsername(username);
				HttpSession session=req.getSession();
				session.setAttribute("user", u);
			} else {
				pw.write("Incorrect password.");
			}
		} else {
			pw.write("User does not exist.");
		}
	}
}
