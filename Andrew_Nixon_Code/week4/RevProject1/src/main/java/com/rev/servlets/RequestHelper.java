package com.rev.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rev.pojos.ERSUser;

public class RequestHelper {
	
	public String process(HttpServletRequest req, HttpServletResponse resp) {
		switch (req.getRequestURI()) {
		case "/RevProject1/home.view": {
			return "home.html";
		}
		case "/RevProject1/registerUser.view": {
			return "registerUser.html";
		}
		case "/RevProject1/main.view":{
			return "main.html";
		}
		case "/RevProject1/userInfo.view":{
			HttpSession session = req.getSession();
			ERSUser user = (ERSUser) session.getAttribute("user");
			if(user != null) {
				
				if (user.getRoleID() == 21) {
					return "employeePage.html";
				}
				else if (user.getRoleID() == 22) {
					return "fManagerPage.html";				
				}
			}			
			else {
				resp.setStatus(418);
			}

		}
		}
		return null;
	}

}
