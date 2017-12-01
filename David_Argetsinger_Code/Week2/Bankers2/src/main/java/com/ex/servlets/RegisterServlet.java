package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.service.Service;
import com.ex.service.Service1;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	 String name = request.getParameter("username");
	String password = request.getParameter("password");
	System.out.println("User "+name+" Password "+ password);
	Enumeration<String>paramNames=request.getParameterNames();
	while(paramNames.hasMoreElements()){
		String param=paramNames.nextElement();
		String val=request.getParameter(param);
		
		System.out.println(param+" "+ val);
	}
//	PrintWriter out = response.getWriter();
//	out.print("<h1> wecleom "+ name+ " !</h1>" );
}
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	Service1 service = new Service1();
	String username = request.getParameter("username");
//	service.addUser(username); // change it from accepting a scanner. 

	PrintWriter out = response.getWriter();
	ArrayList<String> users = service.getUsers(); // if the servicelayer had an array of users 
	String userlist="<ul>";
	for(String u : users)
		userList=userList + "<li>"+u+"</li>";
	userList=userList + "</ul>";
	PrintWriter out = responce.getWriter();
	out.println(userList);
	
	
	
}
	
// other way to do sevlet
}