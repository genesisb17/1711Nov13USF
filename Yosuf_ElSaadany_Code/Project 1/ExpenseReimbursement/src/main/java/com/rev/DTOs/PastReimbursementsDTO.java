package com.rev.DTOs;

import java.util.ArrayList;

import com.rev.pojos.Reimbursement;
import com.rev.pojos.User;

public class PastReimbursementsDTO {
	
	private User user;
	private ArrayList<Reimbursement> pastReimbursments;
	
	public PastReimbursementsDTO() {}

	public PastReimbursementsDTO(User user, ArrayList<Reimbursement> pastReimbursments) {
		super();
		this.user = user;
		this.pastReimbursments = pastReimbursments;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList<Reimbursement> getPastReimbursments() {
		return pastReimbursments;
	}

	public void setPastReimbursments(ArrayList<Reimbursement> pastReimbursments) {
		this.pastReimbursments = pastReimbursments;
	}

	@Override
	public String toString() {
		return "PastReimbursementsDTO [user=" + user + ", pastReimbursments=" + pastReimbursments + "]";
	}
	
}
