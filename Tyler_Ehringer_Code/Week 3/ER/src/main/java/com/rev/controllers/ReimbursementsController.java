package com.rev.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rev.pojos.Reimbursement;
import com.rev.pojos.User;
import com.rev.util.Util;

public class ReimbursementsController extends BaseController {

	@Override
	public void handleGet(Iterator<String> path, HttpServletRequest req, HttpServletResponse resp) {
		switch (path.next()) {
		case "all":
			getAll(req, resp);
			break;
		case "user":
			getParticular(req, resp);
			break;
		}
	}

	@Override
	public void handlePost(Iterator<String> path, HttpServletRequest req, HttpServletResponse resp) {
		switch (path.next()) {
		case "add":
			addReimbursement(req, resp);
			break;
		case "update":
			updateReimbursement(req, resp);
		default:
			break;
		}
	}

	private void updateReimbursement(HttpServletRequest req, HttpServletResponse resp) {
		try {
			Reimbursement r = mapper.readValue(Util.getJson(req.getInputStream()), Reimbursement.class);
			r = service.updateReimbursement(r);
			resp.getWriter().write(mapper.writeValueAsString(r));
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	private void addReimbursement(HttpServletRequest req, HttpServletResponse resp) {
		try {
			Reimbursement r = mapper.readValue(Util.getJson(req.getInputStream()), Reimbursement.class);
			r = service.addReimbursement(r);
			resp.getWriter().write(mapper.writeValueAsString(r));
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	private void getParticular(HttpServletRequest req, HttpServletResponse resp) {
		try {
			User u = (User) req.getSession().getAttribute("user");
			if (u != null && u.getRole() == User.ROLE_EMPLOYEE) {
				mapper.writeValue(resp.getWriter(), service.getReimbursementsForUser(u.getId()));
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	private void getAll(HttpServletRequest req, HttpServletResponse resp) {
		try {
			User u = (User) req.getSession().getAttribute("user");
			if (u != null && u.getRole() == User.ROLE_MANAGER) {
				mapper.writeValue(resp.getWriter(), service.getReimbursements());
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

}
