package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import dao.DAO;
import dao.FileDAO;
import pojos.User;
import pojos.UserReimbursement;

public class ChangeStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DAO dao = new FileDAO();
		
		// get user from cache
		User user = (User) request.getSession(false).getAttribute("user");
		
		String status = request.getParameter("status");
		
		// call the updateStatus function
		dao.updateStatus(user.getId());
		
		
		
		ArrayList<UserReimbursement> userreim = dao.getUserReimbursements(7326);

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
		
		String status = request.getParameter("Status");
		System.out.println(status);
		
		//doGet(request, response);
	}

}
