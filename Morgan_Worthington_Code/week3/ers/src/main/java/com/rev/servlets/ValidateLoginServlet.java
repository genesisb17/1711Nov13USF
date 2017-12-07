package com.rev.servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.service.Service;

@WebServlet("/ValidateLoginServlet")
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
		resp.setContentType("text/html");
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(resp.getOutputStream()));
		if(service.userExists(username)) {
			if(service.passwordCorrect(username,password)) {
				//make session maybe? 
				//go to other page?
				bw.write("Validated.");
			} else {
				bw.write("Incorrect password.");
			}
		} else {
			bw.write("User does not exist.");
		}
	}
}
