package com.rev.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.pojos.Ticket;
import com.rev.pojos.User;
import com.rev.service.Service;

@WebServlet("/Submit")
public class SubmitTicketServlet extends HttpServlet {
	static Service service = new Service();
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Timestamp time=new Timestamp(System.currentTimeMillis());
		// 1. get received JSON data from request
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		if (br != null) {
			json = br.readLine();
		}
		System.out.println("JSON STRING: " + json);

		// 2. initiate jackson mapper
		ObjectMapper mapper = new ObjectMapper();
		//mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		// 3. Convert received JSON to String array
		String[] ticketInfo = mapper.readValue(json, String[].class);
		double am=Double.parseDouble(ticketInfo[0]);
		String des=ticketInfo[1];
		int option=Integer.parseInt(ticketInfo[2]);
		Ticket t=new Ticket(0, am, time, time, des, user.getUser_ID(), 0, 0, option);
		t=service.addTicket(t);
		
		/*String username = ticketInfo[0];
		String password = ticketInfo[1];

		User temp = service.getUser(username, password);
		if (temp != null) {
			HttpSession session = req.getSession();
			session.setAttribute("user", temp);// persist this user to the session to be accessed throughout servlets
		}
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		String userJSON = mapper.writeValueAsString(temp);
		System.out.println("JSON: " + userJSON);
		out.write(userJSON);*/
	}
}
