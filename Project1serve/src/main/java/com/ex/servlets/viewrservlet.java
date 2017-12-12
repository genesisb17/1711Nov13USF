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
		ArrayList <R> a = new ArrayList<R>();
		a = service.getReimbursements(u.getUsername(), u.getPassword());

		session.setAttribute("Array",a);
		String filter = request.getParameter("filter");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int i;
		String s;
		String test;
		out.println("<link rel=\"stylesheet\"\r\n" + 
				"	href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css\"\r\n" + 
				"	integrity=\"sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb\"\r\n" + 
				"	crossorigin=\"anonymous\">\r\n" + 
				"\r\n" + 
				"<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\"\r\n" + 
				"	integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\"\r\n" + 
				"	crossorigin=\"anonymous\"></script>\r\n" + 
				"\r\n" + 
				"<script\r\n" + 
				"	src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js\"\r\n" + 
				"	integrity=\"sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh\"\r\n" + 
				"	crossorigin=\"anonymous\"></script>\r\n" + 
				"\r\n" + 
				"<script\r\n" + 
				"	src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js\"\r\n" + 
				"	integrity=\"sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ\"\r\n" + 
				"	crossorigin=\"anonymous\"></script>");

		if(u.getUser_Role_Id()==13)
		{
						out.println("<table style=\"width:100%\" class=\"table table-bordered\">");
			out.println(
					"    <thead>\r\n" + 
					"      <tr>\r\n" + 
					"        <th>Reimb ID</th>\r\n" + 
					"        <th>amount</th>\r\n" + 
					"        <th>Description</th>\r\n" + 
					"        <th>User ID</th>\r\n" + 
					"        <th>Status</th>\r\n" + 
					"        <th>Username</th>\r\n" + 
					"        <th>Firstname</th>\r\n" + 
					"        <th>Lastname</th>\r\n" + 
					"      </tr>\r\n" + 
					"    </thead>"
					);
			for(i=0;i<a.size();i++)
			{
				
				if(filter.equals(""))
				{
					s = service.getRStatus(a.get(i).getREIMB_STATUS_ID());
					out.println("<tr>");
					out.println("<td>");
					out.println(a.get(i).getReimb_id());
					out.println("</td>");
					out.println("<td>");
					out.println(a.get(i).getReimb_Amount());
					out.println("</td>");
					out.println("<td>");
					out.println(a.get(i).getDescription());
					out.println("</td>");
					out.println("<td>");
					out.println(a.get(i).getU_ID());
					out.println("</td>");
					out.println("<td>");
					out.println(s);
					out.println("</td>");
					out.println("</tr>");				}
				else
				{
					test = service.getRStatus(a.get(i).getREIMB_STATUS_ID());
					if(filter.equals(test))
					{
						out.println("<tr>");
						s = service.getRStatus(a.get(i).getREIMB_STATUS_ID());
						out.println("<td>");
						out.println(a.get(i).getReimb_id());
						out.println("</td>");
						out.println("<td>");
						out.println(a.get(i).getReimb_Amount());
						out.println("</td>");
						out.println("<td>");
						out.println(a.get(i).getDescription());
						out.println("</td>");
						out.println("<td>");
						out.println(a.get(i).getU_ID());
						out.println("</td>");
						out.println("<td>");
						out.println(s);
						out.println("</td>");
						out.println("</tr>");
					}
				}
			}
			out.println("</table>");
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
				out.println("<table style=\"width:100%\" class=\"table table-bordered\">");
				out.println(
						"    <thead>\r\n" + 
						"      <tr>\r\n" + 
						"        <th>Reimb ID</th>\r\n" + 
						"        <th>amount</th>\r\n" + 
						"        <th>Description</th>\r\n" + 
						"        <th>User ID</th>\r\n" + 
						"        <th>Status</th>\r\n" + 
						"      </tr>\r\n" + 
						"    </thead>"
						);
				for(i=0;i<a.size();i++)
				{
					out.println("<tr>");
					s = service.getRStatus(a.get(i).getREIMB_STATUS_ID());
					out.println("<td>");
					out.println(a.get(i).getReimb_id());
					out.println("</td>");
					out.println("<td>");
					out.println(a.get(i).getReimb_Amount());
					out.println("</td>");
					out.println("<td>");
					out.println(a.get(i).getDescription());
					out.println("</td>");
					out.println("<td>");
					out.println(a.get(i).getU_ID());
					out.println("</td>");
					out.println("<td>");
					out.println(s);
					out.println("</td>");
					out.println("</tr>");
				}
				out.println("</table>");
	/*			out.println("what is the id number you want to change??<br>");
				out.println("<form name =\"update\" action =\"update\" method=\"Post\">");
				out.println("<input type=\"text\" name=\"filter\" id =\"f\">");
				out.println("<input type =\"submit\">");
				out.println("</form>");*/
			}
		}
	}
}