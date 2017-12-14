package com.rev.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.pojos.Reimbursement;
import com.rev.pojos.User;
import com.rev.service.Service;

@WebServlet("/populateRows")
public class PopulateRowsServlet extends HttpServlet {

	Service service=new Service();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader br=req.getReader();
		PrintWriter pw=resp.getWriter();
		String json="";
		if(br!=null) {
			json=br.readLine();
		}
		ObjectMapper om= new ObjectMapper();
		JsonNode tableKind=om.readTree(json);
		String role=tableKind.get("role").asText();
		String status=tableKind.get("status").asText();
		
		System.out.println("Why does this run twice? The status of the reimbursements is "+status);
		
		HttpSession session=req.getSession();
		User u=(User) session.getAttribute("user");
		int userId=u.getId();
		
		ArrayList<Reimbursement> reimbs=service.getReimbursementsByRole(role, userId);
		if(status.equals("pending")) {
			for(Reimbursement r:reimbs) {
				if(r.getStatusId()==1) {
					String tRow="<tr value=\""+
							r.getStatusId()+
							"\" id=\""+
							r.getId()
							+"\">";
					tRow+="<td>"+r.getId()+"</td>";
					tRow+="<td>"+r.getAmount()+"</td>";
					tRow+="<td>"+r.getSubmitted()+"</td>";
					tRow+="<td>"+r.getResolved()+"</td>";
					tRow+="<td>"+r.getDescription()+"</td>";
					tRow+="<td>"+r.getAuthor()+"</td>";
					tRow+="<td>"+r.getStatusId()+"</td>";
					tRow+="<td>"+r.getTypeId()+"</td>";
					tRow+="</tr>";
					pw.write(tRow);
				}
			}
		} else {
			for(Reimbursement r:reimbs) {
				if(r.getStatusId()!=1) {
					String tRow="<tr value=\""+
							r.getStatusId()+
							"\" id=\""+
							r.getId()
							+"\">";
					tRow+="<td>"+r.getId()+"</td>";
					tRow+="<td>"+r.getAmount()+"</td>";
					tRow+="<td>"+r.getSubmitted()+"</td>";
					tRow+="<td>"+r.getResolved()+"</td>";
					tRow+="<td>"+r.getDescription()+"</td>";
					tRow+="<td>"+r.getResolver()+"</td>";
					tRow+="<td>"+r.getStatusId()+"</td>";
					tRow+="<td>"+r.getTypeId()+"</td>";
					tRow+="</tr>";
					pw.write(tRow);
				}
			}
		}
	}
}
