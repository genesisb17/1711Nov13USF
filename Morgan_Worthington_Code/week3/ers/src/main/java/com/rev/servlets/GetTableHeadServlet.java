package com.rev.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getTableHead")
public class GetTableHeadServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader br= req.getReader();
		String role="";
		if(br!=null) {
			role=br.readLine();
		}

		if(role.equals("1")) {
			req.getRequestDispatcher("partials/managerTableHead.html").forward(req, resp);
		} else {
			req.getRequestDispatcher("partials/employeeTableHead.html").forward(req, resp);
		}
	}
}
