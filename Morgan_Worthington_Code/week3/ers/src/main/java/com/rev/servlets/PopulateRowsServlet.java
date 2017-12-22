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

		HttpSession session=req.getSession();
		User u=(User) session.getAttribute("user");
		int userId=u.getId();

		int stat=0;
		if(status.equals("pending")) {
			stat=1;
		} else if (status.equals("accepted")) {
			stat=2;
		} else if (status.equals("denied")) {
			stat=3;
		} else {
			System.out.println("Not an acceptable status of request.");
		}

		ArrayList<Reimbursement> reimbs=service.getReimbursementsByRole(role, userId);
		for(Reimbursement r:reimbs) {
			if(r.getStatusId()==stat) {
				String tRow="<tr value=\""+
						r.getStatusId()+
						"\" id=\""+
						r.getId()
						+"\">";;
				//the event listener for the row is in this first row data cell for id
				//if the user is a manager
				if(role.equals("1") && stat==1) {
					tRow+="<td>"
							+"<script>"
							+"$(\"#"+r.getId()+"\").on('click',function(){"
							+"var id="+r.getId()+";"
							+"updateReimbursement(id)});"
							+"</script>"
							+r.getId()
							+"</td>";
				} else {
					tRow+="<td>"+r.getId()+"</td>";
				}
				
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
					strType="Other";
					break;
				}
				
				
				//change author and resolver to names
				int authId=r.getAuthor();
				int resolverId=r.getResolver();
				User authUser=service.getUserById(authId);
				User resUser=service.getUserById(resolverId);
				String authName=authUser.getFn()+" "+authUser.getLn();
				String resName="--";
				if(resolverId!=0) {
					resName=resUser.getFn()+" "+resUser.getLn();
				}
				if(role.equals("1")) {
					tRow+="<td>"+r.getAmount()+"</td>";
					tRow+="<td>"+r.getSubmitted()+"</td>";
					
					if(stat==1) {
						tRow+="<td> -- </td>";
					} else {
						tRow+="<td>"+r.getResolved()+"</td>";
					}
					
					tRow+="<td>"+r.getDescription()+"</td>";
					tRow+="<td>"+authName+"</td>";
					tRow+="<td>"+resName+"</td>";
					tRow+="<td>"+strType+"</td>";
				} else {
					tRow+="<td>"+r.getAmount()+"</td>";
					tRow+="<td>"+r.getSubmitted()+"</td>";
					
					if(stat==1) {
						tRow+="<td> -- </td>";
					} else {
						tRow+="<td>"+r.getResolved()+"</td>";
					}
					
					tRow+="<td>"+r.getDescription()+"</td>";
					tRow+="<td>"+resName+"</td>";
					tRow+="<td>"+strType+"</td>";
				}
				tRow+="</tr>";
				pw.write(tRow);
			}
		}	
	}
}
