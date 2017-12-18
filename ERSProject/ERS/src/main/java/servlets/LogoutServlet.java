package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
		System.out.println("Logging user out");
		if(req.getSession(false)==null) { 
// returns current httpsession associated with  http request. if there is none, bool value of (true) creates it
			resp.sendRedirect("app.html");
		}
		HttpSession session = req.getSession(false); //false mkaes sure that were not creating a new session 
		if(session!= null) {
			session.removeAttribute("user");
			session.invalidate();
			System.out.println("Session invalidated!");
		}
		resp.sendRedirect("login.html");
	}
	
	
	
}
