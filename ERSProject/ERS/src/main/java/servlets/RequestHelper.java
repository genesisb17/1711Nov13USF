package servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {
	public String process(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("In Request Helper Class");
		System.err.println("[LOG] Processing request with Helper: " + req.getRequestURI());
		System.out.println("in process method " + req.getRequestURI());
		switch(req.getRequestURI()) {
			case "/ERS/employee.view":{
				System.out.println("Loading Employee Page");
				return "partials/employee.html";
			}
			case "/ERS/manager.view":{	
				System.out.println("Loading Manager Page");
				return "partials/manager.html";
			}
			case "/ERS/viewProfile.view":{
				System.out.println("Loading Profile Page");
				return "partials/viewProfile.html";
			}
			case "/ERS/editProfile.view":{
				System.out.println("Loading Edit Profile Page");
				return "partials/editProfile.html";
			}
			case "/ERS/changePassword.view":{
				System.out.println("Loading Change Password Page");
				return "partials/changePassword.html";
			}
			case "/ERS/viewRequest.view":{
				System.out.println("Loading Requests Page");
				return "partials/viewRequest.html";
			}
			case "/ERS/submitRequest.view":{
				System.out.println("Loading Submit Request Page");
				return "partials/submitRequest.html";
			}
			case "/ERS/newPassword.view":{
				System.out.println("Loading New Password Page");
				return "partials/newPassword.html";
			}
			/*case "/ERS/submit.view":{
				System.out.println("Load submit page");
				return "partials/submit.html";
			}
			case "/ERS/editProfileForm.view":{
				System.out.println("Load edit profile form");
				return "partials/editProfileForm.html";
			}
			*/
		}
		return null;
		}
	}

