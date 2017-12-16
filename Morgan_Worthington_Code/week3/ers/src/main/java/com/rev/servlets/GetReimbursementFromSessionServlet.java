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

@WebServlet("/toResolve")
public class GetReimbursementFromSessionServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		Reimbursement reimbursement=(Reimbursement) session.getAttribute("currentReimb");
		String json=reimbursement.toString();
		PrintWriter pw=resp.getWriter();
		pw.write(json);
	}
}
