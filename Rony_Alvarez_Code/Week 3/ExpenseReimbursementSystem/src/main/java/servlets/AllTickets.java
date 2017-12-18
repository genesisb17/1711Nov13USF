package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import pojos.User;
import pojos.UserReimbursement;
import service.Service;

@WebServlet("/getAllTickets")
public class AllTickets extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Service service = new Service();

		// get user from session
		User user = (User) request.getSession(false).getAttribute("user");
		
		// get the user reimbursements
		ArrayList<UserReimbursement> userreim = service.getUserReimbursements(user.getId());
		
		// create the json object
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		
		
		Gson gson = new GsonBuilder().serializeNulls().create();
		JsonArray jarray = gson.toJsonTree(userreim).getAsJsonArray();
		JsonObject jsonObject = new JsonObject();
		jsonObject.add("data", jarray);

		out.print(jsonObject.toString());
		out.flush();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
