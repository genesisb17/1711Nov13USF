package com.ERS.servlets;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

	import com.fasterxml.jackson.databind.ObjectMapper;

	import com.ERS.pojos.Reimbursement;
import com.ERS.pojos.User;

	import com.ERS.service.Service;
	
	
@WebServlet("/ResolveTicket")
public class ResolveTicket extends HttpServlet {


		
		private static final long serialVersionUID = 1L;

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Service service = new Service();
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		if (br !=null) {
			json = br.readLine();
		}
		
//			System.out.println("resolveticket: " + json);
		ObjectMapper mapper = new ObjectMapper();
		String[] data = mapper.readValue(json, String[].class);
		
		HttpSession session = req.getSession();
		User u = (User) session.getAttribute("user");
		int id = Integer.parseInt(data[0]);
		int status = Integer.parseInt(data[1]);
		
		service.resolve(id, status, u);

	}
}