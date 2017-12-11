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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.pojo.R;
import com.rev.pojo.User;
import com.rev.service.Service;

@WebServlet("/getUserInfo")
public class GetUserInfoServlet extends HttpServlet
{
	static Service service = new Service();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("In user info servlet doGet");
	//	Service service = new Service();	
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		PrintWriter out = resp.getWriter();
		System.out.println("Over here Trent" +user.getUid());
		req.getRequestDispatcher("partials/home.html").forward(req, resp);
		ArrayList<R> a = new ArrayList<R>();
		System.out.println("in loginview servlet");
		a  = service.getReimbursements(user.getUsername(), user.getPassword());
		for(int i = 0;i<a.size();i++)
		{
			System.out.println(a.get(i).getDescription());
		}
		if(user!=null)
		{
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(user);
			
			resp.setContentType("application/json");
		}
		else
		{
			resp.setStatus(418);
		}
	
	}
}
