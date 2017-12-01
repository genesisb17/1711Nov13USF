package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import dao.DAOImplementation;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1451723899712538224L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.printf("User: %s%nPassword: %s%n", name, password);
		
		request.getParameterMap().entrySet()
			.forEach(e -> System.out.printf("%s: %s%n", e.getKey(), Arrays.stream(e.getValue()).reduce("", (a, b) -> a + b)));
		
		Enumeration<String> paramNames = request.getParameterNames();
		while(paramNames.hasMoreElements()) {
			String param = paramNames.nextElement();
			System.out.printf("%s: %s", param, request.getParameter(param));
		}
		
		PrintWriter out = response.getWriter();
		out.println("<h1>Welcome " + name + "</h1>");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		DAO dao = new DAOImplementation();
		String name = request.getParameter("username");
		dao.addUser(name, "", "", "");
	}
	
}
