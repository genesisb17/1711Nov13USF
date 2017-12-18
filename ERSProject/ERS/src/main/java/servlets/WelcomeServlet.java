package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import pojos.User;

public class WelcomeServlet extends HttpServlet{

	protected void doPost(HttpServletRequest req, HttpServletResponse rep)throws ServletException, IOException {
		System.out.println("Inside Welcome Servlet");
		HttpSession session = req.getSession();
		User temp = (User) session.getAttribute("user");
		ObjectMapper mapper = new ObjectMapper();
		PrintWriter out = rep.getWriter();
		rep.setContentType("application/json");
		String userJSON = mapper.writeValueAsString(temp);
		out.write(userJSON);
	}
}
