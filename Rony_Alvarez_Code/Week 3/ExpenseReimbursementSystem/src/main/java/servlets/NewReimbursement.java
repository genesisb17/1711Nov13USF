package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojos.User;
import service.Service;

public class NewReimbursement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Service service = new Service();
		
		User user = (User) request.getSession(false).getAttribute("user");
		
		String type = request.getParameter("type"); 
		int typeId = 0;
		
		switch(type) {
		
		case "lodging":
			typeId = 1;
			break;
		case "travel":
			typeId = 2;
			break;
		case "food":
			typeId = 3;
			break;
		case "other":
			typeId = 4;
			break;
		
		}
		
		int amount = Integer.parseInt(request.getParameter("amount"));
		String description = request.getParameter("description");
		int author = user.getId();
		int statusId = 1;
		
		//System.out.println(typeId + ", " + amount + ", " + description + ", " + author + ", " + statusId);	
		
		service.newReimbursement(amount, description, author, statusId, typeId);
		
	}

}
