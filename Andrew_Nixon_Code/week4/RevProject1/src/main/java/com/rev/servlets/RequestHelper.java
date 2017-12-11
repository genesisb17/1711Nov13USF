package com.rev.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rev.pojos.ERSUser;

public class RequestHelper {
	
	public String process(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("req.getRequestURI() " + req.getRequestURI());
		switch (req.getRequestURI()) {
		case "/RevProject1/main.view":{
			System.out.println("process = main");
			return "main.html";
		}
		case "/RevProject1/userInfo.view":{
			System.out.println("process = userInfo");
			HttpSession session = req.getSession();
			ERSUser user = (ERSUser) session.getAttribute("user");
			System.out.println("user.getRoleID() = " + user.getRoleID());
			//return "userInfo.html";
			
			if (user.getRoleID() == 21) {
				return "employeePage.html";
			}
			else if (user.getRoleID() == 22) {
				return "fManagerPage.html";				
			}
			else {
				resp.setStatus(418);
			}

		}
		}
		return null;
	}

}
