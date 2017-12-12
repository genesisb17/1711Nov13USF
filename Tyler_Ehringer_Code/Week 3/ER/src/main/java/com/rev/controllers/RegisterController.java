package com.rev.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rev.pojos.BoolResult;
import com.rev.pojos.User;
import com.rev.util.Util;

public class RegisterController extends BaseController {

	@Override
	public void handlePost(Iterator<String> path, HttpServletRequest req, HttpServletResponse resp) {
		switch (path.next()) {
		case "new":
			createUser(req, resp);
			break;
		case "update":
			updateUser(req, resp);
			break;
		default:
			break;
		}
	}
	
	@Override
	public void handleGet(Iterator<String> path, HttpServletRequest req, HttpServletResponse resp) {
		switch (path.next()) {
		case "username":
			hasUsername(req, resp);
			break;
		case "email":
			hasEmail(req, resp);
			break;
		default:
			break;
		}
	}

	private void hasEmail(HttpServletRequest req, HttpServletResponse resp) {
		try {
			BoolResult result;
			if(service.hasEMail(req.getParameter("email"))) {
				result = new BoolResult(true);
			}else {
				result = new BoolResult(false);
			}
			resp.getWriter().write(mapper.writeValueAsString(result));
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	private void hasUsername(HttpServletRequest req, HttpServletResponse resp) {
		try {
			BoolResult result;
			if(service.hasUsername(req.getParameter("username"))) {
				result = new BoolResult(true);
			}else {
				result = new BoolResult(false);
			}
			resp.getWriter().write(mapper.writeValueAsString(result));
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	private void createUser(HttpServletRequest req, HttpServletResponse resp) {
		try {
			User[] users = mapper.readValue(Util.getJson(req.getInputStream()), User[].class);
			User u = users[0];
			if (!service.hasUsername(u.getUsername()) && !service.hasEMail(u.getEmail())) {
				u = service.addUser(u);
				resp.getWriter().write(mapper.writeValueAsString(u));
			} else {
				resp.getWriter().write(mapper.writeValueAsString(new User()));
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	private void updateUser(HttpServletRequest req, HttpServletResponse resp) {
		
	}
}
