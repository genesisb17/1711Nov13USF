package com.ex.servlets;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rev.pojo.User;
@WebServlet("/getProfileView")
public class GetProfileViewServlet extends HttpServlet
{	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		HttpSession session = req.getSession(true);
		User u = (User)session.getAttribute("user");
		req.getRequestDispatcher("partials/profile.html").forward(req, resp);
	}
}