package com.reimb.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reimb.pojos.User;
//import com.reimb.service.DemoService;
import com.reimb.service.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/login")
public class login extends HttpServlet {
	static Service service = new Service();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
System.out.println("in login servlet");

		
		// 1. get received JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
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
		

		User temp = service.loginValidate(username); // get user by uname
		if(temp == null){ // if invalid user, obj = null
			System.out.println("temp is null");
		}
		else if(!temp.getPassword().equals(password)){ // if invalid pw, id = 0;
			temp.setId(0);
		}
		else{// valid credentials
			HttpSession session = req.getSession();
			session.setAttribute("user", temp);//persist this user to the session to be accessed throughout servlets
			//req.getRequestDispatcher("members.html").forward(req, resp);
		}
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
	
		String userJSON = mapper.writeValueAsString(temp);
		
		
		//redirect based on role from sesssion 
		// can redirect to other  servlets - such as frontcontroller based on role 
		
		out.write(userJSON);
		
		   
	}

}


