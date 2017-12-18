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
import com.revature.dto.UserDTO;
import com.revature.pojos.Users;
import com.revature.service.ERSService;

@WebServlet("/updateaccount")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ERSService service = new ERSService();
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		if (br !=null) {
			json = br.readLine();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		
		HttpSession session = req.getSession();
		Users currUser = (Users)session.getAttribute("user");
		UserDTO userInfo = mapper.readValue(json, UserDTO.class);
		Users newUser = userInfo.getUser(); // hasn't been sent to database yet
		Users updatedUser = null; // get the user object returned from db commit
		String[] message = new String[3];
		Boolean error = false;
		
		// make sure that username, password, and email aren't null otherwise
		// values will get wiped in database
		newUser.setUserId(currUser.getUserId());
		if (newUser.getEmail() == null)
			newUser.setEmail(currUser.getEmail());
		
		if (newUser.getUsername() == null)
			newUser.setUsername(currUser.getUsername());
		
		if (newUser.getPassword() == null)
			newUser.setPassword(currUser.getPassword());
		
		// handle cases of username or email belonging to a different user
		Users testEmail;
		testEmail = new Users();
		testEmail = service.getUserByEmail(newUser.getEmail());
		if (testEmail != null) {
			if (!testEmail.getUserId().equals(currUser.getUserId())) {
				error = true;
				message[0] = "Email belongs to another user";
			}
		}
		Users testUsername;
		testUsername = new Users();
		testUsername = service.getUserByUsername(newUser.getUsername());
		if (testUsername != null) {
			if (!testUsername.getUserId().equals(currUser.getUserId())) {
				error = true;
				message[1] = "Username belongs to another user";
			} 
		}
		// handle case of incorrect password
		if (!service.correctPassword(currUser.getUsername(), userInfo.getMessage()[0])) {
			error = true;
			message[2] = "Password is incorrect";
		}
		
		if (!error) {
			updatedUser = new Users();
			updatedUser = service.updateAccount(newUser);
		}
		
		UserDTO updatedInfo = new UserDTO(updatedUser, message);
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		if (updatedUser != null)
			session.setAttribute("user", updatedUser);
		out.print(mapper.writeValueAsString(updatedInfo));
	}
}
