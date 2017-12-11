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
		HttpSession session = request.getSession(true);
		User u = (User)session.getAttribute("user");
		R r = new R();
		ArrayList <R> a = new ArrayList<R>();
		a = service.getReimbursements(u.getUsername(), u.getPassword());

		session.setAttribute("Array",a);
		String filter = request.getParameter("filter");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int i;
		String s;
		String test;
		out.println(filter);
		if(u.getUser_Role_Id()==13)
		{
			
			for(i=0;i<a.size();i++)
			{
				
				if(filter.equals(""))
				{
					s = service.getRStatus(a.get(i).getREIMB_STATUS_ID());
					out.println(i+" "+a.get(i).getReimb_id()+" "+a.get(i).getReimb_Amount()+" "+a.get(i).getDescription()+" "+a.get(i).getU_ID()+"<br>");
				}
				else
				{
					test = service.getRStatus(a.get(i).getREIMB_STATUS_ID());
					if(filter.equals(test))
					{
						s = service.getRStatus(a.get(i).getREIMB_STATUS_ID());
						out.println(a.get(i).getReimb_id()+" "+a.get(i).getReimb_Amount()+" "+a.get(i).getDescription()+" "+a.get(i).getU_ID()+"  "+test+"<br>");
					}
				}
			}
			out.println("what is the id number you want to change??<br>");
			out.println("<form name =\"update\" action =\"update\" method=\"Post\">");
			out.println("<input type=\"text\" name=\"rid\" id =\"rid\">");
			out.println("<br>status<br>");
			out.println("<input type=\"text\" name=\"status\" id =\"status\">");
			out.println("<input type =\"submit\">");
			out.println("</form>");
		}
		else
		{
			if(a.size()==0)
			{
				out.println("none availabletest");
			}
			else
			{
				for(i=0;i<a.size();i++)
				{
					s = service.getRStatus(a.get(i).getREIMB_STATUS_ID());
					out.println(a.get(i).getReimb_id()+" "+a.get(i).getReimb_Amount()+" "+a.get(i).getDescription()+" "+a.get(i).getU_ID()+s+"<br>");
				}
				
	/*			out.println("what is the id number you want to change??<br>");
				out.println("<form name =\"update\" action =\"update\" method=\"Post\">");
				out.println("<input type=\"text\" name=\"filter\" id =\"f\">");
				out.println("<input type =\"submit\">");
				out.println("</form>");*/
			}
		}
	}
}