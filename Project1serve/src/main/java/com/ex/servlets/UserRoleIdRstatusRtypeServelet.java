
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

	Service service = new Service();
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		String r = request.getParameter("role");
		int role = Integer.parseInt(r);
		
		PrintWriter out = response.getWriter();
		out.println("test");
	}
	
	
}

