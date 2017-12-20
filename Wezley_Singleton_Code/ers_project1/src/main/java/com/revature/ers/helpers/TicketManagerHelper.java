package com.revature.ers.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.pojos.Reimbursement;
import com.revature.ers.pojos.User;
import com.revature.ers.service.Service;

public class TicketManagerHelper {

	public int process(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("[LOG] - Processing request with LoadInfoHelper: " + request.getRequestURI());
		
		Service service = new Service();
		HttpSession session;
		User user;

		switch(request.getRequestURI()) {

		case "/ers/approve.ticketmanager":
			session = request.getSession();
			user = (User) session.getAttribute("user");
			try {
				BufferedReader br;
				br = new BufferedReader(new InputStreamReader(request.getInputStream()));

				String json = "";
				if(br != null) {
					json = br.readLine();
				}

				ObjectMapper mapper = new ObjectMapper();
				int reimbId = mapper.readValue(json, Integer.class);

				return service.updateReimbursementStatusById(reimbId, 1, user.getUserId()).getStatusId();


			} catch (IOException ioe) {
				ioe.printStackTrace();
			}

		case "/ers/deny.ticketmanager":
			session = request.getSession();
			user = (User) session.getAttribute("user");
			try {
				BufferedReader br;
				br = new BufferedReader(new InputStreamReader(request.getInputStream()));

				String json = "";
				if(br != null) {
					json = br.readLine();
				}

				ObjectMapper mapper = new ObjectMapper();
				int reimbId = mapper.readValue(json, Integer.class);

				return service.updateReimbursementStatusById(reimbId, 2, user.getUserId()).getStatusId();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}

		case "/ers/close.ticketmanager":
			session = request.getSession();
			user = (User) session.getAttribute("user");
			try {
				BufferedReader br;
				br = new BufferedReader(new InputStreamReader(request.getInputStream()));

				String json = "";
				if(br != null) {
					json = br.readLine();
				}

				ObjectMapper mapper = new ObjectMapper();
				int reimbId = mapper.readValue(json, Integer.class);
				service.closeOpenTicket(reimbId);
				
				return service.updateReimbursementStatusById(reimbId, 4, user.getUserId()).getStatusId();
				
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			
		case "/ers/open.ticketmanager":
			session = request.getSession();
			user = (User) session.getAttribute("user");
			try {
				BufferedReader br;
				br = new BufferedReader(new InputStreamReader(request.getInputStream()));

				String json = "";
				if(br != null) {
					json = br.readLine();
				}

				ObjectMapper mapper = new ObjectMapper();
				Reimbursement newReimb = mapper.readValue(json, Reimbursement.class);
				
				newReimb.setAuthorId(user.getUserId());

				return service.openNewReimbursementTicket(newReimb).getStatusId();
				
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			
		case "/ers/update.ticketmanager":
			session = request.getSession();
			user = (User) session.getAttribute("user");
			try {
				BufferedReader br;
				br = new BufferedReader(new InputStreamReader(request.getInputStream()));

				String json = "";
				if(br != null) {
					json = br.readLine();
				}

				ObjectMapper mapper = new ObjectMapper();
				Reimbursement updatedReimb = mapper.readValue(json, Reimbursement.class);
				
				updatedReimb.setAuthorId(user.getUserId());

				return service.updatePendingReimbursementTicket(updatedReimb).getReimbursementId();
				
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
		return 0;
	}
}
