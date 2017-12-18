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

import pojos.User;
@WebServlet("/getUserInfo")
public class GetUserInfo extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("In get User Info Servlet");
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user"); //lets you access the user that initiated the current session that your currently in (check loginservlet http session
		System.out.println("User in the getUserInfo servlet is " + user);
		
		
		if(user!=null) {
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(user);
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			System.out.println("User before being written back to javascript is " + json);
			out.write(json);
		}
		else {
			resp.setStatus(418);
		}
	}
}

