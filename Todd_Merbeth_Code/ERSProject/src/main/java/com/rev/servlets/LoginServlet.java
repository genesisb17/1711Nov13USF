package com.rev.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.dto.DTO;
import com.rev.pojos.Reimbursement;
import com.rev.pojos.User;
import com.rev.service.Service;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	static Service service = new Service();
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 1. get received JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		if(br != null) {
			json = br.readLine();
		}

		// 2. initiate jackson mapper
		ObjectMapper mapper = new ObjectMapper();
		
		// 3. Convert receive JSON to String array
		String[] user = mapper.readValue(json, String[].class); // This knows how to convert js objects to java objects
		String username = user[0];
		String password = user[1];
		
		// 4. Set response type to JSON
		User temp = service.getUser(username, password); // get user by uname
		if(temp == null){ // if invalid user, obj = null
			System.out.println("Invalid user");
		}
		else{// valid credentials
			HttpSession session = req.getSession();
			session.setAttribute("user", temp);//persist this user to the session to be accessed throughout servlets
			ArrayList<Reimbursement> reimbs = service.getUserReimbursements(temp.getId());
			DTO dto = new DTO(temp, reimbs);
			session.setAttribute("dto", dto);
		}
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		
		String userJSON = mapper.writeValueAsString(temp);
		out.write(userJSON);
	}
}