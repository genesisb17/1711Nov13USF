package com.revature.ers.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.ers.helpers.RequestViewHelper;

/**
 * Servlet implementation class LoadViewServlet
 */
@WebServlet("*.view")
public class LoadViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("[LOG] - Request sent to front controller, LoadViewServlet");

		String nextView = new RequestViewHelper().process(request, response);
		//System.out.println(nextView);

		request.getRequestDispatcher(nextView).forward(request, response);

	}

}
