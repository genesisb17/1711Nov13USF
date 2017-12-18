package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojos.User;
import service.Service;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	Service service = new Service();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		int login = service.login(username, password);
		
		String redirectTo;
		
		if(login == 1) {
			
			// get the user information
			User temp = service.getUserByUsername(username);
			
			// persist this user and reimbursement data to the session to be accessed throughout servlets and js
			HttpSession session = request.getSession();
			session.setAttribute("user", temp);	
			
			// if the id is 2 go to manager, otherwise go to employee
			if(temp.getRole() == 2) {
				redirectTo = "manager.html";
			} else {
				redirectTo = "employee.html";
			}
					
		} else {
			
			redirectTo = "loginerror.html";
			
		}	
		
		response.sendRedirect(redirectTo);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
