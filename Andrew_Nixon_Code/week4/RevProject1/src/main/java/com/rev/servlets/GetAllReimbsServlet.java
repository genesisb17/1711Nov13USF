package com.rev.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.dtos.UserReimbursementDTO;
import com.rev.pojos.Reimbursement;
import com.rev.service.Service;

@WebServlet("/getAllReimbs")
public class GetAllReimbsServlet extends HttpServlet {
	static Service service = new Service();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<Reimbursement> reimbs = service.getAllReumbs();
		ArrayList<UserReimbursementDTO> reimbsDTO = new ArrayList<UserReimbursementDTO>();
		for(Reimbursement r: reimbs) {
			UserReimbursementDTO temp = new UserReimbursementDTO(r);
			reimbsDTO.add(temp);
		}
		ObjectMapper mapper = new ObjectMapper();
		resp.setContentType("application/json");
		String json = mapper.writeValueAsString(reimbsDTO);
		PrintWriter out = resp.getWriter();
		out.write(json);
	}

}
