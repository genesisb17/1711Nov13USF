package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rev.pojo.R;
import com.rev.pojo.User;
import com.rev.service.Service;

@WebServlet("/viewr")
public class viewrservlet extends HttpServlet
{
	static Service service = new Service();
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		//use AJAX
		HttpSession session = request.getSession(true);
		User u = (User)session.getAttribute("user");
		R r = new R();
		ArrayList <R> a = new ArrayList<R>();
		a = service.getReimbursements(u.getUsername(), u.getPassword());
		PrintWriter out = response.getWriter();
		int i;
		if(a.size()==0)
		{
			out.println("none available");
		}
		else
		{
			for(i=0;i<a.size();i++)
			{
				out.println(a.get(i).getReimb_id()+" "+a.get(i).getReimb_Amount()+" "+a.get(i).getDescription());
			}
		}
		if(u.getUser_Role_Id()==13)
		{
			out.println("what is the id number you want to change??<br>");
			out.println("<input type=\"text\" id =\"rid\">");
		}
	}
}

