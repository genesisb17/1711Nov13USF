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

import com.rev.service.Service;

@WebServlet("/checkUsername")
public class CheckUsernameServlet extends HttpServlet {
		
		private static final long serialVersionUID = 1L;

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			Service service = new Service();

			BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
			String username = null;
			if(br != null) {
				username = br.readLine();
				if (username.length() > 1) {
					username = username.substring(1, username.length()-1);
				}
			}
			Boolean result = service.checkUsername(username.toString());
			if(result == true){
				System.out.println("username taken");
			}
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			
			String userJSON = result.toString();
			out.write(userJSON);
		}
	}