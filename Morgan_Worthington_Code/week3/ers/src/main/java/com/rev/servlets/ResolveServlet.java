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
import com.rev.pojos.User;
import com.rev.service.Service;

@WebServlet("/resolve")
public class ResolveServlet extends HttpServlet {

	Service service=new Service();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader br= req.getReader();
		String strNewStatus="1";
		if(br!=null) {
			strNewStatus=br.readLine();
			int newStat=Integer.parseInt(strNewStatus);
			HttpSession session=req.getSession();
			Reimbursement r=(Reimbursement) session.getAttribute("reimbCurrent");
			int rId=r.getId();
			User u=(User) session.getAttribute("user");
			int resolver=u.getId();
			service.updateReimbursement(rId, newStat, resolver);
		} else {
			System.out.println("New Status not sent.");
		}
		
	}
}
