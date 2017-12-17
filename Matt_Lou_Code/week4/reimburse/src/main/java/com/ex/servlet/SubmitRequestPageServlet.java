package com.ex.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rev.pojos.Users;

@WebServlet("/forwardsubmitrequest")
public class SubmitRequestPageServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
			HttpSession session = request.getSession();
			Users user = (Users)session.getAttribute("user");
			
			request.getRequestDispatcher("submitquest.html").forward(request, response);
		}
}

