package com.ex.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.pojo.User;
import com.rev.service.Service;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet
{
	private static final long serialVersionUID =1L;
	static Service service = new Service();

	/*@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(name +" "+ password);
		
		Enumeration<String> paraNames = request.getParameterNames();
		
		PrintWriter out = response.getWriter();
		out.print("<h1>Welcome "+name+"!</h1>");
		while(paraNames.hasMoreElements())
		{
			String param =paraNames.nextElement();
			String val = request.getParameter(param);
			System.out.println(param+": "+val);
		}
	}*/
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{

		//use AJAX
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		String first = request.getParameter("first");
		String last = request.getParameter("last");
		String email = request.getParameter("email");
		String r = request.getParameter("role");
		int role = Integer.parseInt(r);
		
		User u1 =new User();
		
		u1.setFirstname(first);
		u1.setLastname(last);
		u1.setUsername(name);
		u1.setPassword(password);
		u1.setEmail(email);
		service.adders_users(name,password, first, last, email, role);
		//service.geters_users(u1.getUsername(), u1.getPassword());
		PrintWriter out = response.getWriter();
		out.println(u1.getLastname()+" "+u1.getFirstname());
		out.println("test");

	}
}
// 1. get received JSON data from request
/*		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
String json = "";
if (br != null) 
{
	json = br.readLine();
}

// 2. initiate jackson mapper
ObjectMapper mapper = new ObjectMapper();
//
String[] userInfo = mapper.readValue(json, String[].class);
String name = userInfo[1];
String password = userInfo[5];
String first = userInfo[2];
String last = userInfo[3];
String email = userInfo[4];
String r = userInfo[6];
int role = Integer.parseInt(r);
*/
//System.out.println(name+first+last+role);