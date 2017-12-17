package com.reimb.servlets;

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
import com.reimb.pojos.User;
import com.reimb.service.Service;

@WebServlet("/validator")
public class validator extends HttpServlet {
	Service service= new Service();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		if(br != null){
			json = br.readLine();
		}

		ObjectMapper mapper = new ObjectMapper();

		String[] userInfo = mapper.readValue(json, String[].class);
		String username = userInfo[0]; 
		User temp = service.findUser(username);
		if(temp.getId() == 0){ // if invalid user, obj = null
			}
		else{// valid credentials
			HttpSession session = req.getSession();
			session.setAttribute("User", temp);//persist this user to the session to be accessed throughout servlets
		}
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");

		String userJSON = mapper.writeValueAsString(temp);

		out.write(userJSON);   
	}	

}
