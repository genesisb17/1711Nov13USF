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
		String cPassword = userInfo.getMessage()[0];
		Users newUser = null;
		
		// make sure that username, password, and email aren't null otherwise
		// values will get wiped in database
		userInfo.getUser().setUserId(currUser.getUserId());
		if (userInfo.getUser().getEmail() == null)
			userInfo.getUser().setEmail(currUser.getEmail());
		
		if (userInfo.getUser().getUsername() == null)
			userInfo.getUser().setUsername(currUser.getUsername());
		
		if (userInfo.getUser().getPassword() == null)
			userInfo.getUser().setPassword(currUser.getPassword());
		
		if (!cPassword.equals("")) {
			if (service.correctPassword(currUser.getUsername(), cPassword)) {
				newUser = new Users();
				newUser = service.updateAccount(userInfo.getUser(), currUser.getUsername(), cPassword);
			}
		} else {
			newUser = new Users();
			newUser = service.updateAccount(userInfo.getUser(), currUser.getUsername(), currUser.getPassword()); 
		}
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		session.setAttribute("user", newUser);
		out.print(mapper.writeValueAsString(newUser));
	}
}
