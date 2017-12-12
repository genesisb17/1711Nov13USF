package com.rev.servlets;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rev.pojos.User;
import com.rev.service.Service;

@WebServlet("/makeSession")
public class SetUserToSessionServlet extends HttpServlet
{
	
	Service service= new Service();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader br=req.getReader();
		String username="";
		if(br!=null) {
			username=br.readLine();
			User user=service.getUserByUsername(username);
			HttpSession session=req.getSession();
			session.setAttribute("user", user);
		} else {
			System.out.println("Username is empty while making session.");
		}
	}

}
