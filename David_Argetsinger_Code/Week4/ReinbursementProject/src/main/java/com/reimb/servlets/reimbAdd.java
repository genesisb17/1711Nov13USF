package com.reimb.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimb.pojos.Reimburse;
import com.reimb.pojos.User;
import com.reimb.service.Service;

@WebServlet("/reimbAdd")
public class reimbAdd extends HttpServlet
{
	static Service service = new Service();
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Please register servlet");
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(request.getInputStream()));
		String json = "";
		if(br != null){
			json = br.readLine();
		}
		ObjectMapper mapper = new ObjectMapper();
		Reimburse reimb = mapper.readValue(json, Reimburse.class);
		// need to fill in the current user for the author 
		HttpSession session = request.getSession();
		User ogU=(User)session.getAttribute("user");
		// grab session user to append to the json 
		reimb.setAuthor(ogU.getId());
		reimb.setStatus(0);
		service.addReim(reimb);
	
	}
}
