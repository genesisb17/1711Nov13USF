package com.rev.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.dtos.UserReimbursementDTO;
import com.rev.pojos.ERSUser;
import com.rev.pojos.Reimbursement;
import com.rev.service.Service;

@WebServlet("/getReimbByAuthor")
public class GetReimbByAuthorServlet extends HttpServlet{
	static Service service = new Service();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		ERSUser user = (ERSUser) session.getAttribute("user");
		ArrayList<Reimbursement> reimbs = service.getReimbsByAuthor(user.getUserID());
		ArrayList<UserReimbursementDTO> reimbsDTO = new ArrayList<UserReimbursementDTO>();
		for(Reimbursement r: reimbs) {
			UserReimbursementDTO temp = new UserReimbursementDTO(r);
			reimbsDTO.add(temp);
		}
		//if ((user != null) && (reimbs != null) && (!reimbs.isEmpty())) {
		if ((user != null)) {
			ObjectMapper mapper = new ObjectMapper();
			resp.setContentType("application/json");
			String json = mapper.writeValueAsString(reimbsDTO);

			PrintWriter out = resp.getWriter();
			out.write(json);
		} //else if ((user != null) && (reimbs != null) && (reimbs.isEmpty())){} 
		else {
			resp.setStatus(418);
		}
		
	}

}
