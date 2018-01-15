package com.reimb.servlets;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimb.pojos.Reimburse;
import com.reimb.pojos.ReimburseLog;
import com.reimb.pojos.User;
import com.reimb.service.Service;

@WebServlet("/viewAdminTable")
public class viewAdminTables extends HttpServlet {
	static Service service = new Service();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {

		try{
			if(request.getSession(false) != null){//if session exists. 
				HttpSession session = request.getSession(false);
				User ogU = (User)session.getAttribute("user");
				if(ogU.getRole()==0) // only work if admin yeaaaaah 
				{
					ArrayList<ReimburseLog> temp= service.adminRiembs();
					PrintWriter out = response.getWriter();
					response.setContentType("application/json");
					ObjectMapper mapper = new ObjectMapper();
					String ticketsJSON = mapper.writeValueAsString(temp);
					out.write(ticketsJSON);
				}
			}
		}catch (NullPointerException e){
		}


	}	
}

