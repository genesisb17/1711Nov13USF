package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rev.pojo.User;
import com.rev.service.Service;

@WebServlet("/Rtype")
public class UserRoleIdRstatusRtypeServelet extends HttpServlet
{

	static Service service = new Service();
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
	
		String Rtype = request.getParameter("Rtype");
		String rstatus = "pending";
		String r = request.getParameter("op");
		
		service.addRtype(Rtype);
		service.addRStatus(rstatus);
		service.adders_user_roles(r);
		
		PrintWriter out = response.getWriter();
		out.println(r);
		out.println(rstatus);
		out.println(Rtype);

	}
	
	
}