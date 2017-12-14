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
		User u1 = (User)session.getAttribute("user");
		ArrayList <R> a = new ArrayList<R>();
		a = service.getReimbursements(u.getUsername(), u.getPassword());

		session.setAttribute("Array",a);
		String filter = request.getParameter("filter");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int i;
		String s;
		String test;
		int count=0;
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

		out.println(
				"		<form name =\"viewr\" action =\"viewr\" method=\"Post\">\r\n" + 
				"		Filter results\r\n" + 
				"		<input class = \"form-control\" type = \"text\" name = \"filter\" id = \"filter\">\r\n" + 
				"		<input class = \"form-control\" type =\"submit\">\r\n" + 
				"		</form>"
				   );
		out.println("<style>\r\n" + 
				"	body\r\n" + 
				"	{		\r\n" + 
				"	    background-color:#ADD8E6\r\n" + 
				"	}\r\n" + 
				"	table\r\n" + 
				"	{		\r\n" + 
				"	    background-color:white\r\n" + 
				"	}\r\n" + 
				"\r\n" + 
				"</style>");
		if(u.getUser_Role_Id()==13)
		{
		out.println("what is the id number you want to change??<br>");
		out.println("<form name =\"update\" action =\"update\" method=\"Post\">");
		out.println("<input class =\"form-control\" type=\"text\" name=\"rid\" id =\"rid\">");
		out.println("<br>status<br>");
		out.println("<input class =\"form-control\" type=\"text\" name=\"status\" id =\"status\">");
		out.println("<input class =\"form-control\"  type =\"submit\">");
		out.println("</form>");
		}
		if(u.getUser_Role_Id()==13)
		{
						out.println("<table style=\"width:100%\" class=\"table .table-striped\">");
			out.println(
					"    <thead>\r\n" + 
					"      <tr>\r\n" + 
					"        <th>Reimb ID</th>\r\n" + 
					"        <th>amount</th>\r\n" + 
					"        <th>Description</th>\r\n" + 
					"        <th>Username</th>\r\n" + 
					"        <th>Status</th>\r\n" + 
					"      </tr>\r\n" + 
					"    </thead>"
					);
			for(i=0;i<a.size();i++)
			{
				
				if(filter.equals(""))
				{
					s = service.getRStatus(a.get(i).getREIMB_STATUS_ID());
					if(a.get(i).getReimb_id()!=22||a.get(i).getReimb_id()!=41||a.get(i).getReimb_id()!=21)
					{
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
					out.println(service.getUserById(a.get(i).getU_ID()));
					out.println("</td>");
					out.println("<td>");
					out.println(s);
					out.println("</td>");
					out.println("</tr>");
					if(s.equals("pending"))
					{
						count = count++;
					}
					}
				}	
				else
				{
					test = service.getRStatus(a.get(i).getREIMB_STATUS_ID());
					if(filter.equals(test))
					{
						if(a.get(i).getReimb_id()!=22||a.get(i).getReimb_id()!=41||a.get(i).getReimb_id()!=21)
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
						out.println(service.getUserById(a.get(i).getU_ID()));
						out.println("</td>");
						out.println("<td>");
						out.println(s);
						out.println("</td>");
						out.println("</tr>");
						if(s.equals("pending"))
						{
							count = count++;
						}
						}
					}
				}

			}
			
			out.println("</table>");
			out.println("there are "+count+" pending");

		}
		else
		{
			if(a.size()==0)
			{
				out.println("none availabletest");
			}
			else
			{
				out.println("<table style=\"width:100%\" class=\"table .table-striped\">");
				out.println(
						"    <thead>\r\n" + 
						"      <tr>\r\n" + 
						"        <th>Reimb ID</th>\r\n" + 
						"        <th>amount</th>\r\n" + 
						"        <th>Description</th>\r\n" + 
						"        <th>Username</th>\r\n" + 
						"        <th>Status</th>\r\n" + 
						"      </tr>\r\n" + 
						"    </thead>"
						);
				for(i=0;i<a.size();i++)
				{
					if(filter.equals(""))
					{
						if(a.get(i).getReimb_id()!=22||a.get(i).getReimb_id()!=41||a.get(i).getReimb_id()!=21)
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
							out.println(service.getUserById(a.get(i).getU_ID()));
							out.println("</td>");
							out.println("<td>");
							out.println(s);
							out.println("</td>");
							out.println("</tr>");
					
						}
					}
					else
					{
						test = service.getRStatus(a.get(i).getREIMB_STATUS_ID());
						if(filter.equals(test))
						{
							if(a.get(i).getReimb_id()!=22)
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
								out.println(service.getUserById(a.get(i).getU_ID()));
								out.println("</td>");
								out.println("<td>");
								out.println(s);
								out.println("</td>");
								out.println("</tr>");
						
							}
						}
					}
				}
				out.println("</table>");
			}
		}

	}
	}
