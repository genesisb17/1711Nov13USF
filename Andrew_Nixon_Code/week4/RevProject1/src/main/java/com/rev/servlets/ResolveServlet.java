package com.rev.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.pojos.ERSUser;
import com.rev.pojos.Reimbursement;
import com.rev.service.Service;

@WebServlet("/resolve")
public class ResolveServlet extends HttpServlet {
	static Service service = new Service();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		if(br != null){
			json = br.readLine();
		}
		ObjectMapper mapper = new ObjectMapper();
		Reimbursement r = mapper.readValue(json, Reimbursement.class);
		Reimbursement temp = service.validateReimbursement(r.getReimbID());
		HttpSession session = req.getSession();
		ERSUser user = (ERSUser) session.getAttribute("user");
		if(temp.getReimbID() == 0) {
			temp = null;
		}
		else {
			if (temp.getStatusID() != 21) {
				temp.setReimbID(-1);
			}
			else {
				temp = service.resolve(r.getReimbID(), user.getUserID(), r.getStatusID() );
			}
		}
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		
		String reimbJSON = mapper.writeValueAsString(temp);
		out.write(reimbJSON);

	}

}
