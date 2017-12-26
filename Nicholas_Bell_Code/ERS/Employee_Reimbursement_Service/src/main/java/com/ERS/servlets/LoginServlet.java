package com.ERS.servlets;

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

import com.ERS.pojos.User;
import com.ERS.service.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class LoginServelet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Service service = new Service();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/*
	 *
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		
		String JSON = br.readLine();
		
		System.out.println("JSON = " + JSON);
		// 2. initiate jackson mapper
		ObjectMapper mapper = new ObjectMapper();

		//// 3. Convert received JSON to String array
		String[] userInfo = mapper.readValue(JSON, String[].class);
		String identify = userInfo[0];
		String password = userInfo[1];
		String flag = 	  userInfo[2];		
		User currentUser = new User();
		//returns null if username not found
		//returns fully populated user otherwise
		
		if (flag.equals("user")) {
		currentUser = service.getUserbyUN(identify);
		}
		else if(flag.equals("email")) {
		currentUser = service.getUserbyEMAIL(identify);	
		}
		System.out.println(flag+ " " + currentUser);
		
		if(currentUser == null){ 
			System.out.println("temp is null");
		}
		else if(!currentUser.getPassword().equals(password)){ 
			//sets ID to 0, null's all other fields
			currentUser.clearData();
		}
		else{// valid credentials
			HttpSession session = request.getSession();
			session.setAttribute("user", currentUser);//persist to session
		}
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
				
			String userJSON = mapper.writeValueAsString(currentUser);
			System.out.println("JSON: " + userJSON);
			out.write(userJSON);
		
	}

}
