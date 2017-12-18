package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Service;

public class ChangeStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*DAO dao = new FileDAO();
		
		// get user from cache
		User user = (User) request.getSession(false).getAttribute("user");
		
		String status = request.getParameter("name");
		
		// call the updateStatus function
		//dao.updateStatus(user.getId());
		
		
		
		ArrayList<UserReimbursement> userreim = dao.getUserReimbursements(7326);

		// create the json object
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();

		Gson gson = new GsonBuilder().serializeNulls().create();
		JsonArray jarray = gson.toJsonTree(userreim).getAsJsonArray();
		JsonObject jsonObject = new JsonObject();
		jsonObject.add("data", jarray);

		out.print(jsonObject.toString());
		out.flush();*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Service service = new Service();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String status = request.getParameter("status");
		//System.out.println(id + ", " +status);
		
		int statusid = 0;
		
		switch(status) {
		
		case "pending":
			statusid = 1;
			break;
		case "approved":
			statusid = 2;
			break;
		case "denied":
			statusid = 3;
			break;
		
		}
		
		//System.out.println(id + ", " + statusid);
		service.updateStatus(id, statusid);
		
		
	}

}
