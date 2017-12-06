package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dto.UserValidator;
import com.revature.pojos.Users;
import com.revature.service.ERSService;

@WebServlet("/createAccount")
public class CreateAccountServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		ERSService service = new ERSService();
		// 1. get received JSON data from request
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		if (br !=null) {
			json = br.readLine();
		}

		// 2. initiate jackson mapper
		ObjectMapper mapper = new ObjectMapper();
		
		// 3. Convert received JSON to String array
		UserValidator uv = mapper.readValue(json, UserValidator.class);
		Users u = uv.getUser();
		String message = uv.getMessage();
		
		Users newUser = null;
		// 4. Validate
		if(service.userExists(u.getUsername()))
			message = "An account with that username exists";
		else if(!service.uniqueEmail(u.getEmail()))
			message = "An account with that email already exists";
		else {
			// 5. add to database
			newUser = service.createAccount(u);
		}
		
		if(newUser != null) {
			HttpSession session = req.getSession();
			session.setAttribute("user", newUser);
		}
		
		uv.setMessage(message);
		uv.setUser(newUser);
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.write(mapper.writeValueAsString(uv));
	}
}
