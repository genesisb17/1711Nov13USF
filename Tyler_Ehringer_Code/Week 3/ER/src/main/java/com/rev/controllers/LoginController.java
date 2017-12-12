package com.rev.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rev.pojos.User;
import com.rev.util.Util;

public class LoginController extends BaseController {

	@Override
	public void handlePost(Iterator<String> path, HttpServletRequest req, HttpServletResponse resp) {

		switch (path.next()) {
		case "login":
			login(req, resp);
			break;
		default:
			break;
		}
	}
	
	@Override
	public void handleGet(Iterator<String> path, HttpServletRequest req, HttpServletResponse resp) {

		switch (path.next()) {
		case "logout":
			logout(req, resp);
			break;
		default:
			break;
		}
	}

	private void login(HttpServletRequest req, HttpServletResponse resp) {
		User u = new User();
		resp.setContentType("application/json");
		try {
			String[] userData = mapper.readValue(Util.getJson(req.getInputStream()), String[].class);
			if (service.hasUsername(userData[0])) {
				User user = service.getUserByUsername(userData[0]);
				if (user.getPassword().equals(userData[1])) {
					u = user;
					req.getSession().setAttribute("user", u);
				}
			}
			resp.getWriter().write(mapper.writeValueAsString(u));
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	private void logout(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession(false);
		if (session != null) {
			session.setAttribute("user", null);
			session.invalidate();
		}
		try {
			resp.getWriter().write(mapper.writeValueAsString(new User()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
