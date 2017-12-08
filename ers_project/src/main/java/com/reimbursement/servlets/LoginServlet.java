package com.reimbursement.servlets;

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

import com.reimbursement.pojos.Employee;
import com.reimbursement.services.Services;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       static Services service = new Services();
    /**
     * @see HttpServlet#HttpServlet()
     */
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("in login servlet");
		// 1. get received JSON data from request
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(request.getInputStream()));
		String json = "";
		if(br != null){
			json = br.readLine();
		}
		System.out.println("JSON STRING: " + json);

		// 2. initiate jackson mapper
		ObjectMapper mapper = new ObjectMapper();

		//// 3. Convert received JSON to String array
		String[] userInfo = mapper.readValue(json, String[].class);
		String username = userInfo[0];
		String password = userInfo[1];
		

		Employee temp = service.validateUser(username); // get user by uname
		if(temp == null){ // if invalid user, obj = null
			System.out.println("temp is null");
			
		}
		else if(!temp.getPassword().equals(password)){ // if invalid pw, id = 0;
			temp.setUserId(0);
			temp.setPassword(null); //set all user fields to null;
		}
		else{// valid credentials
			HttpSession session = request.getSession();
			session.setAttribute("user", temp);//persist this user to the session to be accessed throughout servlets
		}
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		
		String userJSON = mapper.writeValueAsString(temp);
		System.out.println("JSON: " + userJSON);
		out.write(userJSON);
	}
}
