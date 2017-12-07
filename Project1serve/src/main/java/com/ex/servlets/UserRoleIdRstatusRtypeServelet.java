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
		String amount =request.getParameter("amount");
		double a = Double.parseDouble(amount);
		String desc = request.getParameter("description");

		service.addRtype(Rtype);
		service.addRStatus(rstatus);
		int s = service.getRStatusById(rstatus);
		int t = service.getRtypeById(Rtype);
		//service.addReimbursements(a, description, uid, statusid, typeid, null);
		
		PrintWriter out = response.getWriter();
	}	
}