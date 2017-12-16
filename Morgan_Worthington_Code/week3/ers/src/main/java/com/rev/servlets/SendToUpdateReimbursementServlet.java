package com.rev.servlets;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rev.pojos.Reimbursement;
import com.rev.service.Service;

@WebServlet("/updateReimbursement")
public class SendToUpdateReimbursementServlet extends HttpServlet {
	
	Service service=new Service();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader br=req.getReader();
		String rId="";
		if(br!=null) {
			rId=br.readLine();
		} else {
			System.out.println("No reimbursement ID was sent.");
		}
		
		if(!rId.equals("")) {
			HttpSession session=req.getSession();
			Reimbursement r=service.getReimbursementById(Integer.parseInt(rId));
			session.setAttribute("reimbCurrent", r);
			req.getRequestDispatcher("partials/updateReimbursement.html").forward(req, resp);
		}
	}
}
