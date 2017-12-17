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

@WebServlet("/getHomeView")
public class GetHomeViewServlet extends HttpServlet
{

	static Service service = new Service();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{	
		HttpSession session = req.getSession(true);
		User u = (User)session.getAttribute("user");	
		req.getRequestDispatcher("partials/home.html").forward(req, resp);
		ArrayList<R> a = new ArrayList<R>();
		/*a  = service.getReimbursements(u.getUsername(), u.getPassword());
		
		PrintWriter out = resp.getWriter();
		for(int i = 0;i<a.size();i++)
		{
			out.println(a.get(i).getDescription());
		}*/
		

	}

}
