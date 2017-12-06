package com.reimb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class practice
 */
@WebServlet("/tested")
public class practice extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	@Override
	public void service(ServletRequest request, ServletResponse responce) throws ServletException, IOException {
		responce.setContentType("text/html");
		PrintWriter out = responce.getWriter();
		out.println("<h1> jello welcome to your first sevlet ! </h1>"
				+ "<br><br>"
				+ "<ul><li>this is a list item </li></ul>");
		
	}
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public practice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
