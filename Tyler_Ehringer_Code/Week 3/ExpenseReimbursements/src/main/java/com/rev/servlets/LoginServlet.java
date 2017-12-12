package com.rev.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.dao.DAO;
import com.rev.dao.DAOImplementation;
import com.rev.pojos.User;
import com.rev.util.Utils;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	private static DAO service = new DAOImplementation();
	private static ObjectMapper mapper = new ObjectMapper();

	private static final long serialVersionUID = -9181768865057790703L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User u = new User();
		resp.setContentType("application/json");
		try {
			String[] userData = mapper.readValue(Utils.getJson(req.getInputStream()), String[].class);
			if(service.hasUsername(userData[0])) {
				User user = service.getUserByUsername(userData[0]);
				if(user.getPassword().equals(userData[1])) {
					u = user;
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		resp.getWriter().write(mapper.writeValueAsString(u));
		req.getSession().setAttribute("user", u);
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		
		super.service(arg0, arg1);
	}
}
