package com.rev.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rev.pojos.User;

@WebServlet("/getSessionInfo")
public class GetUserFromSessionServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession s=req.getSession(false);
		User u=(User) s.getAttribute("user");
		if(u!=null) {
			PrintWriter pw=resp.getWriter();
			pw.write(u.toString());
		} else {
			System.out.println("The user is not persisting through the session.");
		}
	}
}
