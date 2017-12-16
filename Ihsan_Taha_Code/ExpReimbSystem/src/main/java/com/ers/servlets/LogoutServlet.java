package com.ers.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.pojos.Reimbursement;
import com.ers.pojos.User;
import com.ers.util.RequestHelper;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("In logout");
		
		HttpSession session = request.getSession();	
		session.invalidate();
		
		response.sendRedirect("expense-reimbursement-system.html");
	}

}