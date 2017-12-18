package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetViewServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("In Get View Servlet ");
		System.err.println("[LOG] Request sent to Front Controller");
		
		String nextView = new RequestHelper().process(req,resp);
		System.out.println("In view servlet, the nextview being passed is: " + nextView);
		req.getRequestDispatcher(nextView).forward(req, resp);
	}
	
	
	
}