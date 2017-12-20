package com.revature.ers.helpers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.ers.dto.DetailedReimbursement;
import com.revature.ers.pojos.User;
import com.revature.ers.service.Service;


public class LoadInfoHelper {

	public Object process(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("[LOG] - Processing request with LoadInfoHelper: " + request.getRequestURI());

		Service service = new Service();
		HttpSession session;
		User user;
		
		switch(request.getRequestURI()) {

		case "/ers/profile.loadinfo":
			session = request.getSession();
			user = (User) session.getAttribute("user");
			user.setPassword("********");
			return user;

		case "/ers/pending.loadinfo":
			session = request.getSession();
			user = (User) session.getAttribute("user");
			return service.getPendingReimbursementsByAuthorId(user.getUserId());
			
		case "/ers/managerPending.loadinfo":
			return service.getAllPendingReimbursements();
			
			
		case "/ers/history.loadinfo":
			session = request.getSession();
			user = (User) session.getAttribute("user");
			return service.getResolvedUserReimbursements(user.getUserId());
			
		default:
			return null;
		}
	}
}
