package com.rev.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.dao.DAO;
import com.rev.dao.DAOImplementation;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{

	private static DAO service = new DAOImplementation();
	private static ObjectMapper mapper = new ObjectMapper();
	
	private static final long serialVersionUID = -1809150117393361203L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		super.doPost(req, resp);
	}

}
