package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.DAO;
import dao.FileDAO;
import pojos.User;


@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	static DAO dao = new FileDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		int login = dao.login(username, password);
		
		String redirectTo;
		
		if(login == 1) {
			
			// get the user information
			User temp = dao.getUserByUsername(username);
			
			// persist this user and reimbursement data to the session to be accessed throughout servlets and js
			HttpSession session = request.getSession();
			session.setAttribute("user", temp);
			
			redirectTo = "employee.html";
		
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
