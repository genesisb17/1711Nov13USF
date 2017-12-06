package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.pojos.Users;

@WebServlet("/loadMainPage")
public class GetMainPageViewServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("partials/main-page.html").forward(req, resp);
//		HttpSession session = req.getSession();
//		Users user = (Users)session.getAttribute("user");
//		System.out.println(user);
//
//		if (user.getRoleId() == 1)
//			req.getRequestDispatcher("partials/emp-page.html").forward(req, resp);
//		else if (user.getRoleId() == 2)
//			req.getRequestDispatcher("partials/man-page.html").forward(req, resp);

	}
}
