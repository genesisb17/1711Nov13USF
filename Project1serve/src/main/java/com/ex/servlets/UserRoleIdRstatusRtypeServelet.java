package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rev.pojo.R;
import com.rev.pojo.User;
import com.rev.service.Service;

@WebServlet("/Rtype")
public class UserRoleIdRstatusRtypeServelet extends HttpServlet
{
	static Service service = new Service();
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		//session is up and running
		HttpSession session = request.getSession(true);
		User u = (User)session.getAttribute("user");
		R r = new R();
		String Rtype = request.getParameter("Rtype");
		String rstatus = "pending";
		String amount =request.getParameter("amount");
		double a = Double.parseDouble(amount);
		String desc = request.getParameter("description");
		
		service.addRtype(Rtype);
		service.addRStatus(rstatus);
		int s = service.findmax();
		int t = service.findmax1();
		// 0 is a representation of null
		r.setReimb_Amount(a);
		r.setERS_USER_ROLE_ID(0);
		r.setDescription(desc);
		r.setReimb_id(u.getUid());
		r.setREIMB_STATUS_ID(s);
		r.setREIMB_TYPE_ID(t);
		service.addReimbursements(a,desc, u.getUid(), s, t, u.getUid());
		//cannot be the same id
		PrintWriter out = response.getWriter();
		//to select a reimbursement simply creat and r object and add it to the session.
	}
}