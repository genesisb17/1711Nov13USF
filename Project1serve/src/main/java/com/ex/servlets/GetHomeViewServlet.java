package com.ex.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rev.pojo.R;
import com.rev.service.Service;

@WebServlet("/getHomeView")
public class GetHomeViewServlet extends HttpServlet
{

	static Service service = new Service();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{	

		req.getRequestDispatcher("partials/home.html").forward(req, resp);
		ArrayList<R> a = new ArrayList<R>();
		System.out.println("in loginview servlet");
		a  = service.getReimbursements("u", "p");
		int i;
		for(i=0;i<a.size();i++)
		{
			System.out.println("Description"+a.get(i).getDescription());
		}
	}
}
