package com.ers.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.util.RequestHelper;

@WebServlet("*.view")
public class GetViewsServlet extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String nextView = new RequestHelper().process(request, response);
		request.getRequestDispatcher(nextView).forward(request, response);
	}

}
