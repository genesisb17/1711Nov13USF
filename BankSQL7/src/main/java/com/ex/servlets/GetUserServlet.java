package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.pojo.newUser;

@WebServlet("/getUserInfo")
public class GetUserServlet extends HttpServlet 
{
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException
	{
		HttpSession session = req.getSession();
		newUser user = (newUser)session.getAttribute("user");
		System.out.println(user);
		if(user!=null)
		{
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(user);
	
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			out.write(json);
		}
		else
		{
			resp.setStatus(418);
		}
	}
}