package com.demo.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.service.Service;

@WebServlet("/demo/validate")
public class ValidateUserServlet extends HttpServlet {
	static Service service = new Service();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in validate servlet -- POST");
		
		// 1. get received JSON data from request
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		if(br != null){
			json = br.readLine();
		}
		System.out.println("JSON STRING: " + json);
		
		PrintWriter out = resp.getWriter();
		
		if(service.validateUser(json)==null) {
			System.out.println(service.validateUser(json));
			out.write("DNE");
		}
		else {
			System.out.println("exists");
			out.write("exists");
		}
	}
	
}
