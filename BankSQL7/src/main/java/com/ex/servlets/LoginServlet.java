package com.ex.servlets;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.service.Service;

@WebServlet("/login")
public class LoginServlet extends HttpServlet
{
	static Service service = new Service();
	@Override
	protected void doPost(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException ,java.io.IOException 
	{
		System.out.println("in login Servlet");
		//1. get received json data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json ="";
		if(br!=null)
		{
			json = br.readLine();
		}

		System.out.println("JSON: "+json);
		//2. Initiate jackson mapper
		ObjectMapper mapper =new ObjectMapper();
		//3. Convert received JSON to String array
		String[] user = mapper.readValue(json, String[].class);
		String username = user[0];
		String password = user[1];
		System.out.println(username);
		
		
		//4. Set response type to json
		resp.setContentType("application/json");
	}
}