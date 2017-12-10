package com.ex.servlets;

import java.io.IOException;
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

@WebServlet("/update")
public class updateservlet extends HttpServlet
{
	static Service service = new Service();
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		HttpSession session = request.getSession(true);
		ArrayList<R> a=new ArrayList<R>();
		a=(ArrayList<R>)session.getAttribute("Array");
		User u = (User)session.getAttribute("user");	
		String i = request.getParameter("rid");
		String status = request.getParameter("status");
		int j = Integer.parseInt(i);
		for(int k =0;k<a.size();k++)
		{
			if(j==a.get(k).getReimb_id())
			{
				service.UpdateStatus(a.get(k).getREIMB_STATUS_ID(),status);
				service.UpdateReimb(a.get(k).getReimb_id(), u.getUid());
			}
		}
	}
}
