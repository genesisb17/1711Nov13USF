package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import dao.FileDAO;
import pojos.User;

/**
 * Servlet implementation class Signup
 */
@WebServlet("/SignupServlet")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new FileDAO();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User u = new User();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String role = request.getParameter("role");
		int roleId;
		
		if(role.equals("employee")) {
			roleId = 1;
			u.setRole(roleId);
		} else if(role.equals("admin")) {
			roleId = 2;
			u.setRole(roleId);
		}
		
		u.setUsername(username);
		u.setPassword(password);
		u.setFirstName(firstname);
		u.setLastName(lastname);
		u.setEmail(email);
		
		dao.signup(u);
				
		System.out.println("In the get post method" + request.getParameter("username"));
		
		doGet(request, response);
	}

}
