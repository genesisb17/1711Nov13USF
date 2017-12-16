package com.rev.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rev.pojos.Reimbursement;
import com.rev.pojos.User;
import com.rev.service.Service;

@WebServlet("/rowToResolve")
public class PopulateRowToResolveServlet extends HttpServlet {
	Service service = new Service();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		Reimbursement r=(Reimbursement) session.getAttribute("reimbCurrent");
		
		//change type to words
		int type=r.getTypeId();
		String strType="";
		switch (type) {
		case 1:
			strType="Lodging";
			break;
		case 2:
			strType="Travel";
			break;
		case 3:
			strType="Food";
			break;
		case 4:
			strType="other";
			break;
		}
		
		//change author to name
		int authId=r.getAuthor();
		User authUser=service.getUserById(authId);
		String authName=authUser.getFn()+" "+authUser.getLn();
		
		String row=
				"<td id=\"id\">"+r.getId()+"</td>"
				+"<td>"+r.getAmount()+"</td>"
				+"<td>"+r.getSubmitted()+"</td>"
				+"<td>"+r.getDescription()+"</td>"
				+"<td>"+authName+"</td>"
				+"<td>"+strType+"</td>";
		PrintWriter pw=resp.getWriter();
		pw.write(row);
	}
}
