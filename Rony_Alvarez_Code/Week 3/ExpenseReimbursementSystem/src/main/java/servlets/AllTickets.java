package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.DAO;
import dao.FileDAO;
import pojos.Reimbursement;

@WebServlet("/getAllTickets")
public class AllTickets extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DAO dao = new FileDAO();

		// get all the reimbursements
		Object reim = dao.getAllReimbursements("rons");

		// create the json object
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(reim);
		
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(json);
		out.flush();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
