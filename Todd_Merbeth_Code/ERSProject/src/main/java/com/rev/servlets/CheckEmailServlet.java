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

@WebServlet("/checkEmail")
public class CheckEmailServlet extends HttpServlet {
		
		private static final long serialVersionUID = 1L;

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			Service service = new Service();

			BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
			String email = null;
			if(br != null) {
				email = br.readLine();
				if (email.length() > 1) {
					email = email.substring(1, email.length()-1);
				}
			}
			Boolean result = service.checkEmail(email.toString());
			if(result == true){
				System.out.println("email taken");
			}
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			
			String emailJSON = result.toString();
			out.write(emailJSON);
		}
	}