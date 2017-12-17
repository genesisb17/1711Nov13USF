package com.rev.project1.service;

import java.sql.Timestamp;

import com.rev.project1.dao.ERSDao;
import com.rev.project1.dao.ERSDaoImpl;
import com.rev.project1.domain.ReimbStatus;
import com.rev.project1.domain.ReimbType;
import com.rev.project1.domain.Reimbursement;
import com.rev.project1.domain.User;

public class FormatTickets {
	static ERSDao dao = new ERSDaoImpl();
	
	public String userView(Reimbursement r) {
		String reimbType = reimbType(r.getReimbTypeId());
		
		String reimbStatus = reimbStatus(r.getReimbStatusId());
		
		String resolver = userName(r.getReimbResolver());
		
		String createdDate = formatDate(r.getReimbSubmitted());
		String resolvedDate = formatDate(r.getReimbResolved());
		
		String descrip = getDescrip(r.getReimbDescription());
		
		String json = "{\"ReimbID\":" + r.getReimbId() + ", \"CreatedDate\":" + "\"" + createdDate + "\"" +
				", \"ReimbType\":" + "\"" + reimbType + "\"" + ", \"Amount\":" + r.getReimbAmount() + ", \"Description\":" +
				"\""+ descrip +"\"" + ", \"ReimbStatus\": " + "\"" + reimbStatus + "\"" +
				", \"ReDate\":" + "\"" + resolvedDate + "\"" + ", \"Resolver\":" + "\"" +resolver + "\"}";
		
		return json;
	}

	public String manView(Reimbursement r) {
		
		String requester = userName(r.getReimbAuthor());
		String createdDate = formatDate(r.getReimbSubmitted());
		String resolvedDate = formatDate(r.getReimbResolved());
		String reimbType = reimbType(r.getReimbTypeId());
		String descrip = getDescrip(r.getReimbDescription());
		String reimbStatus = reimbStatus(r.getReimbStatusId());
		String resolver = userName(r.getReimbResolver());	
		
		String json = "{\"ReimbID\":" + r.getReimbId() + ",\"Requester\":" + "\"" + requester + "\"" +
				", \"CreatedDate\":" +"\"" + createdDate + "\"" +", \"ReimbType\":" + "\"" + reimbType + "\"" +
				", \"Amount\":" + r.getReimbAmount() + ", \"Description\":" + "\""+ descrip +"\"" + ", \"ReimbStatus\": " +
				"\"" + reimbStatus + "\"" + ", \"ReDate\":" + "\"" + resolvedDate + "\"" + ", \"Resolver\":" + "\"" +resolver + "\"}";
		
//		String json = "{\"ReimbID\":" + r.getReimbId() + ",\"Requester\":" + "\"" + requester + "\"" +
//				", \"CreatedDate\":" +"\"" + createdDate + "\"" +", \"ReimbType\":" + "\"" + reimbType + "\"" +
//				", \"Amount\":" + r.getReimbAmount() + ", \"Description\":" + "\""+ descrip +"\"" + ", \"ReimbStatus\": " +
//				"\"" + reimbStatus + "\"" + ", \"ReDate\":" + "\"" + resolvedDate + "\"" + ", \"Resolver\":" + "\"" +resolver + 
//				"\"" + ", \"Command\":" + "\"\"" + "\"}";
		return json;
		
	}
	
	public String reimbType(int typeId) {
		String reimbType;
		
		if(typeId == ReimbType.FOOD.getTypeId()) {
			reimbType = ReimbType.FOOD.toString();
		} else if(typeId == ReimbType.LODGING.getTypeId()) {
			reimbType = ReimbType.LODGING.toString();
		} else if(typeId == ReimbType.OTHER.getTypeId()) {
			reimbType = ReimbType.OTHER.toString();
		} else {
			reimbType = ReimbType.TRAVEL.toString();
		}

		return reimbType;
	}
	
	public String reimbStatus(int statusId) {
		String status;
		
		if(statusId == ReimbStatus.APPROVED.getStatusId()) {
			status = ReimbStatus.APPROVED.toString();
		} else if(statusId == ReimbStatus.DENIED.getStatusId()) {
			status = ReimbStatus.DENIED.toString();
		} else {
			status = ReimbStatus.PENDING.toString();
		}		
		return status;
	}
	
	public String userName(int userId) {
		String user = "-";
		if(userId != 0) {
			User u = dao.getUserById(userId);
			user = u.getFirstname() + " " + u.getLastname();
		}
		return user;
	}
	
	public String formatDate(Timestamp time) {	
		String date = "-";
		if(time != null) {
			date = String.format("%1$TD %1$TT", time);
		}
		return date;
	}
	
	public String getDescrip(String descrip) {
		String description = "-";
		if(descrip != null) {
			description = descrip;
		}
		return description;
	}
}
